/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class AdminValidationServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getParameter("valid")!=null) {
            int n_inscription = Integer.parseInt(request.getParameter("ninsc"));
            request.setAttribute("ninsc",n_inscription);
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
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminvalid0.jsp").forward(request, response);
            
        } else if(request.getParameter("validation")!=null) {
            
            int n_inscription = Integer.parseInt(request.getParameter("ninsc"));
            Valider(n_inscription);
            AjoutEtudiant(n_inscription,request.getParameter("cne"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("date_naissance"), request.getParameter("ville_naissance"), request.getParameter("pays_naissance"), request.getParameter("nationalite"), request.getParameter("sexe"), request.getParameter("cin"), request.getParameter("datecin"), request.getParameter("adresse"), request.getParameter("ville"), request.getParameter("pays"), request.getParameter("tel"), request.getParameter("email"), request.getParameter("photo") , request.getParameter("handicap"), request.getParameter("nature_handicap"), request.getParameter("num_carte_handicap"), request.getParameter("bourse"), request.getParameter("activite"),request.getParameter("etablissement"),request.getParameter("type_bac"), request.getParameter("serie_bac"), request.getParameter("mention_bac"), request.getParameter("moy_ER"), request.getParameter("moy_EN"), request.getParameter("math_EN"), request.getParameter("phys_EN"), request.getParameter("nat_EN"), request.getParameter("lycee"), request.getParameter("academie"), request.getParameter("province"), request.getParameter("filiere"),request.getParameter("nom_pere"), request.getParameter("prenom_pere"), request.getParameter("profession_pere"), request.getParameter("nom_mere"), request.getParameter("prenom_mere"), request.getParameter("profession_mere"), request.getParameter("nom_tuteur"), request.getParameter("prenom_tuteur"), request.getParameter("profession_tuteur"), request.getParameter("adresse_tuteur"), request.getParameter("tel_tuteur"), request.getParameter("mail_tuteur"));
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminvalid1.jsp").forward(request, response);    
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
    
    public void Valider(int n_inscription){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("UPDATE baccalaureat SET valide ='1' WHERE n_inscription =?"); 
            pr3.setInt(1, n_inscription);
            pr3.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
        
    public void AjoutEtudiant(int n_inscription,String cne, String nom, String prenom, String date_naissance, String ville_naissance, String pays_naissance, String nationalite, String sexe, String cin, String datecin, String adresse, String ville, String pays, String tel, String email, String photo, String handicap, String nature_handicap, String num_carte_handicap, String bourse, String activite,String etablissement,String type_bac, String serie_bac, String mention_bac, String moy_ER, String moy_EN, String math_EN, String phys_EN, String nat_EN, String lycee, String academie, String province, String filiere,String nom_pere, String prenom_pere, String profession_pere, String nom_mere, String prenom_mere, String profession_mere, String nom_tuteur, String prenom_tuteur, String profession_tuteur, String adresse_tuteur, String tel_tuteur, String mail_tuteur){
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Admin","root","");
	    PreparedStatement pr1 = (PreparedStatement) connection.prepareStatement("INSERT INTO inscription (n_inscription,cne, nom, prenom, date_naissance, ville_naissance, pays_naissance, nationalite, sexe, cin, datecin, adresse, ville, pays, tel, email, photo, handicap, nature_handicap, num_carte_handicap, bourse,activite,etablissement, type_bac, serie_bac, mention_bac, moy_ER, moy_EN, math_EN, phys_EN, nat_EN, lycee, academie, province, filiere,nom_pere, prenom_pere, profession_pere, nom_mere, prenom_mere, profession_mere, nom_tuteur, prenom_tuteur, profession_tuteur, adresse_tuteur, tel_tuteur, mail_tuteur) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
              pr1.setInt(1, n_inscription);
              pr1.setString(2, cne);
              pr1.setString(3, nom); 
              pr1.setString(4, prenom);
              pr1.setString(5, date_naissance);
              pr1.setString(6, ville_naissance);
              pr1.setString(7, pays_naissance);
              pr1.setString(8, nationalite);
              pr1.setString(9, sexe);
              pr1.setString(10, cin);
              pr1.setString(11, datecin);
              pr1.setString(12, adresse);
              pr1.setString(13, ville);
              pr1.setString(14, pays);
              pr1.setString(15, tel);
              pr1.setString(16, email);
              pr1.setString(17, photo);
              pr1.setString(18, handicap);
              pr1.setString(19, nature_handicap);
              pr1.setString(20, num_carte_handicap);
              pr1.setString(21, bourse);
              pr1.setString(22, activite);
              pr1.setString(23, etablissement);
              pr1.setString(24, type_bac); 
              pr1.setString(25, serie_bac);
              pr1.setString(26, mention_bac);
              pr1.setString(27, moy_ER);
              pr1.setString(28, moy_EN);
              pr1.setString(29, math_EN);
              pr1.setString(30, phys_EN);
              pr1.setString(31, nat_EN);
              pr1.setString(32, lycee);
              pr1.setString(33, academie);
              pr1.setString(34, province);
              pr1.setString(35, filiere);
              pr1.setString(36, nom_pere); 
              pr1.setString(37, prenom_pere);
              pr1.setString(38, profession_pere);
              pr1.setString(39, nom_mere);
              pr1.setString(40, prenom_mere);
              pr1.setString(41, profession_mere);
              pr1.setString(42, nom_tuteur);
              pr1.setString(43, prenom_tuteur);
              pr1.setString(44, profession_tuteur);
              pr1.setString(45, adresse_tuteur);
              pr1.setString(46, tel_tuteur);
              pr1.setString(47, mail_tuteur);
              pr1.execute();           
             
        } catch(Exception e) {
                   e.printStackTrace();   
        }  
    }

    
    
    
    
}
