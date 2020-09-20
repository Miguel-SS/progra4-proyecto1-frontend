/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.controller;

import Facturas.model.Actividad;
import Facturas.model.Proveedor;
import Facturas.model.Ubicacion;
import Facturas.service.ActividadService;
import Facturas.service.ProveedorService;
import Facturas.service.UbicacionService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author migue
 */
@WebServlet(name = "ProveedorController", urlPatterns = {"/login/ProveedorController"})
public class ProveedorController extends HttpServlet {

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
        String nom= request.getParameter("nombre");
        String ced= request.getParameter("cedula");
        String tel= request.getParameter("telefono");
        String correo= request.getParameter("correo");
        String provincia= request.getParameter("provincia");
        String canton= request.getParameter("canton");
        String distrito= request.getParameter("distrito");
        String direccion= request.getParameter("direccion");
        String contraseña= request.getParameter("contraseña");
        Ubicacion u= new Ubicacion(2,provincia,canton,distrito,direccion);
        UbicacionService ub= new UbicacionService();
        ub.save(u);
        Actividad a= new Actividad(9,"Prueba");
        ActividadService as= new ActividadService();
        as.save(a);

        Proveedor p = new Proveedor(1,nom,tel,correo,u,a,false,contraseña);
        ProveedorService s= new ProveedorService();
        s.save(p);
         String url= "";
             switch(request.getServletPath()){
                 case "/login/ProveedorController":
                     url = "/crearCuenta/CrearCuenta.jsp";
                     break;
        }
        request.getRequestDispatcher(url).forward( request, response);
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
