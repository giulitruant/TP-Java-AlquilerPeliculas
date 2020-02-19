/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import business.TarjetaCreditoUI;
import entities.TarjetaCredito;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author giuli
 */
@WebServlet(name = "srvTarjetaCredito", urlPatterns = {"/srvTarjetaCredito"})
public class srvTarjetaCredito extends HttpServlet {


    private static String INSERT_OR_EDIT = "./vista/tarjeta/Tarjeta.jsp";
    private static String LIST_TARJETAS = "./vista/tarjeta/lstTarjeta.jsp";

    TarjetaCreditoUI tarjetaCreditoUi = new TarjetaCreditoUI();
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet srvTarjetaCredito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet srvTarjetaCredito at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
                String forward = "";
                String action = "lstTarjetas";
                if(request.getParameter("action") != null)
                    action = request.getParameter("action");
        
                if (action.equalsIgnoreCase("delete")) {
        
                    boolean exito = false;
                    int id = Integer.parseInt(request.getParameter("Id"));
                    try {
                        exito = tarjetaCreditoUi.deleteTarjetaC(id);
                        forward = LIST_TARJETAS;
                        request.setAttribute("tarjetas", tarjetaCreditoUi.getTarjetaC());
                    } catch (SQLException ex) {
                        Logger.getLogger(srvTarjetaCredito.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(srvTarjetaCredito.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
                } else if (action.equalsIgnoreCase("edit")) {
        
                    forward = INSERT_OR_EDIT;
                    int id = Integer.parseInt(request.getParameter("id"));
                    Tarjeta tarjeta;
                    try {
                        tarjeta = tarjetaCreditoUi.getTarjetaC(id);
                        request.setAttribute("tarjeta", tarjeta);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(srvTarjetaCredito.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(srvTarjetaCredito.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //request.getRequestDispatcher(INSERT_OR_EDIT).forward(request, response);
                    
                    forward = INSERT_OR_EDIT;
                    RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
                    view.forward(request, response);
                    
        
                } else if (action.equalsIgnoreCase("lstTarjetas")) {
        
                    ArrayList<Tarjeta> lstTarjetas = new ArrayList<Tarjeta>();
                    try {
                        lstTarjetas = tarjetaCreditoUi.getTarjetaC();
                    } catch (SQLException ex) {
                        Logger.getLogger(srvTarjetaCredito.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(srvTarjetaCredito.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
                    forward = LIST_TARJETAS;
                    request.setAttribute("lstTarjetas", lstTarjetas);
        
                } else {
                    Tarjeta tarjeta = new Tarjeta();
                    request.setAttribute("tarjeta", tarjeta);
                    forward = INSERT_OR_EDIT;            
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
