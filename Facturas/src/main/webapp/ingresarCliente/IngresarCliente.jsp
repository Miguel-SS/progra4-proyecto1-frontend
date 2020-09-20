<%-- 
    Document   : IngresarCliente
    Created on : 14/09/2020, 02:30:52 PM
    Author     : Gabriela
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
                <form class="login-form" action = "/Facturas/cliente" method="post">
                    <input type="text" placeholder="Nombre"/>
                    <tr>
                       
                         <td width=100> 
                            <select class="select-css" name="plazo">
                                <option  selected>Tipo de cédula</option>
                                <option value="física">Cédula Física</option>
                                <option value="jurídica" >Cédula Jurídica</option>
                                <option value="dimex" >DIMEX</option>
                            </select>
                         </td>
                        
                    </tr>
                     <input type="text" placeholder="Cédula"/>
                      <input type="text" placeholder="Provincia"/>
                       <input type="text" placeholder="Cantón"/>
                        <input type="text" placeholder="Distrito"/>
                         <input type="text" placeholder="Dirección exacta"/>
                          <input type="text" placeholder="Correo"/>
                    
                    <button>Ingresar Cliente</button>
                   
                    
                </form>
            </div>
        </div> 
    </body>
</html>
