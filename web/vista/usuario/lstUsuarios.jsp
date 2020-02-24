
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
        
        <div class="container">
        <form method="Post" action="srvLstUsuarios">
            <h2>Listado de usuarios</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id Usuario</th>
                    <th>Usuario</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>
                </tr>
                </thead>
                <tbody>

                <%
                    ArrayList<Usuario> list = (ArrayList<Usuario>) request.getAttribute("lstUsuarios");
                    for (Usuario usu : list) {

                %>

                ${estudiante.email}
                <tr>
                    <th><%=usu.getIdUsuario()%></th>
                    <th><%=usu.getEmail()%></th>
                    <th>
                    <form method="POST" action="srvLstUsuarios" onclick="if (!confirm('Esta seguro de eliminar el usuario'))">
                    <button class="btn-danger">Eliminar</button>
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>" >
                </form>
                    </th>
                    <th>
                    <form method="POST" action="srvLstUsuarios">
                        <button class="btn-info">Editar</button>
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>" >
                    </th>
                </form>  
                </tr>
                <tr>            
                    <!--
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
                    -->
        </tr>
                <%
                    }
                %>  
                <tbody>
            </table>
            
            <div id="new">
                <a class="btn-info" href="srvLstUsuarios?action=insert">Nuevo</a>
            </div>            
        </form>
                
        <a class="btn-info" href="index.html">Volver</a>  
        </div>
    </body>
</html>
