/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class SociosDAO

{

    Connection conexion;
    
    //metodo conexion 
    
    public SociosDAO()
    {
        Conexion con= new Conexion();
        conexion =con.getConnection(); 
        
             
    }   
    
    // metodo listar socios 
    public List<Socios> listarSocios()
            
    {
       
        PreparedStatement ps;
        ResultSet rs;
        
        List<Socios> lista=new ArrayList<>();
        
        try
       {
                  
           ps=conexion.prepareStatement("select * from socios");
	   rs=ps.executeQuery();
           //por cada fila traida de PS recorro, genero un objeto y agrego a la lista
           while(rs.next())
           {
               int IdSocio=rs.getInt("IdSocio");
               String nombre=rs.getString("nombre");
               String apellido=rs.getString("apellido");
               String direccion=rs.getString("direccion");
               String localidad=rs.getString("localidad");             
               LocalDate fecha = rs.getDate("fnac").toLocalDate();
               String email=rs.getString("mail");
               String telefono=rs.getString("telefono");
               boolean activo=rs.getBoolean("activo");    
               //genero un objeto tipo socio con el constructor
               Socios s1=new Socios(IdSocio,nombre,apellido,direccion,localidad,fecha,email,telefono,activo);
              //agrego a la lista
               lista.add(s1);                

           }
          
           
       }
       catch(SQLException e)
       {
           System.out.println(e);
           //return null;
       }     
      
       // por salida OK retorno la lista
        return lista;
     
          
        
    }
            
   
    // metodo mostrar un socio
    
     public Socios mostrarSocio(int _id)
    {
        PreparedStatement ps;
        ResultSet rs;
        //defino un objeto socio
        Socios s1=null;
        try
        {
            ps=conexion.prepareStatement("select * from socios where IdSocio=?");
            // defino el ID que tiene que tomar para ek where, toma el del argumento
            ps.setInt(1, _id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("IdSocio");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String direccion=rs.getString("direccion");
                String localidad=rs.getString("Localidad");
                LocalDate fnac = rs.getDate("fnac").toLocalDate();
                String email=rs.getString("email");
                String telefono=rs.getString("telefono");
                boolean activo=rs.getBoolean("activo");    
                //asigno datos
                s1=new Socios(id,nombre,apellido,direccion,localidad,fnac,email,telefono,activo);
            }
            
            
            return s1;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
        
    }
    
  
     // Metodo insertar socio
     
     public boolean InsertSocios(Socios s1)
    {
        PreparedStatement ps;
        
        try
        {
            ps=conexion.prepareStatement("insert into socios (nombre,apellido,direccion,localidad,fnac,email,telefono,activo) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, s1.getNombre());
            ps.setString(2, s1.getApellido());
            ps.setString(3, s1.getDireccion());
            ps.setString(4, s1.getLocalidad());
            ps.setObject(5, s1.getFnac()); 
            ps.setString(6, s1.getEmail());
            ps.setString(7, s1.getTelefono());
            ps.setBoolean(8, true);
                       
            // inserta en la BD
            ps.execute();
            return true;        
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            // devuelve false por error 
            return false;
        }
    }
    
     //metodo eliminar Socio
     
     public boolean EliminarSocio(int _id)
    {
        PreparedStatement ps;
        
        try
        {
            ps=conexion.prepareStatement("delete from socios where idSocio=?");
            ps.setInt(1,_id);            
            ps.execute();
            return true;          
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
     // metodo Actualizar un Socio 
     
    public boolean ActualizarSocios(Socios s1)
    {
        PreparedStatement ps;        
        try
        {
            ps=conexion.prepareStatement("update socios set nombre=?,apellido=?,direccion=?,localidad=?,fnac=?,email=?,telefono=?,activo=? where IdSocio=?");
            ps.setString(1, s1.getNombre());
            ps.setString(2, s1.getApellido());
            ps.setString(3, s1.getDireccion());
            ps.setString(4, s1.getLocalidad());
            ps.setObject(5, s1.getFnac()); 
            ps.setString(6, s1.getEmail());
            ps.setString(7, s1.getTelefono());
            ps.setBoolean(8, s1.isActivo());
            ps.setInt(9,s1.getIdSocio());
            ps.execute();
            return true;          
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
     
     
     
       
// Fin Clase     
}
