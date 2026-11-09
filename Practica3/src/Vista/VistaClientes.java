package Vista;

import Modelo.GestorClientes;
import javax.swing.*;
import java.awt.*;

public class VistaClientes extends JFrame {

    private JPanel panelPrincipal;
    private PanelVisualizar panelVisualizar;
    private PanelNuevoJPanel panelNuevo;

    public VistaClientes() {
        super("Gestion de Clientes");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);
        setResizable(false);
        setLocationRelativeTo(null);

        panelVisualizar = new PanelVisualizar();
        panelNuevo = new PanelNuevoJPanel(new GestorClientes());

        panelPrincipal = new JPanel(new BorderLayout());
        add(panelPrincipal);

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem visualizar = new JMenuItem("Visualizar");
        JMenuItem nuevo = new JMenuItem("Nuevo");
        JMenuItem salir = new JMenuItem("Salir");

        menu.add(visualizar);
        menu.add(nuevo);
        menu.addSeparator();
        menu.add(salir);

        barra.add(menu);
        setJMenuBar(barra);

        visualizar.addActionListener(e -> mostrarVisualizar());
        nuevo.addActionListener(e -> mostrarNuevo());
        salir.addActionListener(e -> System.exit(0));

        mostrarVisualizar();
    }

    public void mostrarVisualizar() {
        panelPrincipal.removeAll();
        panelPrincipal.add(panelVisualizar, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    public void mostrarNuevo() {
        panelPrincipal.removeAll();
        panelPrincipal.add(panelNuevo, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    public PanelVisualizar getPanelVisualizar() {
        return panelVisualizar;
    }

    public PanelNuevoJPanel getPanelNuevo() {
        return panelNuevo;
    }
}
