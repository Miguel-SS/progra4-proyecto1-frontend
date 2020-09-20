/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.controller;

import Facturas.model.Admin;
import Facturas.model.Proveedor;
import Facturas.service.ServiceFacade;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author migue
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login", "/login/crearCuenta","/login/ingresarCliente","/login/ingresarServicio"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("usuarioAdmin", new Admin());
        request.setAttribute("usuarioProveedor", new Proveedor());
        
        //request.setAttribute("admin", new Usuario());
        String url= "";
        switch(request.getServletPath()){
            case "/login":
               // url = "/admin/Admin.jsp";
                url = this.login(request);
                break;
            case "/login/crearCuenta":
                url = "/crearCuenta/CrearCuenta.jsp";
                break;
            case "/login/ingresarCliente":   
                url = "/ingresarCliente/IngresarCliente.jsp";
                break;
            case "/login/ingresarServicio":   
                url = "/ingresarServicio/IngresarServicio.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward( request, response);  
    }
    
    private String login(HttpServletRequest request){
        try{
            Map<String,String> errores =  this.validar(request);
            HttpSession session = request.getSession(true);
            if(errores.isEmpty()){
                this.updateModel(request, session);
                return this.loginAction(request);
            }
            else{
               return " ";
            }
        }catch(Exception e){
            return "error"; // el profe tiene un view que dice error
        }
    }
    
    
    private Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("usuario").isEmpty()){
            errores.put("usuario", "id requerido");
        }
        if(request.getParameter("password").isEmpty()){
            errores.put("password", "password requerido");
        }


        if(!errores.isEmpty()){
            int idUsuario = Integer.parseInt(request.getParameter("usuario"));
            ServiceFacade service = new ServiceFacade();
            if(service.searchUser(idUsuario) == null){
                errores.put("usuario", "usuario no registrado");
            }
            else{
                if(service.searchUser(idUsuario).getClass().equals(Proveedor.class)){  
                    Proveedor pro = (Proveedor) service.searchUser(idUsuario);
                    if(!pro.getPassword().equals(request.getParameter("password"))){
                        errores.put("password", "password no valido");
                    }
                }
                else{
                    Admin admin = (Admin) service.searchUser(idUsuario);
                    if(!admin.getPassword().equals(request.getParameter("password"))){
                        errores.put("password", "password no valido");
                    }
                }
            }
        }
        return errores;
    }
    
    private void updateModel(HttpServletRequest request, HttpSession session){
        int idUsuario = Integer.parseInt(request.getParameter("usuario"));
        ServiceFacade service = new ServiceFacade();
        if(service.searchUser(idUsuario).getClass().equals(Proveedor.class)){
            Proveedor aux = (Proveedor) service.searchUser(idUsuario);
            Proveedor pro = (Proveedor) request.getAttribute("usuarioProveedor");
            pro.setId(aux.getId());
            pro.setNombre(aux.getNombre());
            pro.setTelefono(aux.getTelefono());
            pro.setCorreo(aux.getCorreo());
            pro.setActividad(aux.getActividad());
            pro.setEstado(aux.isEstado());
            pro.setPassword(aux.getPassword());
            pro.setServicios(aux.getServicios());
            session.setAttribute("usuarioProveedor", aux);
        }
        else{
            if(service.searchUser(idUsuario).getClass().equals(Admin.class)){
                Admin aux = (Admin) service.searchUser(idUsuario);
                Admin admin = (Admin) request.getAttribute("usuarioAdmin");
                admin.setId(aux.getId());
                admin.setNombre(aux.getNombre());
                admin.setPassword(aux.getPassword());
                session.setAttribute("usuarioAdmin", aux);
            }
        }
    }
 
     
    private String loginAction(HttpServletRequest request){
        int idUsuario = Integer.parseInt(request.getParameter("usuario"));
        ServiceFacade service = new ServiceFacade();
        if(service.searchUser(idUsuario).getClass().equals(Admin.class)){
            return "/admin/Admin.jsp";
        }
        else{
            if(service.searchUser(idUsuario).getClass().equals(Proveedor.class)){
                return "/login/loginVistaProveedor.jsp";
            }
        }
        return "error"; // view de error
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
