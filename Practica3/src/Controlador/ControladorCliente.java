package Controlador;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import Modelo.Cliente;
import Modelo.GestorClientes;
import Vista.PanelNuevoJPanel;
import Vista.PanelVisualizar;
import Vista.VistaClientes;

public class ControladorCliente {

    private final GestorClientes modelo;
    private final VistaClientes vista;

    public ControladorCliente(GestorClientes modelo, VistaClientes vista) {
        this.modelo = modelo;
        this.vista = vista;

        PanelVisualizar panel = vista.getPanelVisualizar();
        PanelNuevoJPanel panelNuevo = vista.getPanelNuevo();

        panel.addPrimeroListener(e -> {
            modelo.irPrimero();
            mostrar();
        });

        panel.addAnteriorListener(e -> {
            modelo.retroceder();
            mostrar();
        });

        panel.addSiguienteListener(e -> {
            modelo.avanzar();
            mostrar();
        });

        panel.addUltimoListener(e -> {
            modelo.irUltimo();
            mostrar();
        });

        panel.addBorrarListener(e -> {
            modelo.borrarActual();
            mostrar();
        });

        panelNuevo.addGuardarListener(e -> guardarCliente());

        mostrar();
    }

    private void mostrar() {
        PanelVisualizar panel = vista.getPanelVisualizar();
        Cliente c = modelo.getActual();

        int posicion = c == null ? 0 : modelo.getIndiceActual() + 1;

        panel.mostrarCliente(c, posicion, modelo.total());

        boolean hayAnterior = modelo.getIndiceActual() > 0;
        boolean haySiguiente = !modelo.esVacia()
                && modelo.getIndiceActual() < modelo.total() - 1;

        panel.setNavegacion(hayAnterior, haySiguiente);
    }

    private void guardarCliente() {
        PanelNuevoJPanel panel = vista.getPanelNuevo();

        try {
            int numero = Integer.parseInt(panel.getNumero());
            String nombre = panel.getNombre();
            float puntos = Float.parseFloat(panel.getPuntos());
            LocalDate fecha = LocalDate.parse(panel.getFecha());

            if (numero <= 0) {
                panel.mostrarError("El numero debe ser positivo");
                return;
            }

            if (!ControlErrores.comprobarNombre(nombre)) {
                panel.mostrarError("El nombre es obligatorio");
                return;
            }

            if (!ControlErrores.comprobarPuntos(puntos)) {
                panel.mostrarError("Los puntos deben estar entre 0 y 1000");
                return;
            }

            if (!ControlErrores.comprobarFecha(fecha)) {
                panel.mostrarError("La fecha debe estar entre 1900 y 2015");
                return;
            }

            for (Cliente c : modelo) {
                if (c.getNumero() == numero) {
                    panel.mostrarError("Ese numero de cliente ya existe");
                    return;
                }
            }

            Cliente nuevo = new Cliente(numero, nombre, puntos, fecha);
            modelo.anadir(nuevo);

            panel.limpiar();
            panel.mostrarCorrecto("Cliente guardado correctamente");
            mostrar();

        } catch (NumberFormatException e) {
            panel.mostrarError("Numero o puntos incorrectos");
        } catch (DateTimeParseException e) {
            panel.mostrarError("Fecha incorrecta. Usa AAAA-MM-DD");
        }
    }
}
