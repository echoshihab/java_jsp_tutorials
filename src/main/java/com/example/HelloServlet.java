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
        System.out.println("This is a get request to /hello");
        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello</h1>");
        response.getWriter().println("<p>Weclome to my website </p>");
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
//start at 5th video
    }
}
