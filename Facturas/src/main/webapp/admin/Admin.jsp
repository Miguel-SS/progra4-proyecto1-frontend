<%-- 
    Document   : Admin
    Created on : 13-sep-2020, 23:51:40
    Author     : Usuario
--%>
<%@page import="Facturas.service.ServiceFacade" %>
<%@page import="Facturas.model.Proveedor" %>
<%@page import="java.util.List" %>
<%
    ServiceFacade service = new ServiceFacade();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../const/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturación</title>
    </head>
    <body>
        <%@ include file="../const/Header.jsp" %>
        
        <div class="tablePos">
            <form action = "/Facturas/admin/update" method="post">
                <h2>Proveedores</h2>
                <table>
                    <tr>
                        <th>CÉDULA</th>
                        <th>NOMBRE</th>
                        <th>TELÉFONO</th>
                        <th>CORREO</th>
                        <th>UBICACIÓN</th>
                        <th>ACTIVO</th>
                    </tr>
                    <% 
                        List<Proveedor> proveedores = service.getPoveedores();
                        int n = 0;
                        for(Proveedor proveedor : proveedores) {
                    %>
                    <tr>
                        <td><%=proveedor.getId()%></td>
                        <td><%=proveedor.getNombre()%></td>
                        <td><%=proveedor.getTelefono() %></td>
                        <td><%=proveedor.getCorreo() %></td>
                        <td><%=proveedor.getUbicacion().getDistrito() %></td>
                        <% if(proveedor.isEstado()){ %>
                        <td><input type="checkbox" name="estado<%=n%>" value="1" onclick="" checked></td>
                        <% 
                                n++;
                            } else { 
                        %>
                            <td><input type="checkbox" name="estado<%=n%>" value="0"></td>
                        <% } %>
                    </tr>
                    <% } %>
                </table>
                <button>Guardar</button>
            </form>
        </div>
    </body>
</html>