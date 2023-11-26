package Recetario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Controladora implements Serializable {
    private ArrayList<Ingrediente> ingredientes;
    private ArrayList<Receta> recetas;
    private ArrayList<Utensilio> utensilios;
    private ArrayList<Etiqueta> etiquetas;
    private static Controladora instance = null;
    public Controladora() {
        ingredientes = new ArrayList<>();
        recetas = new ArrayList<>();
        utensilios = new ArrayList<>();
        etiquetas = new ArrayList<>();
    }
    
    
    private void noExisteIng (String nombre) throws Exception {
        if(verListaIngredientes().containsKey(nombre))
            throw new Exception("Ingrediente ya existe");
    }

    private Ingrediente obtenerIngrediente(String nombre) throws Exception {
        for(Ingrediente i : ingredientes) {
            if(i.getNombre().equalsIgnoreCase(nombre))
                return i;
        }
        throw new Exception("Ingrediente no existe");
    }

    private void noExisteUten (String nombre) throws Exception {
        if(verListaUtensilios().containsKey(nombre))
            throw new Exception("Utensilio ya existe");
    }

    private Utensilio obtenerUtensilio(String nombre) throws Exception {
        for(Utensilio u : utensilios) {
            if(u.getNombre().equalsIgnoreCase(nombre))
                return u;
        }
        throw new Exception("Utensilio no existe");
    }
    
    private void noExisteReceta(String nombre) throws Exception {
        if(verListaRecetas().contains(nombre))
            throw new Exception("Receta ya existe");
    }

    private Receta obtenerReceta(String nombre) throws Exception {
       for(Receta r : recetas) {
            if(r.getNombre().equalsIgnoreCase(nombre))
                return r;
        }
        throw new Exception("Receta no existe");
    }
    
    private void noExisteEtiqueta(String etiqueta) throws Exception {
        if(verListaEtiquetas().contains(etiqueta))
            throw new Exception("Etiqueta ya existe");
    }

    private Etiqueta obtenerEtiqueta(String etiqueta) throws Exception {
       for(Etiqueta e : etiquetas) {
            if(e.getEtiqueta().equalsIgnoreCase(etiqueta))
                return e;
        }
        throw new Exception("Etiqueta no existe");
    }
    
    public static Controladora getInstance() {
        if(instance == null) {
            try {
                cargarDatos();
            } catch (Exception e) {
                instance = new Controladora();
            }
        }
        return instance;  
    }
    
    public Map<String,Boolean> verListaIngredientes() {
        Map<String, Boolean> res = new HashMap<>();
        for(Ingrediente i: ingredientes) {
            res.put(i.getNombre(),i.getDisponibilidad());
        }
        return res;
    }
    public void agregarIngrediente(String nombre) throws Exception {
        noExisteIng(nombre);
        ingredientes.add(new Ingrediente(nombre));
    }

    public void editarIngrediente(String nombreViejo, String nombreNuevo) throws Exception {
        Ingrediente i = obtenerIngrediente(nombreViejo);
        i.setNombre(nombreNuevo);
    }
    
    public void eliminarIngrediente(String nombre) throws Exception {
        Ingrediente i = obtenerIngrediente(nombre);
        for(Receta r: recetas) {
            if(r.getIngredientes().containsKey(i.getNombre())) {
                throw new Exception("Ingrediente se encuentra en uso por una receta");
            }
        }
        ingredientes.remove(i);
    }

    public void cambiarDisponibilidadIng(String nombre, boolean disponible) throws Exception {
        Ingrediente i = obtenerIngrediente(nombre);
        i.setDisponibilidad(disponible);
    }

    public Map<String,Boolean> verListaUtensilios() {
        Map<String,Boolean> res = new HashMap();
        for(Utensilio u: utensilios) {
            res.put(u.getNombre(),u.getDisponibilidad());
        }
        return res;
    }

    public void agregarUtensilio(String nombre) throws Exception {
        noExisteUten(nombre);
        utensilios.add(new Utensilio(nombre));
    }

    public void editarUtensilio(String nombreViejo, String nombre) throws Exception {
        noExisteUten(nombre);
        Utensilio u = obtenerUtensilio(nombreViejo);
        u.setNombre(nombre);
    }
    
    public void eliminarUtensilio(String nombre) throws Exception {
        Utensilio u = obtenerUtensilio(nombre);
        for(Receta r: recetas) {
            if(r.getUtensilios().contains(u.getNombre())) {
                throw new Exception("Utensilio se encuentra en uso por una receta");
            }
        }
        utensilios.remove(u);
    }

    public void cambiarDisponibilidadUten(String nombre, boolean disponible) throws Exception {
        Utensilio u = obtenerUtensilio(nombre);
        u.setDisponibilidad(disponible);
    }

    public ArrayList<String> verListaRecetas() {
        ArrayList<String> res = new ArrayList<>();
        for(Receta r: recetas) {
            res.add(r.getNombre());
        }
        return res;
    }
    
    public void agregarReceta(String nombre) throws Exception {
        if ("".equals(nombre)) {
            throw new Exception("Nombre no puede estar vacio");
        }
        noExisteReceta(nombre);
        recetas.add(new Receta(nombre));
    }
    public void eliminarReceta(String nombre) throws Exception {
        Receta r = obtenerReceta(nombre);
        recetas.remove(r);
    }
    
    public void agregarIngredienteReceta(String nombreIng, String cantidad, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        Ingrediente i = obtenerIngrediente(nombreIng);
        r.agregarIngrediente(cantidad, i);
    }
    
    public void eliminarIngredienteReceta(String nombreIng, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        Ingrediente i = obtenerIngrediente(nombreIng);
        r.eliminarIngrediente(i);
    }
    
    public Map<String,String> verListaIngredientesReceta(String receta) throws Exception {
        Receta r = obtenerReceta(receta);
        return r.getIngredientes();
        
    }
    
    public void agregarUtensilioReceta(String nombreUten, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        Utensilio u = obtenerUtensilio(nombreUten);
        r.agregarUtensilio(u);
    }
    
    public void eliminarUtensilioReceta(String nombreUten, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        Utensilio u = obtenerUtensilio(nombreUten);
        r.eliminarUtensilio(u);
    }
    
    public ArrayList<String> verListaUtensiliosReceta(String receta) throws Exception {
        Receta r = obtenerReceta(receta);
        return r.getUtensilios();
        
    }
    
    
    public ArrayList<String> verListaEtiquetas() {
        ArrayList<String> res = new ArrayList<>();
        for(Etiqueta e: etiquetas) {
            res.add(e.getEtiqueta());
        }
        return res;
    }
    
    public void agregarEtiqueta(String nombre) throws Exception {
        noExisteEtiqueta(nombre);
        etiquetas.add(new Etiqueta(nombre));
    }
    
    public void agregarEtiquetaReceta(String nombreEtiqueta, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        Etiqueta e = obtenerEtiqueta(nombreEtiqueta);
        r.agregarEtiqueta(e);
    }
    
   public void eliminarEtiquetaReceta(String nombreEtiqueta, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        Etiqueta e = obtenerEtiqueta(nombreEtiqueta);
        r.eliminarEtiqueta(e);
    }
    
    public ArrayList<String> verListaEtiquetasReceta(String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        return r.getEtiquetas();
    }
    
    public void setProcedimiento(String procedimiento, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        r.setDescripcion(procedimiento);
    }
    
    public String getProcedimiento(String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
       return r.getDescripcion();
    }
    
    public void setDuracion(float duracion, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        r.setDuracion(duracion);
    }
    
    public float getDuracion(String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
       return r.getDuracion();
    }
    
    public void setPorciones(float porciones, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        r.setPorciones(porciones);
    }
    
    public float getPorciones(String nombreReceta) throws Exception {
       Receta r = obtenerReceta(nombreReceta);
       return r.getPorciones();
    }
    public void setDificultad(String dificultad, String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        switch(dificultad) {
            case "Facil":
                r.setDificultad(Dificultad.FACIL);
                break;
            case "Medio":
                r.setDificultad(Dificultad.MEDIO);
                break;
            case "Dificil":
                r.setDificultad(Dificultad.DIFICIL);
                break;
            case "Experto":
                r.setDificultad(Dificultad.EXPERTO);
                break;    
        }
        
    } 
    
    public String getDificultad(String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        return r.getDificultad().toString();
        
    }
    
    public void editarNombreReceta(String nuevoNombre,String nombreViejo) throws Exception {
        Receta r = obtenerReceta(nombreViejo);
        r.setNombre(nuevoNombre);
    }
    
    public Map<String, Integer> filtrarDuracion(int selec) throws Exception {
        Map<String, Integer> recetasOrdenadas = verListaRecetasOrdenadasFaltante();
        List<String> llavesBorrar = new ArrayList<>();
        
        switch (selec) {
            case 1:
                for(String s:recetasOrdenadas.keySet()) {
                    Receta receta = obtenerReceta(s);
                    if(receta.getDuracion() >= 30)
                        llavesBorrar.add(s);
                }   
                break;
            case 2:
                for(String s:recetasOrdenadas.keySet()) {
                    Receta receta = obtenerReceta(s);
                    if(receta.getDuracion() < 30 || receta.getDuracion() >= 60)
                        llavesBorrar.add(s);
                }
                break;
            default:
                for(String s:recetasOrdenadas.keySet()) {
                    Receta receta = obtenerReceta(s);
                    if (receta.getDuracion() < 60)
                        llavesBorrar.add(s);
                }
                break;
        }
        
        for (String s : llavesBorrar) {
            recetasOrdenadas.remove(s);
        }
        
        return recetasOrdenadas;
    }

    public Map<String, Integer> filtrarDificultad(Dificultad dificultad) throws Exception {
        Map<String, Integer> recetasOrdenadas = verListaRecetasOrdenadasFaltante();
        List<String> llavesBorrar = new ArrayList<>();
         
        for(String s:recetasOrdenadas.keySet()) {
            Receta receta = obtenerReceta(s);
            if(receta.getDificultad() != dificultad)
                llavesBorrar.add(s);
        }
        
        for (String s : llavesBorrar) {
            recetasOrdenadas.remove(s);
        }
        
        return recetasOrdenadas;
    }

    public Map<String, Integer> filtrarEtiqueta(String nombreEtiqueta) throws Exception {
        Etiqueta etiqueta = obtenerEtiqueta(nombreEtiqueta);
        Map<String, Integer> recetasOrdenadas = verListaRecetasOrdenadasFaltante();
        List<String> llavesBorrar = new ArrayList<>();
        
        for(String s:recetasOrdenadas.keySet()) {
            Receta receta = obtenerReceta(s);
            if(!receta.hasEtiqueta(etiqueta))
                llavesBorrar.add(s);
        }
        
        for (String s : llavesBorrar) {
            recetasOrdenadas.remove(s);
        }
        
        return recetasOrdenadas;
    }
    
    private int obtenerFaltantes(String nombreReceta) throws Exception {
        Receta r = obtenerReceta(nombreReceta);
        int faltan = 0;
        for(String s:r.getIngredientes().keySet()) {
            Ingrediente i = obtenerIngrediente(s);
            if(!i.getDisponibilidad()) 
                faltan++;  
        }
        for(String s:r.getUtensilios()) {
            Utensilio u = obtenerUtensilio(s);
            if(!u.getDisponibilidad()) 
                faltan++; 
        }
        return faltan;
    }
    
    public Map<String, Integer> verListaRecetasOrdenadasFaltante() throws Exception {
        Map<String,Integer> recetasOrdenadas = new LinkedHashMap();
        for(String s: verListaRecetas()) {
            int faltan = obtenerFaltantes(s);
            recetasOrdenadas.put(s, faltan); 
          }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(recetasOrdenadas.entrySet());
        Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue));
        Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }
        return mapaOrdenado;
    }
    
    public static void guardarDatos() throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("data.dat");
        ObjectOutputStream stream = new ObjectOutputStream(file);
        stream.writeObject(instance);
        stream.close();
        file.close();
    }

    public static void cargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("data.dat");
        ObjectInputStream stream = new ObjectInputStream(file);
        instance = (Controladora) stream.readObject();
        if(instance == null) {
            instance = new Controladora();
        }
        stream.close();
        file.close();
    }

}