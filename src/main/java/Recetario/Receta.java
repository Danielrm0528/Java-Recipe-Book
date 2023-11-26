package Recetario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Receta implements Serializable {
    private String nombre;
    private float duracion;
    private float porciones;
    private String descripcion;
    private Dificultad dificultad;
    private ArrayList<IngredienteReceta> ingredientes;
    private ArrayList<Utensilio> utensilios;
    private ArrayList<Etiqueta> etiquetas;
    
    private ArrayList<String> getNombreIngredientes() {
        ArrayList<String> l = new ArrayList();
        for(IngredienteReceta i:ingredientes) {
            l.add(i.getIngrediente().getNombre());
        }
        return l;
    }
            
            
    public Receta(String nombre) {
        this.nombre = nombre;
        ingredientes = new ArrayList<>();
        utensilios = new ArrayList<>();
        etiquetas = new ArrayList<>();
        dificultad = Dificultad.FACIL;
        duracion = 0;
        porciones = 0;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public float getPorciones() {
        return porciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }
    

    public void setPorciones(float porciones) {
        this.porciones = porciones;
    }
    

    public float getDuracion() {
        return duracion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public boolean hasEtiqueta(Etiqueta etiqueta) {
        return etiquetas.contains(etiqueta);
    }

    public void agregarIngrediente(String cantidad, Ingrediente ingrediente) throws Exception {
        if(getNombreIngredientes().contains(ingrediente.getNombre())) {
            throw new Exception("Ingrediente ya se encuentra en la receta");
        }
        ingredientes.add(new IngredienteReceta(ingrediente, cantidad));
    }
    
    public void eliminarIngrediente(Ingrediente ingrediente) throws Exception {
        for(IngredienteReceta i: ingredientes) {
            if(i.getIngrediente() == ingrediente) {
                ingredientes.remove(i);
                return;
            }
        }
        throw new Exception("Ingrediente no existe");
    }

    public void agregarUtensilio(Utensilio utensilio) throws Exception {
        if (utensilios.contains(utensilio))
            throw new Exception("Utensilio ya se encuentra en la receta");
        utensilios.add(utensilio);
    }
    
    public void eliminarUtensilio(Utensilio utensilio) throws Exception {
        if(utensilios.contains(utensilio)) {
          utensilios.remove(utensilio);
          return;
        }
        throw new Exception("Utensilio no existe");
    }

    public void agregarEtiqueta(Etiqueta etiqueta) throws Exception {
        if (etiquetas.contains(etiqueta))
            throw new Exception("Etiqueta ya se encuentra en la receta");
        etiquetas.add(etiqueta);
    }

    public void eliminarEtiqueta(Etiqueta etiqueta) throws Exception {
        if(etiquetas.contains(etiqueta)) {
          etiquetas.remove(etiqueta);
          return;
        }
        throw new Exception("Etiqueta no existe");
    }

    public Map<String,String> getIngredientes() {
        Map<String,String> ingredienteCantidad = new HashMap();
        for (IngredienteReceta i: ingredientes) {
            ingredienteCantidad.put(i.getIngrediente().getNombre(), i.getCantidad());
        }
        return ingredienteCantidad;
    }
    
    public ArrayList<String> getUtensilios() {
        ArrayList<String> utensilios = new ArrayList();
        for (Utensilio u: this.utensilios) {
            utensilios.add(u.getNombre());
        }
        return utensilios;
    }
    
    public ArrayList<String> getEtiquetas() {
        ArrayList<String> etiquetas = new ArrayList();
        for (Etiqueta e: this.etiquetas) {
            etiquetas.add(e.getEtiqueta());
        }
        return etiquetas;
    }
}
