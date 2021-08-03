/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.customer;

import DAO.CustomerDAO;
import controll.login_logout.BaseAuthenticationController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author User
 */
@WebServlet(name = "ListCustomer", urlPatterns = {"/list"})
public class ListCustomer extends BaseAuthenticationController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("txt");
        String index = request.getParameter("index");
        request.setAttribute("txt", name);
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        CustomerDAO db = new CustomerDAO();
        int count = db.count(name);
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }

        ArrayList<Customer> c = db.paging(indexPage, name);
        request.setAttribute("count", count);
        request.setAttribute("customer", c);
        request.setAttribute("end", endPage);
        request.setAttribute("tag", index);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
        String name = request.getParameter("txt");
        String index = request.getParameter("index");
        request.setAttribute("txt", name);
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        CustomerDAO db = new CustomerDAO();
        int count = db.count(name);
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }

        ArrayList<Customer> c = db.paging(indexPage, name);
        request.setAttribute("customer", c);
         request.setAttribute("count", count);
        request.setAttribute("end", endPage);
        request.setAttribute("tag", index);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

}
