<%-- 
    Document   : Login
    Created on : 11-sep-2020, 0:38:18
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../const/Head.jsp" %>
        <title>Login</title>
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@ include file="../const/Header.jsp" %>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action = "/Facturas/login" method="post">
                    <input type="text" placeholder="Usuario" name ="usuario" />
                    <input type="password" placeholder="Contraseña" name="password"/>
                    <button>Ingresar</button>
                    <p class="message">¿No tiene cuenta? <a href="/Facturas/login/crearCuenta">Crear cuenta</a></p>
                    
                </form>
            </div>
        </div>
    </body>
</html>
