/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.NewsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.News;

/**
 *
 * @author User
 */
@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {

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
        try {
//            request.setCharacterEncoding("UTF-8");
            NewsDAO dao = new NewsDAO();
            //paging 3 news of a page
            int size = 3;//number news of a page
            int indexPage = 1;//index of page          
            try {
                indexPage = Integer.parseInt(request.getParameter("indexPage"));
            } catch (Exception e) {
            }

            //indexPage=1 index=0 -> offset from 0
            //indexPage=2 index=3 -> offset from 3
            //...
            String txt = request.getParameter("txt").trim();
            ArrayList<News> listS = dao.searchByPaging(indexPage, size, txt);
            int totalSearch = dao.countSearch(txt);
            int totalPage = totalSearch / size;
            if (totalSearch % size != 0) {
                totalPage++;
            }
            //highlight
            for (News o : listS) {
                String title = o.getTitle();
                String lowTitle = title.toLowerCase();
                String lowTxt = txt.toLowerCase();
                int tag = lowTitle.indexOf(lowTxt);
                String result = "";
                String txtInTitle = title.substring(tag, tag + lowTxt.length());
                System.out.println(txtInTitle);
                result = title.replace(txtInTitle, "<mark>"+txtInTitle+"</mark>");
                System.out.println(result);
                o.setTitle(result);
            }
            request.setAttribute("notify", "These are " + totalSearch + " results related to '" + txt + "'");
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("indexPage", indexPage);
            request.setAttribute("txt", txt);
            request.setAttribute("listS", listS);
            //set data into class right
            ArrayList<News> top5 = dao.getTop5();
            request.setAttribute("top5", top5);
            News lastD = dao.getLastNews();
            request.setAttribute("lastD", lastD);
            //set data to search page
            request.getRequestDispatcher("view/SearchPage.jsp").forward(request, response);
            
        } catch (Exception e) {
        }
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
