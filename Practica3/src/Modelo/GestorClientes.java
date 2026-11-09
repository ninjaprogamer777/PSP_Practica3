package Modelo;

import java.util.ArrayList;
import java.util.Comparator;

public class GestorClientes extends ArrayList<Cliente> {

    private int actual;

    public GestorClientes() {
        actual = 0;
    }

    public boolean esVacia() {
        return isEmpty();
    }

    public void avanzar() {
        if (!isEmpty() && actual < size() - 1) {
            actual++;
        }
    }

    public void retroceder() {
        if (!isEmpty() && actual > 0) {
            actual--;
        }
    }

    public void irPrimero() {
        if (!isEmpty()) {
            actual = 0;
        }
    }

    public void irUltimo() {
        if (!isEmpty()) {
            actual = size() - 1;
        }
    }

    public boolean esPrimero() {
        return !isEmpty() && actual == 0;
    }

    public boolean esUltimo() {
        return !isEmpty() && actual == size() - 1;
    }

    public Cliente getActual() {
        if (isEmpty()) {
            return null;
        }
        return get(actual);
    }

    public int getIndiceActual() {
        return actual;
    }

    public void anadir(Cliente cliente) {
        add(cliente);
        ordenar();
        actual = indexOf(cliente);
    }

    public void borrarActual() {
        if (!isEmpty()) {
            remove(actual);

            if (isEmpty()) {
                actual = 0;
            } else if (actual >= size()) {
                actual = size() - 1;
            }
        }
    }

    public void ordenar() {
        sort(Comparator.comparingInt(Cliente::getNumero));

        if (isEmpty()) {
            actual = 0;
        } else if (actual >= size()) {
            actual = size() - 1;
        }
    }

    public int total() {
        return size();
    }
}