/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import Utileria.Mensajes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wilver
 */
public class Conexion {
    Connection con=null;
    PreparedStatement pstmt=null;
    public Conexion()
    {
        conectar();
    }
    
    private void conectar()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_authors", "root","1234");
            
        } catch (Exception e) {
            Mensajes.MostrarMensaje(e.toString());
        }
    }
    private void desconectar()
    {
        try {
            con.close();
        } catch (Exception e) {
        }
    }
    
    public boolean ejecutar(String query)
    {
        boolean resultado=false;
        try {
            conectar();
            pstmt=con.prepareStatement(query);
            int res=pstmt.executeUpdate();
            if(res>0)
            {
                resultado=true;
            }
            desconectar();
        } catch (Exception e) {
            resultado=false;
            Mensajes.MostrarMensajeError(e.toString());
        }
        return resultado;
    }
    
    public ResultSet ejecutarResult(String query)
    {
        ResultSet rs=null;
        try {
            conectar();
            pstmt=con.prepareStatement(query);
            rs=pstmt.executeQuery();
            desconectar();
        } catch (Exception e) {
            Mensajes.MostrarMensajeError(e.toString());
        }
        return rs;
    }
        public ArrayList<Alumno> getAlumnos() throws SQLException
    {
        ArrayList lista = new ArrayList();
        ResultSet rs= ejecutarResult("SELECT  * FROM alumnos");
        while(rs.next())
        {
            lista.add(new Alumno(rs.getString("carnet"),rs.getString("Nombre"),rs.getString("password")));
        }
        return lista;    
    }
    public ArrayList<Actividad> getActividades(Materia mat) throws SQLException
    {
        
         ArrayList lista = new ArrayList();
         ResultSet rs= ejecutarResult("SELECT * FROM actividad a WHERE id_materia=" + mat.getId());
        while(rs.next())
            {
                lista.add(new Actividad(rs.getString("id_actividad"),rs.getString("nombre"),
                rs.getString("periodo"),rs.getString("porcentaje"),mat)
                );
            }
         return lista;
    }
    public Alumno getAlumno(String Carnet,String Pass) throws SQLException
    {
        Alumno alum = null;
        String query = "SELECT * FROM alumno where carnet='"
                + Carnet + "' AND password='" + Pass + "'";
                
        ResultSet rs = ejecutarResult(query);
        if(rs.next())
        {
            alum = new Alumno(
                    rs.getString("carnet"),
                    rs.getString("Nombre"),
                    rs.getString("password")
            );
            
        }
        return alum;
    }
    public ArrayList<Materia> getMaterias(Profesor prof) throws SQLException
    {
        ArrayList<Materia> materias = new ArrayList();
        String query = "SELECT * FROM materia WHERE id_profesor = " + prof.getId();
        ResultSet rs= ejecutarResult(query);
        while(rs.next())
            {
                materias.add(new Materia(
                        rs.getString("id_materia"),
                        rs.getString("materia"),
                        prof
                ));
            }
        return materias;
    }
    
    public ArrayList<String> NotasAlumno(Materia mat,Alumno alum) throws SQLException
    {
        String[] Header = {"Periodo","Asigncion","Porcentaje","Nota"}; 
        String query =" b.carnet, a.periodo, a.nombre, a.porcentaje, b.nota FROM actividad a INNER JOIN"
                + " alumno_actividad b ON a.id_actividad = b.id_actividad "
                + "WHERE b.carnet = '"+alum.getCarne()+"' AND "
                + "a.id_materia = " + mat.id;
        ArrayList lista = new ArrayList();
        lista.add(Header);
        ResultSet rs= ejecutarResult(query);
        while(rs.next())
            {
                Header[0] = rs.getString("periodo"); //Periodo
                Header[1] = rs.getString("nombre"); //Actividad
                Header[2] = rs.getString("porcentaje"); //Porcentaje
                Header[3] = rs.getString("nota");//Nota
                lista.add(Header);
            }
         return lista;
    }
    
    public ArrayList<String[]> TablaNotas(Materia mat) throws SQLException
    {
       
        
        ArrayList<String[]> list = new ArrayList();
        String[] Header = {"Carnet","Periodo","Asigncion","Porcentaje","Nota"}; 
        String query = "SELECT b.carnet,a.periodo,a.nombre,a.porcentaje,b.nota "
                + "FROM actividad a INNER JOIN alumno_actividad b "
                + "ON a.id_actividad = b.id_actividad "
                + "WHERE a.id_materia =" + mat.getId();
        ArrayList lista = new ArrayList();
        lista.add(Header);
        ResultSet rs= ejecutarResult(query);
        while(rs.next())
            {
                Header[0] = rs.getString("carnet"); //carnet alumno
                Header[1] = rs.getString("periodo"); //Periodo
                Header[2] = rs.getString("nombre"); //Actividad
                Header[3] = rs.getString("porcentaje"); //Porcentaje
                Header[4] = rs.getString("nota");//Nota
                lista.add(Header);
            }
        return list;
    }
    
    
}
