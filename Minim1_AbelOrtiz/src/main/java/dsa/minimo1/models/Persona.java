package dsa.minimo1.models;

import java.util.*;

public class Persona {

    //Parametros
    private String id;
    private String name;
    private String surname;
    private int edad;
    private String valoracion;
    List<Muestra> muestrasUsuario;

    //Constructores
    public Persona(String id, String name, String surname,int edad,String valoracion){
        muestrasUsuario = new LinkedList<Muestra>();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.edad = edad;
        this.valoracion = valoracion;
    }
    public Persona(){
        //Empty Constructor Initialization for second cases
    }

    //FUNCIONES

    //Obtener numero de X de un XXX
    public int getNumMuestras(){

        return this.muestrasUsuario.size();
    }
    // Obtener lista X de un XXX
    public List<Muestra> getListaClase2(){

        return muestrasUsuario;

    }
    //Obtener X de XXX
    public Muestra getX(int index){

        return this.muestrasUsuario.get(index);

    }
    //Añadir lista de X a XXX
    public void setListaCasos(List<Muestra> muestras){
        muestrasUsuario = muestras;
    }

    //Añadir X a XXX
    public Muestra addMuestra (Muestra muestra){
        try{
            this.muestrasUsuario.add(muestra);
            return muestra;
        }
        catch (ExceptionInInitializerError e)
        {
            return null;
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }

    }

    //para cada parametro
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getValoracion(){
        return valoracion;
    }

    public void setValoracion(String valoracion){
        this.valoracion=valoracion;
    }
    //Returns in string format the user
    @Override
    public String toString(){
        return "ID: " + this.getId() + " | Name: " + this.getName() + " | Surname: " + this.getSurname() + "Edad:"+edad+ " valoracion:" +valoracion;
    }



}

