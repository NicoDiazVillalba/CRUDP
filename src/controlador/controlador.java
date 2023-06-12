package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasPelicula;
import modelo.Pelicula;
import vista.vistaPrincipal;

public class controlador implements ActionListener {

    private Pelicula peli;
    private vistaPrincipal vista;
    private ConsultasPelicula peliConsulta;

    public controlador(Pelicula peli, vistaPrincipal vista, ConsultasPelicula peliConsulta) {
        this.peli = peli;
        this.vista = vista;
        this.peliConsulta = peliConsulta;
        this.vista.setVisible(true);
        this.vista.botonAgregar.addActionListener(this);
        this.vista.botonModificar.addActionListener(this);
        this.vista.botonEliminar.addActionListener(this);
        this.vista.botonBuscar.addActionListener(this);
        this.vista.botonLimpiar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.botonAgregar) {
            peli.setNombre(vista.entradaNombre.getText());
            peli.setGenero(vista.entradaGenero.getText());
            peli.setAño(Integer.parseInt(vista.entradaAño.getText()));
            peli.setDirector(vista.entradaDirector.getText());
            peli.setPais(vista.entradaPais.getText());

            if (peliConsulta.registrar(peli)) {
                JOptionPane.showMessageDialog(vista, "Producto Agregado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar");
                limpiar();
            }
        }

        if (e.getSource() == vista.botonModificar) {
            peli.setId(Integer.parseInt(vista.entradaID.getText()));
            peli.setNombre(vista.entradaNombre.getText());
            peli.setGenero(vista.entradaGenero.getText());
            peli.setAño(Integer.parseInt(vista.entradaAño.getText()));
            peli.setDirector(vista.entradaDirector.getText());
            peli.setPais(vista.entradaPais.getText());

            if (peliConsulta.modificar(peli)) {
                JOptionPane.showMessageDialog(vista, "Producto modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al modificar");
                limpiar();
            }
        }

        if (e.getSource() == vista.botonEliminar) {
            peli.setId(Integer.parseInt(vista.entradaID.getText()));

            if (peliConsulta.eliminar(peli)) {
                JOptionPane.showMessageDialog(vista, "Producto eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al eliminar");
                limpiar();
            }
        }

        if (e.getSource() == vista.botonBuscar) {
            peli.setId(Integer.parseInt(vista.entradaID.getText()));

            if (peliConsulta.buscar(peli)) {
                vista.entradaID.setText(String.valueOf(peli.getId()));
                vista.entradaNombre.setText(peli.getNombre());
                vista.entradaGenero.setText(peli.getGenero());
                vista.entradaAño.setText(String.valueOf(peli.getAño()));
                vista.entradaDirector.setText(peli.getDirector());
                vista.entradaPais.setText(peli.getPais());
            } else {
                JOptionPane.showMessageDialog(vista, "Error al buscar");
                limpiar();
            }
        }
        
        if (e.getSource() == vista.botonLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.entradaID.setText(null);
        vista.entradaNombre.setText(null);
        vista.entradaGenero.setText(null);
        vista.entradaAño.setText(null);
        vista.entradaDirector.setText(null);
        vista.entradaPais.setText(null);
    }

}
