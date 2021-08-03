/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.bill;

import DAO.BillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
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
@WebServlet(name = "DebtController", urlPatterns = {"/debt"})
public class DebtController extends HttpServlet {

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
        BillDAO bdb = new BillDAO();
        //don hang xuat
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        int count = bdb.countBill(1);
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }

        ArrayList<Bill> bills = bdb.getBillByStatusPaging(1, indexPage);
        ArrayList<Bill> billAll = bdb.getBillByStatus(1);
        double sum=0;
        double paid=0;
        for (Bill bill : billAll) {
            sum+=bill.getMoney();
            paid+=bill.getPaidMoney();
        }
        double result=sum-paid;
        BigDecimal result1= new BigDecimal(String.valueOf(result));
        request.setAttribute("debt", result1);
        request.setAttribute("listbr", bills);
        request.setAttribute("count", count);
        request.setAttribute("end", endPage);
        request.setAttribute("tag", index);
        //don hang nhap
         String index1 = request.getParameter("index1");
        if (index1 == null) {
            index1 = "1";
        }
        int indexPage1 = Integer.parseInt(index1);
        int count1 = bdb.countBill(0);
        int endPage1 = count1 / 3;
        if (count1 % 3 != 0) {
            endPage1++;
        }

        ArrayList<Bill> bills1 = bdb.getBillByStatusPaging(0, indexPage1);
        ArrayList<Bill> billAll1 = bdb.getBillByStatus(0);
          double sum1=0;
        double paid1=0;
        for (Bill bill : billAll1) {
            sum1+=bill.getMoney();
            paid1+=bill.getPaidMoney();
        }
        double result2=sum1-paid1;
        BigDecimal result11= new BigDecimal(String.valueOf(result2));
        request.setAttribute("debt1", result11);
        request.setAttribute("listbr1", bills1);
        request.setAttribute("count1", count1);
        request.setAttribute("end1", endPage1);
        request.setAttribute("tag1", index1);
        
        request.getRequestDispatcher("view/warehouse/debt.jsp").forward(request, response);
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
