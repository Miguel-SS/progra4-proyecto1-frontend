/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.controller;

import Facturas.model.Proveedor;
import Facturas.service.ServiceFacade;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "AdminController", urlPatterns = {"/admin", "/admin/update", "/admin/logout", "/admin/editarPerfil"})
public class AdminController extends HttpServlet {

    private final ServiceFacade serviceFacade = new ServiceFacade();
    
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
        
        String url= "";
        switch(request.getServletPath()){
            case "/admin":
                url = "/admin/Admin.jsp";
                break;
            case "/admin/update":
                updateProveedores(request);
                url = "/admin/Admin.jsp";
                break;
            case"/admin/logout":
                url = this.logout(request);
                break;
            case "/admin/editarPerfil":
                 url = "admin/EditarAdmin.jsp";
                break;
        }  
            
        request.getRequestDispatcher(url).forward( request, response);
    }
    
    private void updateProveedores(HttpServletRequest request) {
        List<Proveedor> proveedores = serviceFacade.getPoveedores();
        int isChecked=2;
        boolean prueba;
        String parametro = "";
        String valor = "";
        int n = 0;
        for (Proveedor proveedor : proveedores) {
            parametro = "estado" + n;
            valor = request.getParameter(parametro);
            isChecked = Integer.parseInt(valor);
            if(isChecked == 1) {
                proveedor.setEstado(true);
            }
            if(isChecked == 0) {
                proveedor.setEstado(false);
            }
            n++;
        }
        
    }

    private String logout(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuarioAdmin");
        session.invalidate();
        return "/login/Login.jsp";
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
