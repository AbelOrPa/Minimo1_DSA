package dsa.minimo1;

import java.util.*;
import dsa.minimo1.models.*;

public interface Covid19Manager {

    // XXX = Objeto clase1
    // X = objeto clase2
    //Añadir un XXX con parametros
    public Persona addPerson(String id, String name, String surname,int edad,String valoracion);
    //Añadir un XXX con objeto
    public Persona addPerson2(String id , Persona persona);
    //Añadir X a XXX con objeto
    public Muestra addMuestra(String key, Muestra c);

    //Mostrar lista de muestras de un usuario
    public List<Muestra> mostrarMuestras(String key);
    //Analizar muestar en laboratorio
    public Muestra procesarMuestra(String nombreLab);
    //Enviar muestra a laboratorio
    public Muestra enviarMuestra(Muestra g, String nombreLab);

    //Funcion creada para usar en test y servicios//

    public HashMap<String,Persona> mostrarPersonas();

    public Persona getPersona(String id);

    public int numPersonas();








}
