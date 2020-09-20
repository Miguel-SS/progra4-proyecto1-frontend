<%-- 
    Document   : Header
    Created on : 11/09/2020, 01:49:28 AM
    Author     : migue
--%>
<%@page import="Facturas.model.Proveedor"%>
<% Proveedor usuario=  (Proveedor) session.getAttribute("usuario");  %>
<header>
    <div class="logo">
        <img src="/Facturas/images/pc.png" style="margin-left: 50px; height: 70px;">
        <h2>Sistema de Facturación Electrónica </h2>
    </div>
    <div class="menu">
        <ul> 
            
              <li>
                <a href="/Facturas/login/Login.jsp">Inicio</a>
              </li>    
               <% if (usuario!=null){ %> 
                <li>
                  <a href="/Facturas/ingresarCliente/IngresarCliente.jsp">Ingresar Clientes</a>
                </li>                  
                 <li>
                  <a href="/Facturas/ingresarServicio/IngresarServicio.jsp">Ingresar Servicio</a>
                </li>   
                <li>
                  <a href="/Facturas/ingresarServicio/IngresarServicio.jsp">Crear Factura</a>
                </li>   
             <% } %>   
            </ul>
    </div>
</header>
