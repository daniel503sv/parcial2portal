/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class LogicaAlumno {
    public Conexion con; //conexion
    public Alumno alum; //alumno
    public LogicaAlumno(String Carnet, String Pass)
    {
        try {
            alum = con.getAlumno(Carnet, Pass);
        } catch (SQLException ex) {
            alum = null;
            Logger.getLogger(LogicaAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> getHtmlTable(Materia mat) throws SQLException
    {
        //adding the table
        String line = "<div class=\"table\">\n" +
        "    \n" +
        "    <div class=\"row header\">"
                ;
        
        ArrayList<String> tabla = new ArrayList();
        ArrayList<String[]> notas = con.TablaNotas(mat);
        String[] columns = notas.get(0);       
        notas.remove(0);
        for(String name:columns)
        {
            line = line + " <div class=\"cell\">\n" +
            name + "\n" +
            "      </div>";
        }
        line = line +  "</div>";
        tabla.add(line);
        
        //adding the rows
        line = ""; 
        for(String[] row:notas)
        {
            line =  "<div class=\"row\">";
                    for(String col:row)
                    {
                        line = line + " <div class=\"cell\">\n" +
                        col + "\n" +
                        "</div>";
                    }
            line = line + "</div>";
            tabla.add(line);
        }
        tabla.add("</div>"); //close table div
        return tabla;
    }

    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }

    public Alumno getAlum() {
        return alum;
    }

    public void setAlum(Alumno alum) {
        this.alum = alum;
    }
    
    
    
}
