package Recetario;

import java.io.Serializable;

public enum Dificultad implements Serializable {
    FACIL,MEDIO,DIFICIL,EXPERTO;

    @Override
    public String toString() {
        switch (this) {
            case FACIL: {
                return "Facil";
            }
            case MEDIO: {
                return "Medio";
            }
            case DIFICIL: {
                return "Dificil";
            }
            case EXPERTO: {
                return "Experto";
            }
            default: {
                return "Dificiltad invalida";
            }

        }
    }
}
