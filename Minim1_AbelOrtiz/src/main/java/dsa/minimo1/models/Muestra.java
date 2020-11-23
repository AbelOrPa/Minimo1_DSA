package dsa.minimo1.models;

public class Muestra {

    //Parametros
    private String id;
    private String idClinico;
    private String idPersona;
    private String idLab;
    private int dia;
    private int mes;
    private int año;
    private String estado;
    private String comentario;


    //Constructores
    public Muestra(String id,String idClinico,String idPersona, String idLab, int dia,int mes, int año,String estado,String comentario){

        this.id = id;
        this.idClinico = idClinico;
        this.idPersona = idPersona;
        this.idLab = idLab;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.estado = estado;
        this.comentario = comentario;

    }
    public Muestra(){}


    public String getId(){return id;}
    public String getIdClinico(){return idClinico;}
    public String getIdPersona(){return idPersona;}
    public String getIdLab(){return idLab;}
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAño(){
        return año;
    }
    public String getEstado(){return estado;}
    public String getComentario(){return comentario;}
    public void setIdClinico(String idClinico){this.idClinico = idClinico;}
    public void setId(String id){this.id =id;}
    public void setIdPersona(String idPersona){this.idPersona = idPersona;}
    public void setIdLab(String idLab){this.idLab = idLab;}
    public void setDia(int dia){this.dia=dia;}
    public void setMes(int mes){this.mes=mes;}
    public void setAño(int año){this.año=año;}
    public void setEstado(String estado){this.estado = estado;}
    public void setComentario(String comentario){this.comentario = comentario;}


}
