/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.bill;

import DAO.BillLineDAO;
import DAO.CustomerDAO;
import DAO.FlowerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Flower;

/**
 *
 * @author User
 */
@WebServlet(name = "DeleteBillLine", urlPatterns = {"/deletebillline"})
public class DeleteBillLine extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        int fid = Integer.parseInt(request.getParameter("fid"));
        int bid = Integer.parseInt(request.getParameter("bid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        int quantity = Integer.parseInt(request.getParameter("q"));
        FlowerDAO fdb = new FlowerDAO();
        CustomerDAO cdb = new CustomerDAO();
        Customer c = cdb.getCusById(cid);
        Flower f = fdb.getFlowerById(fid);
        if (c.isIsFarmer() == 1) {
            fdb.updateQuantity(f.getQuantity() + quantity, fid);
        } else {
            fdb.updateQuantity(f.getQuantity() - quantity, fid);
        }
        BillLineDAO db = new BillLineDAO();
        db.deleteBillLine(bid, fid);
        response.sendRedirect("placeorder?bid=" + bid + "&&cusid=" + cid);
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
