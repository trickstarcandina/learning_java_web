/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.User;
import data.UserIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class AddToEmailListServlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        
        // get parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // use regular Java objects to write the data to a file
        User user = new User(firstName, lastName, emailAddress);

        /*
        // validate the parameters
        String message = "";
        String url = "";
        if (firstName.length() == 0 || 
            lastName.length() == 0  ||
            emailAddress.length() == 0)
        {	
            message = 
                "Please fill out all three text boxes.";
            url = "/index.jsp";
        }
        else
        {
            message = "";
            ServletConfig config=getServletConfig();
            String relativePath=config.getInitParameter("relativaPathToFile");
            ServletContext context = getServletContext();
            String path = context.getRealPath(relativePath);
            //System.out.println(path);
            UserIO.add(user, path);
            url = "/display_email_entry.jsp";
        }
        request.setAttribute("user", user);
        request.setAttribute("message", message);

        // forward request and response to the view
        //String url = "/display_email_entry.jsp";
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        
        */
        // validate the parameters
        String fmessage = "", lmessage="", emessage="";
        String url = "";
        if (firstName.length() == 0)
        {	
            fmessage = 
                "Please fill out the first name";
            url = "/index.jsp";
        }
        if (lastName.length() == 0)
        {	
            lmessage = 
                "Please fill out the last name";
            url = "/index.jsp";
        }
        if (emailAddress.length() == 0)
        {	
            emessage = 
                "Please fill out the email address";
            url = "/index.jsp";
        }
        if ((fmessage.length()==0)&&(lmessage.length()==0)&&(emessage.length()==0))
        {
            ServletConfig config = this.getServletConfig();
            String relativePath = config.getInitParameter("relativePathToFile");
            ServletContext context = getServletContext();
            String path = context.getRealPath(relativePath);
            //UserIO.add(user, path);

            url = "/display_email_entry.jsp";
        }
        request.setAttribute("user", user);
        request.setAttribute("fmessage", fmessage);
        request.setAttribute("lmessage", lmessage);
        request.setAttribute("emessage", emessage);
        
        //Session
        HttpSession session = request.getSession();
        session.setAttribute("email", emailAddress);
        
        //Cookies
        Cookie emailCookie=new Cookie("email",emailAddress);
        emailCookie.setMaxAge(365*24*60*60);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);
        
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        

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
