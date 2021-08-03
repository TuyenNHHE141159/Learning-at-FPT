/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.bill;

import DAO.BillDAO;
import DAO.BillLineDAO;
import DAO.CustomerDAO;
import DAO.FlowerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.BillLine;
import model.Customer;
import model.Flower;

/**
 *
 * @author User
 */
@WebServlet(name = "PlaceOrder", urlPatterns = {"/placeorder"})
public class PlaceOrder extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("cusid"));
        BillDAO dbb = new BillDAO();
        CustomerDAO db = new CustomerDAO();
        Customer c = db.getCusById(id);
        request.setAttribute("customer", c);
        FlowerDAO dbf = new FlowerDAO();
        ArrayList<Flower> f = dbf.getAllFlowers();
        request.setAttribute("listF", f);
        int bid = Integer.parseInt(request.getParameter("bid"));
        request.setAttribute("bid", bid);
        String date = dbb.getBillofCustomerByBillId(bid).getDate1();
        request.setAttribute("date", date);
        BillLineDAO dbbl = new BillLineDAO();
        ArrayList<BillLine> b = dbbl.getBillLineByBill(bid);
        float sum = 0;
        for (BillLine o : b) {
            sum += o.getTotal();
        }
        request.setAttribute("money", sum);
        request.setAttribute("listB", b);

        request.getRequestDispatcher("view/bill/PlaceOrder.jsp").forward(request, response);
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
        request.setCharacterEncoding("utf-8");

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
