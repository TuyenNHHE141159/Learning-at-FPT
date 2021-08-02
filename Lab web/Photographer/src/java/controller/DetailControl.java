/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Gallery;
import modal.Image;
import modal.Share;

/**
 *
 * @author User
 */
@WebServlet(name = "DetailControl", urlPatterns = {"/detail"})
public class DetailControl extends HttpServlet {

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
//        processRequest(request, response);
        try {
            String indexPage = request.getParameter("index");
            int index = 1;
            try {
                index = Integer.parseInt(indexPage);
            } catch (Exception e) {
            }

            String gid = request.getParameter("id");
            int id = Integer.parseInt(gid);
            DAO dao = new DAO();
            Gallery g = dao.getGalleryByID(id);
            ArrayList<Share> listS = dao.getShare();
            ArrayList<Gallery> listG = dao.getTop3();
            int count = dao.countImage(id);
            int size = 5;
            int totalPage = count / size;
            if (count % size != 0) {
                totalPage++;
            }
            ArrayList<Image> listImage = dao.getPaging(id, index, size);
            request.setAttribute("activeG", id);
            request.setAttribute("tag", index);
            request.setAttribute("galleryid", gid);
            request.setAttribute("listImg", listImage);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("share", listS);
            request.setAttribute("gallery", listG);
            request.setAttribute("g", g);
            request.getRequestDispatcher("view/GalleryPage.jsp").forward(request, response);

        } catch (Exception ex) {
        }
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
//        processRequest(request, response);
        
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
