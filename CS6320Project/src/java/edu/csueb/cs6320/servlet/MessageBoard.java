/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csueb.cs6320.servlet;

import edu.csueb.cs6320.bean.Message;
import edu.csueb.cs6320.bean.MessageDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gaya
 */
@WebServlet(name = "MessageBoard", urlPatterns = {"/MessageBoard"})
public class MessageBoard extends HttpServlet {

    private static String LIST_MESSAGE = "/messageboard.jsp";
    private static String EMAIL_MESSAGE = "/email.jsp";
    private static String CREATE_MESSAGE = "/createmessage.jsp";
    private static String UPDATE_MESSAGE = "/updatemessage.jsp";

    public MessageBoard() {
        super();
    }

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
        String action = request.getParameter("action");
        String username = request.getParameter("username");        
        MessageDao dao = new MessageDao();
        if (action != null) {
            if (action.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteMessage(id);
            } else if (action.equalsIgnoreCase("create")) {
                String msg = request.getParameter("message");
                dao.newMessage(msg, username);
            } else if (action.equalsIgnoreCase("update")) {
                System.out.println(request.getParameter("id") + request.getParameter("message"));
                int id = Integer.parseInt(request.getParameter("id"));
                String msg = request.getParameter("message");
                dao.updateMessage(id, msg);
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_MESSAGE);
        List<Map<String, String>> msgs = dao.getMessage();
        request.setAttribute("messages", msgs);
        view.forward(request, response);

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
        doGet(request, response);
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
