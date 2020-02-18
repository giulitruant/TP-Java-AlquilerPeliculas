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

        <%
            Usuario user = (Usuario) request.getAttribute("user");
        %>

        <div id="container">
            <form  method="POST" action="srvLstUsuarios" name="frmAddUser">                
                <input type="hidden" name="action" value="insert" />
                <div class="row">
                    <div class="col-sm-3">
                        <label class="sr-only" for="nombre">Nombre :</label>
                        <input type="text" class="form-control" id="nombre" placeholder="Nombre">
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label class="sr-only" for="apellido">Apellido :</label>
                            <input type="text" class="form-control" id="apellido" placeholder="Apellido">
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <label class="sr-only" for="domicilio">Domicilio :</label>
                        <input type="text" class="form-control" id="domicilio" placeholder="Domicilio">
                    </div> 
                    <div class="col-sm-3">
                        <label class="sr-only" for="telefono">Telefono :</label>
                        <input type="text" class="form-control" id="telefono" placeholder="Telefono">
                    </div>
                </div>
                <div class="row">                    
                    <div class="col-sm-3">
                        <label class="sr-only" for="nroTarjeta">N° Tarjeta del banco :</label>
                        <input type="text" class="form-control" id="nroTarjeta" placeholder="N° Tarjeta del banco">
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label><input type="checkbox" id="estado">Recibe notificaciones :</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <!--<input type="text" name="email" value="<%= user.getEmail()%>" required placehorlder="Email" />-->
                        <label for="email">Email address:</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="col-sm-3">
                   <!--<input type="password" name="contrasena" <%= user.getContrasena()%> required placehorlder="Contraseña" />-->
                        <label for="contrasena">Contraseña:</label>
                        <input type="password" class="form-control" id="contrasena">
                    </div>
                </div>
                <div class="row">                    
                    <div class="col-sm-3">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label><input type="checkbox" id="estado">Recibe notificaciones :</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label><input type="checkbox" id="estado">Recibe notificaciones :</label>
                                </div>
                            </div>
                        </div>
                    </div>
                  <div class="col-sm-3">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label><input type="checkbox" id="estado">Recibe notificaciones :</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                        <input class="btn btn-success" type="submit" value="Guardar" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="btn btn-success" type="reset" name="Cancelar" />
                        <!--<div class="text-right">-->                    
                        </div>
                            </div>
                    </div>
                </div>
        </div>                        
    </form>
</div>
</body>
</html>
