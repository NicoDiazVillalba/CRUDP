package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasPelicula extends Conexion {

    public boolean registrar(Pelicula objetoPeli) {

        PreparedStatement ps = null;
        Connection con = realizarConexion();
        String sql = "insert into peliculas (nombre,genero,año,director,pais) values(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, objetoPeli.getNombre());
            ps.setString(2, objetoPeli.getGenero());
            ps.setInt(3, objetoPeli.getAño());
            ps.setString(4, objetoPeli.getDirector());
            ps.setString(5, objetoPeli.getPais());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(Pelicula objetoPeli) {

        PreparedStatement ps = null;
        Connection con = realizarConexion();
        String sql = "update peliculas set nombre=?, genero=?, año=?, director=?,pais=? where id=?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, objetoPeli.getNombre());
            ps.setString(2, objetoPeli.getGenero());
            ps.setInt(3, objetoPeli.getAño());
            ps.setString(4, objetoPeli.getDirector());
            ps.setString(5, objetoPeli.getPais());
            ps.setInt(6, objetoPeli.getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Error");
            return false;
        }
    }

    public boolean eliminar(Pelicula objetoPeli) {

        PreparedStatement ps = null;
        Connection con = realizarConexion();
        String sql = "delete from peliculas where id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, objetoPeli.getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Error");
            return false;
        }
    }

    public boolean buscar(Pelicula objetoPeli) {

        PreparedStatement ps = null;
        Connection con = realizarConexion();
        String sql = "select * from peliculas where id=?";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, objetoPeli.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                objetoPeli.setId(Integer.parseInt(rs.getString("id")));
                objetoPeli.setNombre(rs.getString("nombre"));
                objetoPeli.setGenero(rs.getString("genero"));
                objetoPeli.setAño(Integer.parseInt(rs.getString("año")));
                objetoPeli.setDirector(rs.getString("director"));
                objetoPeli.setPais(rs.getString("pais"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error");
            return false;
        }
    }
}
