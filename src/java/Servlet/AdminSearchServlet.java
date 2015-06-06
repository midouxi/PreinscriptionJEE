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
public class AdminSearchServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
            
        if(request.getParameter("search")!=null) {
            int n_inscription = Integer.parseInt(request.getParameter("ninsc"));
            if(extractor(n_inscription,"personnelle","cne")!=null){
            //request.setAttribute("ninsc",n_inscription);
            request.setAttribute("cne", extractor(n_inscription,"personnelle","cne"));
            request.setAttribute("etablissement", extractor(n_inscription,"personnelle","etablissement"));
            request.setAttribute("nom", extractor(n_inscription,"personnelle","nom"));
            request.setAttribute("prenom", extractor(n_inscription,"personnelle","prenom"));
            request.setAttribute("date_naissance", extractor(n_inscription,"personnelle","date_naissance"));
            request.setAttribute("ville_naissance", extractor(n_inscription,"personnelle","ville_naissance"));
            request.setAttribute("pays_naissance", extractor(n_inscription,"personnelle","pays_naissance"));
            request.setAttribute("nationalite", extractor(n_inscription,"personnelle","nationalite"));
            request.setAttribute("cin", extractor(n_inscription,"personnelle","cin"));
            request.setAttribute("datecin", extractor(n_inscription,"personnelle","datecin"));
            request.setAttribute("adresse", extractor(n_inscription,"personnelle","adresse"));
            request.setAttribute("ville", extractor(n_inscription,"personnelle","ville"));
            request.setAttribute("pays", extractor(n_inscription,"personnelle","pays"));
            request.setAttribute("tel", extractor(n_inscription,"personnelle","tel"));
            request.setAttribute("email", extractor(n_inscription,"personnelle","email"));
            request.setAttribute("photo", extractor(n_inscription,"personnelle","photo"));
            request.setAttribute("handicap", extractor(n_inscription,"personnelle","handicap"));
            request.setAttribute("nature_handicap", extractor(n_inscription,"personnelle","nature_handicap"));
            request.setAttribute("num_carte_handicap", extractor(n_inscription,"personnelle","num_carte_handicap"));
            request.setAttribute("bourse", extractor(n_inscription,"personnelle","bourse"));
            request.setAttribute("activite", extractor(n_inscription,"personnelle","activite"));
            request.setAttribute("nom_pere", extractor(n_inscription,"tuteur","nom_pere"));
            request.setAttribute("prenom_pere", extractor(n_inscription,"tuteur","prenom_pere"));
            request.setAttribute("profession_pere", extractor(n_inscription,"tuteur","profession_pere"));
            request.setAttribute("nom_mere", extractor(n_inscription,"tuteur","nom_mere"));
            request.setAttribute("prenom_mere", extractor(n_inscription,"tuteur","prenom_mere"));
            request.setAttribute("profession_mere", extractor(n_inscription,"tuteur","profession_mere"));
            request.setAttribute("nom_tuteur", extractor(n_inscription,"tuteur","nom_tuteur"));
            request.setAttribute("prenom_tuteur", extractor(n_inscription,"tuteur","prenom_tuteur"));
            request.setAttribute("profession_tuteur", extractor(n_inscription,"tuteur","profession_tuteur"));
            request.setAttribute("adresse_tuteur", extractor(n_inscription,"tuteur","adresse_tuteur"));
            request.setAttribute("tel_tuteur", extractor(n_inscription,"tuteur","tel_tuteur"));
            request.setAttribute("mail_tuteur", extractor(n_inscription,"tuteur","mail_tuteur"));
            request.setAttribute("type_bac", extractor(n_inscription,"baccalaureat","type_bac"));
            request.setAttribute("serie_bac", extractor(n_inscription,"baccalaureat","serie_bac"));
            request.setAttribute("mention_bac", extractor(n_inscription,"baccalaureat","mention_bac"));
            request.setAttribute("moy_ER", extractor(n_inscription,"baccalaureat","moy_ER"));
            request.setAttribute("moy_EN", extractor(n_inscription,"baccalaureat","moy_EN"));
            request.setAttribute("math_EN", extractor(n_inscription,"baccalaureat","math_EN"));
            request.setAttribute("phys_EN", extractor(n_inscription,"baccalaureat","phys_EN"));
            request.setAttribute("nat_EN", extractor(n_inscription,"baccalaureat","nat_EN"));
            request.setAttribute("lycee", extractor(n_inscription,"baccalaureat","lycee"));
            request.setAttribute("academie", extractor(n_inscription,"baccalaureat","academie"));
            request.setAttribute("province", extractor(n_inscription,"baccalaureat","province"));
            request.setAttribute("filiere", extractor(n_inscription,"baccalaureat","filiere"));
            } else { 
                request.setAttribute("alerte","Etudiant introuvable"); 
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminsearch1.jsp").forward(request, response);    
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminsearch0.jsp").forward(request, response);
        } 
    }
    
    public String extractor(int n_inscription,String table,String select) {
        String result=null; 
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
            String query = "SELECT "+select+" FROM "+table+" WHERE n_inscription='"+n_inscription+"'";
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement(query); 
            ResultSet re= (ResultSet) pr3.executeQuery();
            while(re.next()) {
                result=re.getString(1);
            }
            //return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
