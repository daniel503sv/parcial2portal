/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

/**
 *
 * @author Daniel
 */
public class Alumno_Actividad {
    String id;
    String id_actividad;
    String carnet;
    String nota;
    
    public Alumno_Actividad(String ID,Alumno alum,Actividad act,String nota)
    {
       this.id = ID;
       this.id_actividad = act.getId_actividad();
       this.carnet = alum.getCarne();
       this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
}
