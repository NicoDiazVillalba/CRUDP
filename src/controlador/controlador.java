package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasPelicula;
import modelo.Pelicula;
import vista.vistaPrincipal;

public class controlador {

    private Pelicula peli;
    private vistaPrincipal vista;
    private ConsultasPelicula peliConsulta;

    public controlador(Pelicula peli, vistaPrincipal vista, ConsultasPelicula peliConsulta) {
        this.peli = peli;
        this.vista = vista;
        this.peliConsulta = peliConsulta;
        this.vista.setVisible(true);

        accionarBotones();
    }

    private void accionarBotones() {
        this.vista.botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar(evt);
            }

        });

        this.vista.botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar(evt);
            }

        });

        this.vista.botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar(evt);
            }

        });

        this.vista.botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar(evt);
            }

        });

        this.vista.botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar(evt);
            }

        });

    }

    private void agregar(java.awt.event.ActionEvent evt) {
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

    private void modificar(java.awt.event.ActionEvent evt) {
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

    private void eliminar(java.awt.event.ActionEvent evt) {
        peli.setId(Integer.parseInt(vista.entradaID.getText()));

        if (peliConsulta.eliminar(peli)) {
            JOptionPane.showMessageDialog(vista, "Producto eliminado");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al eliminar");
            limpiar();
        }

    }

    private void buscar(java.awt.event.ActionEvent evt) {
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

    private void limpiar(java.awt.event.ActionEvent evt) {
        limpiar();
    }

    private void limpiar() {
        vista.entradaID.setText(null);
        vista.entradaNombre.setText(null);
        vista.entradaGenero.setText(null);
        vista.entradaAño.setText(null);
        vista.entradaDirector.setText(null);
        vista.entradaPais.setText(null);
    }

}
