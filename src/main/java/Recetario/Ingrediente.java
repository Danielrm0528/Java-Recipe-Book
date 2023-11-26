package Recetario;

import java.io.Serializable;

public class Ingrediente implements Serializable {
    private String nombre;
    private boolean disponibilidad;
    public Ingrediente(String nombre) {
        this.nombre = nombre;
        disponibilidad = false;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return " ";
    }
}
