package Recetario;

import java.io.Serializable;

public class Etiqueta implements Serializable {
    private String etiqueta;
    
    Etiqueta(String nombre) {
        etiqueta = nombre;
    }
    public String getEtiqueta() {
        return etiqueta;
    }

}
