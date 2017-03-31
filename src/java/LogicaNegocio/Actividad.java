/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

/**
 *
 * @author Usuario
 */

public class Actividad {
       String id_actividad;
       String nombre;
       String periodo;
       String porcentaje;
       String id_materia;
       
       public Actividad(String ID, String nombre,String Period, String Percent, Materia mat)
       {
           this.periodo = Period;
           this.id_actividad = ID;
           this.nombre = nombre;
           this.porcentaje = Percent;
           this.id_materia = mat.getId();
       }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
       
}
