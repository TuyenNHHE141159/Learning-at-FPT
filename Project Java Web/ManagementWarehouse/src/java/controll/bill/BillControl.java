/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.bill;

import DAO.BillDAO;
import DAO.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.Customer;

/**
 *
 * @author User
 */
@WebServlet(name = "BillControl", urlPatterns = {"/viewbill"})
public class BillControl extends HttpServlet {

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
         String txt= request.getParameter("txt");
          String index=request.getParameter("index");
          if(index==null){
            index="1";
        }
            int indexPage= Integer.parseInt(index);
        BillDAO db= new BillDAO();
        CustomerDAO dbc= new CustomerDAO();
        int id= Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        Customer cus= dbc.getCusById(id);
        request.setAttribute("customer", cus);
        ArrayList<Bill> b= db.getBillofCustomerById(id);
       
        
        int count= db.countBillOfCustomer(id);
        int endPage=count/3;
        if(count%3!=0){
            endPage++;
        }
        ArrayList<Bill> list=db.pagingBillofCustomer(id, indexPage);
         request.setAttribute("listB1", list);
           request.setAttribute("count", count);
         request.setAttribute("end", endPage);
        request.setAttribute("listB", b);
        request.setAttribute("tag", index);
        request.getRequestDispatcher("view/bill/ViewOrder.jsp").forward(request, response);
    
        
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
