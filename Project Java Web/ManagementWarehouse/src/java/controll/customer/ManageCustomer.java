/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.customer;

import DAO.CustomerDAO;
import DAO.DepartmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Department;

/**
 *
 * @author User
 */
@WebServlet(name = "ManageCustomer", urlPatterns = {"/customer/list"})
public class ManageCustomer extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        CustomerDAO db = new CustomerDAO();
        DepartmentDAO ddb = new DepartmentDAO();

        ArrayList<Department> d = ddb.getAllFlowers();

        request.setAttribute("listD", d);
        ArrayList<Customer> c = db.getAllCustomer();
        request.setAttribute("customer", c);
        request.getRequestDispatcher("../view/customer/list.jsp").forward(request, response);
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

        CustomerDAO db = new CustomerDAO();
        int did = Integer.parseInt(request.getParameter("department"));

        ArrayList<Customer> c = db.getAllCustomer();
        ArrayList<Customer> listC;
        DepartmentDAO ddb = new DepartmentDAO();
        request.setAttribute("listD", ddb.getAllFlowers());
        if (did == 1) {
            listC = db.getCusByStatus(1);
        } else if (did == 0) {
            listC = db.getCusByStatus(0);
        } else {
            listC = db.getAllCustomer();
        }

        request.setAttribute("customer", listC);
        request.setAttribute("deid", did);
        request.getRequestDispatcher("../view/customer/list.jsp").forward(request, response);
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
