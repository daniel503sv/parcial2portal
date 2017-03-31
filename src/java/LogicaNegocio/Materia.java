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
public class Materia {
    
    String id;
    String nombre;
    String id_profesor_idx;
    
    public Materia(String ID,String Nombre, Profesor prof)
    {
        this.id = ID;
        this.nombre = Nombre;
        this.id_profesor_idx = prof.getId();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_profesor_idx() {
        return id_profesor_idx;
    }

    public void setId_profesor_idx(String id_profesor_idx) {
        this.id_profesor_idx = id_profesor_idx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
