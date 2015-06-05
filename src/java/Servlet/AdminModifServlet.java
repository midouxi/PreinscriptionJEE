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
        String n_inscription = request.getParameter("ninsc");
        request.setAttribute("cne", extractor(n_inscription,"personnelle","cne"));
        request.setAttribute("nom", extractor(n_inscription,"personnelle","nom"));
        request.setAttribute("prenom", extractor(n_inscription,"personnelle","prenom"));
        request.setAttribute("date_naissance", extractor(n_inscription,"personnelle","date_naissance"));
        request.setAttribute("ville_naissance", extractor(n_inscription,"personnelle","ville_naissance"));
        request.setAttribute("pays_naissance", extractor(n_inscription,"personnelle","pays_naissance"));
        request.setAttribute("nationalite", extractor(n_inscription,"personnelle","nationalite"));
        request.setAttribute("cin", extractor(n_inscription,"personnelle","cin"));
        request.setAttribute("date_cin", extractor(n_inscription,"personnelle","date_cin"));
        request.setAttribute("adresse", extractor(n_inscription,"personnelle","adresse"));
        request.setAttribute("ville", extractor(n_inscription,"personnelle","ville"));
        request.setAttribute("pays", extractor(n_inscription,"personnelle","pays"));
        request.setAttribute("tel", extractor(n_inscription,"personnelle","tel"));
        request.setAttribute("email", extractor(n_inscription,"personnelle","email"));
        request.setAttribute("photo", extractor(n_inscription,"personnelle","photo"));
        request.setAttribute("nature_handicap", extractor(n_inscription,"personnelle","nature_handicap"));
        request.setAttribute("num_carte_handicap", extractor(n_inscription,"personnelle","num_carte_handicap"));
        request.setAttribute("bourse", extractor(n_inscription,"personnelle","bourse"));
        request.setAttribute("activite", extractor(n_inscription,"personnelle","activite"));
        
        
        
        
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
