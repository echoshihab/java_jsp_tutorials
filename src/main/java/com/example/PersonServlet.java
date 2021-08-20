package com.example;


import model.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "PersonServlet", value = "/person ")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        StringBuilder error = new StringBuilder();

        if(firstName == null){
            error.append("Firstname not supplied!");
        } else if (lastName == null){
            error.append("Lastname not supplied!");
        }


        if(error.length() > 0){
            request.setAttribute("error", error.toString());
        }
        else {
            Person person = new Person(firstName, lastName);
            request.setAttribute("person", person);
        }

        getServletContext().getRequestDispatcher("/person.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
