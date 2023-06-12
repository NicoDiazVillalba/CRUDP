
package controlador;

import modelo.Conexion;
import modelo.ConsultasPelicula;
import modelo.Pelicula;
import vista.vistaPrincipal;

public class CRUDP {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.realizarConexion();
       
        Pelicula peli = new Pelicula();
        vistaPrincipal mivista = new vistaPrincipal();
        ConsultasPelicula consulta = new ConsultasPelicula();
        controlador objetoControlador = new controlador(peli, mivista,consulta);
    }
    
}
