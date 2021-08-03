/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.bill;

import DAO.BillDAO;
import DAO.BillLineDAO;
import DAO.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.BillLine;
import model.Customer;

/**
 *
 * @author User
 */
@WebServlet(name = "BilllineControl", urlPatterns = {"/viewbillline"})
public class BilllineControl extends HttpServlet {

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
        BillDAO db = new BillDAO();
        BillLineDAO dbbl = new BillLineDAO();
        CustomerDAO dbc = new CustomerDAO();
        String report = "";
        int id = Integer.parseInt(request.getParameter("id"));
        int status = db.getBillofCustomerByBillId(id).isPaid();
        String date = db.getBillofCustomerByBillId(id).getDate1();
        request.setAttribute("date", date);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dated = new Date(System.currentTimeMillis());
        String dc = formatter.format(dated);

        request.setAttribute("today", dc);
        if (status == 1) {
            report = "Đã thanh toán";
        } else {
            report = "Chưa thanh toán";
        }
        request.setAttribute("status", report);
        int cid = db.getCusId(id);
        Customer cc = dbc.getCusById(cid);

        request.setAttribute("cusname", cc);
        Bill bill = db.getBillofCustomerByBillId(id);
        request.setAttribute("paidmoney", bill.getPaidMoney());
        ArrayList<BillLine> b = dbbl.getBillLineByBill(id);
        int index = 0;
        float sum = 0;
        for (BillLine o : b) {
            sum += o.getTotal();

        }

        request.setAttribute("bid", id);
        request.setAttribute("id", cid);
        request.setAttribute("money", sum);
        request.setAttribute("listB", b);
        request.getRequestDispatcher("view/bill/ViewDetail.jsp").forward(request, response);
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
