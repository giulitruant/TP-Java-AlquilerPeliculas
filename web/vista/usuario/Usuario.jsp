<%-- 
    Document   : user
    Created on : 10/02/2020, 19:38:11
    Author     : giuli
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="entities.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">   		
        <script src="js/bootstrap.min.js"></script>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        
        <!-- Supuestamente para editar Usuario  -->
        
        <%
            Usuario user = (Usuario)request.getAttribute("user");
        %>
       
        <div id="frm">
            <form class="form-horizontal" method="POST" action="srvLstUsuarios" name="frmAddUser">
                <input type="hidden" name="action" value="insert" />
                <div class="control-group">
                    <div class="controls">
                        <h3>Registrar Contacto</h3>
                    </div>                        
                </div>
                <div class="control-group">
                    <div class="controls">
                        <input type="text" name="email" value="<%= user.getEmail() %>" required placehorlder="Email" />                        
                    </div>
                </div>
                
                <div class="control-group">
                    <div class="controls">
                        <input type="password" name="contrasena" <%= user.getContrasena() %> required placehorlder="Contraseña" />
                    </div>
                </div>
                  <div class="control-group">
                    <div class="controls">                        
                        <input class="btn btn-success" type="submit" value="Guardar" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="btn btn-success" type="reset" name="Cancelar" />
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
