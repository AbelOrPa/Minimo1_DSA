package dsa.minimo1.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Laboratorio {

    private Queue<Muestra> muestrasAnalizar;
    private String idLab;
    private String nombre;
    public int suerte = 0;

    public Laboratorio (String idLab, String nombre){

        this.idLab = idLab;
        this.nombre = nombre;
        this.muestrasAnalizar = new Queue<Muestra>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Muestra> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Muestra muestra) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Muestra> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean offer(Muestra muestra) {
                return false;
            }

            @Override
            public Muestra remove() {
                return null;
            }

            @Override
            public Muestra poll() {
                return null;
            }

            @Override
            public Muestra element() {
                return null;
            }

            @Override
            public Muestra peek() {
                return null;
            }
        };


    }

    public String getIdLab(){
        return idLab;
    }
    public String getNombre(){
        return nombre;
    }
    public Queue<Muestra> getMuestrasAnalizar(){
        return muestrasAnalizar;
    }

    public void setMuestrasAnalizar (Queue<Muestra> muestrasAnalizar){
        this.muestrasAnalizar = muestrasAnalizar;
    }
    public void setIdLab (String idLab){
        this.idLab=idLab;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public Muestra añadirMuestra(Muestra p){
        try{
            muestrasAnalizar.add(p);
            return p;
        }
        catch (ExceptionInInitializerError e){
            return null;
        }

    }

    public Muestra analizarMuestra(){
        Muestra muestraAProcesar = muestrasAnalizar.poll();
        if (suerte/2==0) {
            muestraAProcesar.setEstado("Positivo");
            muestraAProcesar.setComentario("Debes permanecer en cuarentena 10 dias");
        }
        else{
            muestraAProcesar.setEstado("Negativo");
            muestraAProcesar.setComentario("Buenas noticias, eres negativo");
        }
        suerte++;

        return muestraAProcesar;
    }
}


