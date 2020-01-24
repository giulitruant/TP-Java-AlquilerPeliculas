<%-- 
    Document   : lstUsuarios
    Created on : 15/01/2020, 00:15:21
    Author     : giuli
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <form method="Post" action="srvLstUsuarios">
            <table summary="listado de usuarios">
                <tr>
                    <th>Id Usuario :</th>
                    <th>Usuario :</th>
                </tr>

                <%
                    ArrayList<Usuario> list = (ArrayList<Usuario>) request.getAttribute("lstUsuarios");
                    for (Usuario usu : list) {                        
                    
                %>

                <tr>
                    <th><%=usu.getIdUsuario()%></th>
                    <th><%=usu.getEmail()%></th>                    
                    <th>
                        <a href="">Agregar</a>
                    </th>
                    <th>
                        <a href="">Eliminar</a>
                    </th>
                </tr>
                <%
                    }
                %>                
            </table>
        </form>
        <a href="index.html">Volver</a>  
    </body>
</html>
