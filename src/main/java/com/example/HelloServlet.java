package com.example;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        StringBuilder error = new StringBuilder();

        if (firstName == null){
            error.append("Firstname not supplied");
        } else if (lastName == null){
            error.append("Lastname not supplied");
        }

        if(error.length() > 0){
            request.setAttribute("error", error.toString());
        } else {
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
        }

        getServletContext().getRequestDispatcher("/attributedemo.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestResponse test = new TestResponse("Test", "Test Response Body");
        String testString = new Gson().toJson(test);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(testString);
        out.flush();
//start at 6th video
    }
}
