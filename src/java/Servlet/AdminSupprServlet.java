/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author macbookpro
 */
public class AdminSupprServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getParameter("suppr")!=null) {
            int n_inscription = Integer.parseInt(request.getParameter("ninsc"));
            request.setAttribute("ninsc",n_inscription);
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminsuppr0.jsp").forward(request, response);
        } else if(request.getParameter("motif")!=null) {
            int n_inscription = Integer.parseInt(request.getParameter("ninsc"));
            Supprimer(n_inscription,request.getParameter("motif"));
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminsuppr1.jsp").forward(request, response);    
        }
    }
    
        public void Supprimer(int n_inscription,String motif){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("UPDATE baccalaureat SET supprime ='1',motif=? WHERE n_inscription =?"); 
            pr3.setString(1, motif);
            pr3.setInt(2, n_inscription);
            pr3.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
