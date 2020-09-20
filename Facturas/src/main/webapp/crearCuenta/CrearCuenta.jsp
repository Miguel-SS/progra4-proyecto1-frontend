<%-- 
    Document   : CrearCuenta
    Created on : 13-sep-2020, 23:52:10
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
        <style>
        .overlay{
    display: none; position: absolute;
    top: 0%; left: 0%;
    width: 100%; height: 100%;
    background-color: lightblue;
    z-index:1; opacity:.70;
 }
 .popup {
    display: none; position: absolute;
    top: 10%; left: 25%;
    width: 100%; height: 50%;
    padding: 5px;
    border: 5px solid black;
    background-color: white;
    z-index:2;
 }
 </style> 
    </head>
    <body>
        <%@ include file="../const/Header.jsp" %>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action = "/Facturas/login/ProveedorController" method="POST">
                    <input type="text" placeholder="Cédula" name="cedula"/>
                    <input type="text" placeholder="Nombre" name="nombre"/>
                    <input type="text" placeholder="Teléfono" name="telefono"/>
                    <input type="text" placeholder="Correo" name="correo"/>
                    <input type="text" placeholder="Provincia" name="provincia"/>
                    <input type="text" placeholder="Cantón" name="canton"/>
                    <input type="text" placeholder="Distrito" name="distrito"/>
                    <input type="text" placeholder="Dirección exacta" name="direccion"/>
                    <input type="password" placeholder="Contraseña" name="contrasena"/>
                   <button onclick =
                    "document.getElementById('o').style.display='block';
                    document.getElementById('p').style.display='block';">
                    Crear Cuenta</button>                 
               
                    <div id="o" class="overlay"></div>
                    <div id="p" class="popup"></div>
                    <h2>Es necesario la verificación del administrador.</h2>
                  
                   </form>
            </div>
                    
          </div>
      
        </div> 
       
 </body>
</html>
