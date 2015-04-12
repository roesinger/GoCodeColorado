/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gocodecolorado.entities.Account;
import gocodecolorado.business.AccountMgr;

/**
 *
 * @author rsjodin
 */
@WebServlet(name = "CreateAccount", urlPatterns = {"/CreateAccount"})
public class CreateAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO: **** NEED TO CHECK TO SEE IF THE USERNAME IS ALREADY USED ****
        
        try {
            Account account = new Account();  
            account.setFirstName(request.getParameter("firstname"));
            account.setLastName(request.getParameter("lastname"));
            //account.setOrganization(request.getParameter("organization"));
            account.setStreet(request.getParameter("address"));
            account.setCity(request.getParameter("city"));
            account.setState(request.getParameter("state"));
            account.setZip(request.getParameter("zipcode"));
            account.setPhone(request.getParameter("phone"));
            account.setEmail(request.getParameter("email"));
            account.setPassword(request.getParameter("password"));

            AccountMgr mgr = new AccountMgr();
            account = mgr.create(account);
            if (account != null) {
                getServletContext().getRequestDispatcher("/index_1.html").forward(request, response);
            } else {
                // TODO: ERROR PAGE
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
