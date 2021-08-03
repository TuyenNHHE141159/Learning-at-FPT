/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.bill;

import DAO.BillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;

/**
 *
 * @author User
 */
@WebServlet(name = "PartialPayController", urlPatterns = {"/partialpay"})
public class PartialPayController extends HttpServlet {

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
                int bid = Integer.parseInt(request.getParameter("bid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        request.setAttribute("cid", cid);
        request.setAttribute("bid", bid);
        request.getRequestDispatcher("view/bill/Partialpay.jsp").forward(request, response);
        response.sendRedirect("view/bill/Partialpay.jsp");
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
              int bid = Integer.parseInt(request.getParameter("bid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        double money= Double.parseDouble(request.getParameter("money"));
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dated = new Date(System.currentTimeMillis());
        String dc = formatter.format(dated);
        BillDAO db = new BillDAO();
        Bill b = db.getBillofCustomerByBillId(bid);
        double moneyb=b.getPaidMoney();
        double money_now=money+moneyb;
        db.pay(bid, 0,money_now,dc);
        
        response.sendRedirect("viewbillline?id=" + bid + "&&cusid=" + cid);
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
