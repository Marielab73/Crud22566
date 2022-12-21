/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;


/**
 *
 * @author Usuario
 */
public class Conexion 

{
    public String driver="com.mysql.jdbc.Driver";
    //el anterior esta deprecado sirve este : com.mysql.cj.jdbc.Driver
    
    public Connection getConnection() 
            
    {
        Connection conexion=null;
        try {
            
            Class.forName(driver);
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud22566","root","");
        
                    
             } 
        catch (ClassNotFoundException|SQLException e)
                    
                    {
                        System.out.println(e);
                        
                    }
        
        
        return conexion;
    }
    
    
    public static void main(String[] args) throws SQLException
    {
        Connection conexion=null;
        Conexion con=new Conexion(); 
        //instancio un objeto de la clase conexion
        conexion=con.getConnection();
        //llamo a metodo
        
        PreparedStatement ps;
        // variable que guarda el compilador
        ResultSet rs;
        // rs = guarda un conjunto de informacion de la base de datos
        
        ps=conexion.prepareStatement("select * from socios");
        rs=ps.executeQuery();
        
        // imprimi hasta que haya un siguiente
         while(rs.next())
        {
            int id=rs.getInt("IdSocio");  
            String nombre=rs.getString("nombre");
            boolean estado =rs.getBoolean("activo");
            System.out.println("ID:"+id+" Nombre:"+nombre+" Estado:"+estado);
        }
        
    }
    
}


   


  
           