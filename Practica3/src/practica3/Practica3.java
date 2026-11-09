package practica3;

import Controlador.ControladorCliente;
import Modelo.Cliente;
import Modelo.GestorClientes;
import Vista.VistaClientes;

import java.time.LocalDate;
import javax.swing.SwingUtilities;

public class Practica3 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            GestorClientes modelo = new GestorClientes();

            modelo.anadir(new Cliente(1, "Amador Moreno", 250, LocalDate.of(1995, 5, 10)));

            modelo.anadir(new Cliente(2, "Adán Morales", 500, LocalDate.of(2001, 7, 14)));

            modelo.anadir(new Cliente(3, "Enrique Apellido", 900, LocalDate.of(2004, 1, 3)));

            VistaClientes vista = new VistaClientes();

            new ControladorCliente(modelo, vista);

            vista.setVisible(true);
        });
    }
}
