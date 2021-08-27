package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class XMLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xml = getServletConfig().getInitParameter("xml");
        System.out.println("XMLServlet via xml config is working");
        System.out.println(xml);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
