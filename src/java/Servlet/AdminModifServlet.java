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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author macbookpro
 */
public class AdminModifServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/adminmodif1.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    public String extractor(String n_inscription,String table,String select) {
        String result=null; 
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
            String query = "SELECT "+select+" FROM "+table+" WHERE n_inscription='"+n_inscription+"'";
            System.out.println(query);
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement(query); 
            ResultSet re= (ResultSet) pr3.executeQuery();
            while(re.next()){
                result=re.getString(1);
            }
            //return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
