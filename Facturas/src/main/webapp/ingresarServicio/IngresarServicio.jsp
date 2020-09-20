<%-- 
    Document   : IngresarServicio
    Created on : 14/09/2020, 03:23:53 PM
    Author     : Gabriela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturación</title>
    </head>
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
                                <option  selected>Tipo</option>
                                <option value="servicio"> Servicio </option>
                                <option value="producto" >Producto</option>
                               
                            </select>
                         </td>
                        
                    </tr>
                       <input type="text" placeholder="Unidad"/>
                        <input type="text" placeholder="Precio Unitario"/>
                         <input type="text" placeholder="Impuesto"/>
                          <input type="text" placeholder="Descripcion"/>
                    
                    <button>Ingresar Servicio </button>
                   
                    
                </form>
            </div>
        </div> 
    </body>
</html>
