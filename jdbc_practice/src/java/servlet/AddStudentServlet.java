/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DaoStudentImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 *
 * @author Admin
 */
public class AddStudentServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get parameters from the request
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String age = request.getParameter("age");

        // use regular Java objects to write the data to a file
        Student std = new Student(id,name , age);
        DaoStudentImpl dao = new DaoStudentImpl();
        boolean b = dao.insert(std);
        String url = "/student.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
