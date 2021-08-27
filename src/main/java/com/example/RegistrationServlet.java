package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "RegistrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password1");
        String confirmPassword = request.getParameter("password2");

        HashMap<String, String> errors = new HashMap<String, String>();

        if(email == null || email.isEmpty()){
            errors.put("email", "You must enter email");
        }
        if(password == null || password.isEmpty()){
            errors.put("password", "Password cannot be empty");
        }
        if(confirmPassword == null || confirmPassword.isEmpty()){
            errors.put("confirmPassword", "Confirm password cannot be empty");
        }
        if (!password.equalsIgnoreCase(confirmPassword)){
            errors.put("Mismatched Password", "Password do not match Confirm Password");
        }

        if(errors.size()> 0){
            request.setAttribute("errors", errors);
            doGet(request, response);
        } else{
            String secretToken = getServletContext().getInitParameter("secretToken");
            request.setAttribute("secretToken", secretToken);
            request.setAttribute("user", email);
            getServletContext().getRequestDispatcher("/success.jsp").forward(request,response);
        }
    }
}

//continue form 8.