package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import Modelo.Cliente;

public class PanelVisualizar extends JPanel {

    private JLabel lblNumero;
    private JLabel lblNombre;
    private JLabel lblPuntos;
    private JLabel lblFecha;
    private JLabel lblPosicion;

    private JButton btnPrimero;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnUltimo;
    private JButton btnBorrar;

    public PanelVisualizar() {
        setLayout(new BorderLayout(10, 10));

        lblPosicion = new JLabel("", SwingConstants.CENTER);
        add(lblPosicion, BorderLayout.NORTH);

        JPanel datos = new JPanel(new GridLayout(4, 2, 10, 10));

        datos.add(new JLabel("Edad:"));
        lblNumero = new JLabel();
        datos.add(lblNumero);
        
        datos.add(new JLabel("Nombre:"));
        lblNombre = new JLabel();
        datos.add(lblNombre); 

        datos.add(new JLabel("Puntos:"));
        lblPuntos = new JLabel();
        datos.add(lblPuntos);

        datos.add(new JLabel("Fecha nacimiento:"));
        lblFecha = new JLabel();
        datos.add(lblFecha);

        add(datos, BorderLayout.CENTER);

        JPanel botones = new JPanel();

        btnPrimero = new JButton("Primero");
        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
        btnUltimo = new JButton("Ultimo");
        btnBorrar = new JButton("Borrar");

        botones.add(btnPrimero);
        botones.add(btnAnterior);
        botones.add(btnSiguiente);
        botones.add(btnUltimo);
        botones.add(btnBorrar);

        add(botones, BorderLayout.SOUTH);
    }

    public void mostrarCliente(Cliente c, int posicion, int total) {
        if (c == null) {
            lblNumero.setText("");
            lblNombre.setText("");
            lblPuntos.setText("");
            lblFecha.setText("");
            lblPosicion.setText("No hay clientes");
        } else {
            lblNumero.setText(String.valueOf(c.getNumero()));
            lblNombre.setText(c.getNombre());
            lblPuntos.setText(String.valueOf(c.getPuntos()));
            lblFecha.setText(c.getFechaNacimiento().toString());
            lblPosicion.setText("Cliente " + posicion + " de " + total);
        }
    }

    public void setNavegacion(boolean puedeAnterior, boolean puedeSiguiente) {
        btnPrimero.setEnabled(puedeAnterior);
        btnAnterior.setEnabled(puedeAnterior);
        btnUltimo.setEnabled(puedeSiguiente);
        btnSiguiente.setEnabled(puedeSiguiente);
        btnBorrar.setEnabled(puedeAnterior || puedeSiguiente);
    }

    public void addPrimeroListener(ActionListener l) {
        btnPrimero.addActionListener(l);
    }

    public void addAnteriorListener(ActionListener l) {
        btnAnterior.addActionListener(l);
    }

    public void addSiguienteListener(ActionListener l) {
        btnSiguiente.addActionListener(l);
    }

    public void addUltimoListener(ActionListener l) {
        btnUltimo.addActionListener(l);
    }

    public void addBorrarListener(ActionListener l) {
        btnBorrar.addActionListener(l);
    }
}
