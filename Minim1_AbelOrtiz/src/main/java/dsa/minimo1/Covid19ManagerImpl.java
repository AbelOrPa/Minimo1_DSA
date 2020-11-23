package dsa.minimo1;

import org.apache.log4j.Logger;
import dsa.minimo1.models.*;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {

    // Singleton implementation
    private static Covid19Manager instance;


    protected HashMap<String, Persona> personas;
    protected Laboratorio[] laboratorios;


    private Covid19ManagerImpl() {
        this.personas = new HashMap<>();
        this.laboratorios = new Laboratorio[100];
        laboratorios[0]= new Laboratorio("1","LaboratorioDSA");

    }

    public static Covid19Manager getInstance(){
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }

    //log4j para mensajes informativos
    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    //FUNCIONES

    //Añadir persona obteniendo parametros
    public Persona addPerson(String id, String name, String surname,int edad,String valoracion) {
        Persona x = new Persona(id,name,surname,edad,valoracion);
        try {
            personas.put(id,x);

            logger.info("Usuario añadido: " + x);
            return x;

        }
        catch (IllegalArgumentException e) {
            logger.error("Formato incorrecto");
            return null;

        }
        catch (IndexOutOfBoundsException e) {
            logger.error("HashMap completo");
            return null;
        }
    }
    //añadir Persona recibiendo Objeto completo
    public Persona addPerson2(String id, Persona y) {
        try{
            personas.put(id,y);

            logger.info("Usiario añadido: " + y);
            return y;

        }
        catch (IndexOutOfBoundsException e){
            logger.error("HashMap completo");
            return null;

        }
        catch (IllegalArgumentException e){
            logger.error("Formato incorrecto");
            return null;

        }
    }
    //Devolver lista de muestras de una persona
    public List<Muestra> mostrarMuestras(String id) {

        Persona personaObservada = personas.get(id);
        List<Muestra> listaMuestras = personaObservada.getListaClase2();
        return listaMuestras;
    }
    //Añadir una muestra a uan persona
    public Muestra addMuestra(String id, Muestra c) {

        logger.info("Nueva muestra " + c);
        Persona personaActu = personas.get(id);

        if (personaActu != null && c != null) {
            Muestra se = personaActu.addMuestra(c);
            if (se != null) {
                logger.info("Muestra añadida a persona " + personaActu.getName() + " : " + personaActu.getSurname());
                return se;
            } else {
                logger.error("Error al añadir la muestra");
                return null;
            }
        }
        else{
            return null;
        }

    }

    //Funcion analiza muestra en laboratorio deseado (segun nombre)

    public Muestra procesarMuestra(String nombreLab) {
        logger.info("Nueva muestra a procesar ");
        try {
            for (Laboratorio h : this.laboratorios) {
                if (h.getNombre() == nombreLab) {
                    Muestra d = h.analizarMuestra();
                    String idPersonaAnalizada = d.getIdPersona();
                    Persona personaAnalizada = personas.get(idPersonaAnalizada);
                    personaAnalizada.addMuestra(d);

                    logger.info("Muestra analizada correctamente"+d);
                    return d;
                }
            }
            return null;
        }
        catch (IllegalArgumentException e){
            logger.error("Error al analizar la muestra");
            return null;

        }

    }
    //Funcion que envia muestra a laboratorio segun el nombre
    public Muestra enviarMuestra(Muestra g,String nombreLab) {
        try {
            for (Laboratorio h : this.laboratorios) {
                if (h.getNombre() == nombreLab) {
                    h.añadirMuestra(g);
                    logger.info("Muestra añadida correctamente" + g);
                    return g;
                }
            }
            return null;
        } catch (IllegalArgumentException e) {
            logger.error("Error al añadir la muestra");
            return null;
        }
    }


    //Funciones para test y servicios
    public HashMap<String, Persona> mostrarPersonas() {
        return personas;
    }
    public int numPersonas() {
        return this.personas.size();
    }
    public Persona getPersona(String id) {
        Persona o = this.personas.get(id);
        if(o!=null){
            logger.info("Persona: " + o);
        }else{
            logger.error("Persona no localizada: "+id);
        }
        return o;
    }

}