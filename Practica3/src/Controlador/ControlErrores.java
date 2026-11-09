package Controlador;

import java.time.LocalDate;

public class ControlErrores {

    public static boolean comprobarPuntos(float puntos) {
        return puntos >= 0 && puntos <= 1000;
    }

    public static boolean comprobarFecha(LocalDate fecha) {
        if (fecha == null) {
            return false;
        }

        LocalDate minimo = LocalDate.of(1900, 1, 1);
        LocalDate maximo = LocalDate.of(2015, 12, 31);

        return !fecha.isBefore(minimo) && !fecha.isAfter(maximo);
    }

    public static boolean comprobarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}
