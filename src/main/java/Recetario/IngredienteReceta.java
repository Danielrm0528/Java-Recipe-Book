package Recetario;

import java.io.Serializable;

public class IngredienteReceta implements Serializable {
    private Ingrediente ingrediente;
    private String cantidad;

    public IngredienteReceta(Ingrediente ingrediente, String cantidad) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return " ";
    }
}
