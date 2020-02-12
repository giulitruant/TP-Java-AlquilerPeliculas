
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">   		
        <script src="js/bootstrap.min.js"></script>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>        

        <form method="Post" action="srvLstUsuarios">
            <table summary="listado de usuarios">
                <tr>
                    <td>Id Usuario :</td>
                    <td>Usuario :</td>
                </tr>

                <%
                    ArrayList<Usuario> list = (ArrayList<Usuario>) request.getAttribute("lstUsuarios");
                    for (Usuario usu : list) {

                %>

                ${estudiante.email}
                <tr>
                    <td><%=usu.getIdUsuario()%></td>
                    <td><%=usu.getEmail()%></td>
                </tr>
                <tr>            
            <td id ="edi">
                <form method="POST" action="srvLstUsuarios">
                    <button class="glyphicon glyphicon-pencil"></button>
                    <input type="hidden" name="action" value="edit">
                    <input tupe="hidden" name="id" value="<%=usu.getIdUsuario()%>" >
                </form>                        
            </td>
            <td id="eli">
                <form method="POST" action="srvLstUsuarios" onclick="if (!confirm('Esta seguro de eliminar el usuario'))">
                    <button class="glyphicon glyphicon-trash"></button>
                    <input type="hidden" name="action" value="delete">
                    <input tupe="hidden" name="id" value="<%=usu.getIdUsuario()%>" >
                </form>
            </td>            
        </tr>
                <%
                    }
                %>                
            </table>
            
            <div id="new">
                <a class="glyphicon glyphicon-plus" href="srvLstUsuarios?action=insert">Nuevo</a>
            </div>            
        </form>
        <a href="index.html">Volver</a>  
    </body>
</html>
