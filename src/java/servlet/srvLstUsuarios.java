/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import business.SocioUI;
import java.io.IOException;
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
import entities.Socio;
import entities.Usuario;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author giuli
 */
@WebServlet(name = "srvLstUsuarios", urlPatterns = {"/srvLstUsuarios"})
public class srvLstUsuarios extends HttpServlet {
    
    private static String INSERT_OR_EDIT = "./vista/usuario/Usuario.jsp";
    private static String LIST_USER = "./vista/usuario/lstUsuarios.jsp";

    UsuarioUI usuarioUI = new UsuarioUI();
    SocioUI socioUI = new SocioUI();

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
        //processRequest(request, response);

        String forward = "";
        String action = "lstUser";
        if(request.getParameter("action") != null)
            action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            boolean exito = false;
            int userId = Integer.parseInt(request.getParameter("userId"));
            try {
                exito = usuarioUI.deleteUsuario(userId);
                forward = LIST_USER;
                request.setAttribute("users", usuarioUI.getUsuarios());
            } catch (SQLException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action.equalsIgnoreCase("edit")) {

            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            Usuario user;
            try {
                user = usuarioUI.getUserbyId(userId);
                request.setAttribute("user", user);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            //request.getRequestDispatcher(INSERT_OR_EDIT).forward(request, response);
            
            forward = INSERT_OR_EDIT;
            RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
            view.forward(request, response);
            

        } else if (action.equalsIgnoreCase("lstUser")) {

            ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario>();
            try {
                lstUsuarios = usuarioUI.getUsuarios();
            } catch (SQLException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

            forward = LIST_USER;
            
            request.setAttribute("lstUsuarios", lstUsuarios);
            //request.getRequestDispatcher(LIST_USER).forward(request, response);

        } else {
            Usuario user = new Usuario();
            request.setAttribute("user", user);
            forward = INSERT_OR_EDIT;
            //response.sendRedirect("srvUsuario");
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

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
        
        Usuario usuario = new Usuario();
        Socio socio = new Socio();
        
        socio.setNombre(request.getParameter("nombre"));
        socio.setApellido(request.getParameter("apellido"));
        socio.setDomicilio(request.getParameter("domicilio"));
        socio.setEstado(request.getParameter("estado"));
        socio.setTelefono(request.getParameter("telefono"));
        
        if(request.getParameter("nroTarjeta") == null || request.getParameter("nroTarjeta") == "")
        {
            socio.setNroTarjeta(null);
        }
        else
        {
            String tarjeta = request.getParameter("nroTarjeta");
            socio.setNroTarjeta(Integer.parseInt(tarjeta));
        }
        
        usuario.setEmail(request.getParameter("email"));
        usuario.setContrasena(request.getParameter("contrasena"));       
        String idUsuario = request.getParameter("idUsuario");
        if(idUsuario == null || idUsuario.isEmpty())
        {
            try {
                //socioUI.addSocio(socio);
                usuarioUI.addUsuario(usuario, socio);
            } catch (SQLException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {            
            usuario.setIdUsuario(Integer.parseInt(idUsuario));
            try {            
                socioUI.updateSocio(socio);
                usuarioUI.updateUsuario(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        
        try {
            request.setAttribute("lstUsuarios", usuarioUI.getUsuarios());
        } catch (SQLException ex) {
            Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(srvLstUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher(LIST_USER).forward(request, response);            
                   
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
