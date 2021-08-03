/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll.flower;

import DAO.BillDAO;
import DAO.CustomerDAO;
import DAO.FlowerDAO;
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
import model.Flower;

/**
 *
 * @author User
 */
@WebServlet(name = "FlowerHouse", urlPatterns = {"/warehouse"})
public class FlowerHouse extends HttpServlet {

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
       //get all flowers
        FlowerDAO db= new FlowerDAO();
        ArrayList<Flower> f= db.getAllFlowers();
        request.setAttribute("listF", f);
      //billHouse status 1
   
        String index = request.getParameter("index");
      
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        BillDAO bdb= new BillDAO();
         int count = bdb.countBillHouse( 1);
           int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        ArrayList<Bill> list= bdb.getBillHousePaging(1,  indexPage);
         request.setAttribute("count", count);
        request.setAttribute("list", list);
        request.setAttribute("end", endPage);
        request.setAttribute("tag", index);
        
        //billHouse status 0
        
        String index1 = request.getParameter("index1");

        if (index1 == null) {
            index1 = "1";
        }
        int indexPage1 = Integer.parseInt(index1);
       
         int count1 = bdb.countBillHouse( 0);
           int endPage1 = count1 / 3;
        if (count1 % 3 != 0) {
            endPage1++;
        }
        ArrayList<Bill> list1= bdb.getBillHousePaging(0, indexPage1);
         request.setAttribute("count1", count1);
        request.setAttribute("list1", list1);
        request.setAttribute("end1", endPage1);
        request.setAttribute("tag1", index1);
        request.getRequestDispatcher("view/warehouse/list.jsp").forward(request, response);
        
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
