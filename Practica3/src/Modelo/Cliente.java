package Modelo;

import java.time.LocalDate;

/** MODELO: un cliente con nombre y edad. No sabe nada de Swing. */
public class Cliente {
    private int numero;
    private String nombre;
    private float puntos;
    private LocalDate fechaNacimiento;

    public Cliente(int numero, String nombre, float puntos, LocalDate fechaNacimiento) {
        setNumero(numero);
        setNombre(nombre);
        setPuntos(puntos);
        setFechaNacimiento(fechaNacimiento);
        
    }

    public int getNumero() { return numero; }
    public String getNombre() { return nombre; }
    public float getPuntos() { return puntos; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    // Las reglas de negocio viven en el modelo
    public void setNumero(int numero) {
        if (numero < 0)
            throw new IllegalArgumentException("El número no puede ser negativo.");
        this.numero = numero;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        this.nombre = nombre.trim();
    }
    
    public void setPuntos(float puntos) {
        if (puntos < 0)
            throw new IllegalArgumentException("Los puntos no pueden ser negativos.");
        this.puntos = puntos;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null)
            throw new IllegalArgumentException("La fecha no puede estar vacía.");
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente nº " + numero + ": " + nombre + "(" + fechaNacimiento + "), " + puntos + " puntos.";
    }
}
