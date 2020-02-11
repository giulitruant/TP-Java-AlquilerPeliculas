<%-- 
    Document   : user
    Created on : 10/02/2020, 19:38:11
    Author     : giuli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>
    
         <form method="POST" action='srvUsuarios' name="frmAddUser">
        usuario ID : <input type="text" readonly="readonly" name="idUsuario"
            value="<c:out value="${user.idUsuario}" />" /> <br /> 
        Correo : <input
            type="text" name="email"
            value="<c:out value="${user.email}" />" /> <br /> 
        Contraseña : <input
            type="text" name="contrasena"
            value="<c:out value="${user.contrasena}" />" /> <br />         
    </form>
    </body>
</html>
