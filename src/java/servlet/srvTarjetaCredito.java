/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import data.TarjetaCreditoUI;
import entities.TarjetaCredito;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UsuarioUI;
import entities.Usuario;

/**
 *
 * @author giuli
 */
@WebServlet(name = "srvTarjetaCredito", urlPatterns = {"/srvTarjetaCredito"})
public class srvLstUsuarios extends HttpServlet {

    UsuarioUI usuarioUI = new UsuarioUI();

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
        //response.setContentType("text/html;charset=UTF-8");
            //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet srvLstUsuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet srvLstUsuarios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario>();
            try {
                lstUsuarios = usuarioUI.getUsuarios();
            } catch (SQLException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("lstUsuarios", lstUsuarios);
            request.getRequestDispatcher("vista/lstUsuarios.jsp").forward(request, response);
            */

        //}
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

        ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario>();
        try {
            lstUsuarios = usuarioUI.getUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("lstUsuarios", lstUsuarios);
        request.getRequestDispatcher("/vista/usuario/lstUsuarios.jsp").forward(request, response);
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
