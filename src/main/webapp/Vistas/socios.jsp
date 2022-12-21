<%-- 
    Document   : socios
    Created on : 20/12/2022, 12:46:58
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.SociosDAO"%>
<%@page import="modelo.Socios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/2cbbc87d30.js" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1>Listado de Socios del Gym</h1>
        
        
        <div class="container">
               
                <a class="btn btn-primary col-4 m-4" href="SociosController?accion=nuevo">Agregar Socio</a>
                
                <table class="table table-primary">
                    <thead>
                            <th>id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                             <th>Direccion</th>
                             <th>Localidad</th>
                             <th>Fecha Nac.</th>
                             <th>Telefono</th>
                             <th>mail</th>
                             <th>Modificar</th>
                             <th>Eliminar</th>
                    </thead>
                    
                    <%
                    List<Socios> resultado=null;
                    SociosDAO s1=new SociosDAO();
                    resultado=s1.listarSocios();
                    
                       for(int i=0;i<resultado.size();i++)
		    {
                    // rutta para modificar y ruta para eliminar//
                    // concatenar a la accion el ID 
			String rutaMod="SociosController?accion=modificar&id="+resultado.get(i).getIdSocio();	
			String rutaDel="SociosController?accion=eliminar&id="+resultado.get(i).getIdSocio();
		    %>                
                    
                
                    <tr>
                         <td><%=resultado.get(i).getIdSocio()%></td>
                         <td><%=resultado.get(i).getNombre()%></td>
                         <td><%=resultado.get(i).getApellido()%></td>
                         <td><%=resultado.get(i).getDireccion()%></td>
                         <td><%=resultado.get(i).getLocalidad()%></td>
                         <td><%=resultado.get(i).getFnac()%></td>
                         <td><%=resultado.get(i).getTelefono()%></td>
                         <td><%=resultado.get(i).getEmail()%></td>
                         <td class="text-center"><a href=<%=rutaMod%>> <i class="fa-solid fa-arrow-right-arrow-left"></i> </a></td>
			 <td class="text-center"><a href=<%=rutaDel%>><i class="fa-solid fa-arrow-down"></i> </a></td>
                    </tr>
                    
                    <%
                        }
                    %>
                   
                </table>
                
                
                
                
            
            
            
        </div>
        
        
        
        
    </body>
</html>

