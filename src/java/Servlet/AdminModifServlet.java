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
        
        if(request.getParameter("modifie")!=null) {
 
            int n_inscription= Integer.parseInt(request.getParameter("ninsc"));
            System.out.println(n_inscription);
            request.setAttribute("ninsc",n_inscription);
            request.setAttribute("cne", extractor(n_inscription,"personnelle","cne"));
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
            request.setAttribute("nature_handicap", extractor(n_inscription,"personnelle","nature_handicap"));
            request.setAttribute("num_carte_handicap", extractor(n_inscription,"personnelle","num_carte_handicap"));
            request.setAttribute("bourse", extractor(n_inscription,"personnelle","bourse"));
            request.setAttribute("activite", extractor(n_inscription,"personnelle","activite"));
        
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminmodif1.jsp").forward(request, response);
        
        } else if (request.getParameter("cne")!=null && request.getParameter("nom")!=null &&  request.getParameter("prenom")!=null && request.getParameter("date_naissance")!=null &&  request.getParameter("ville_naissance")!=null &&  request.getParameter("pays_naissance")!=null &&  request.getParameter("nationalite")!=null &&  request.getParameter("sexe")!=null &&  request.getParameter("cin")!=null &&  request.getParameter("datecin")!=null &&  request.getParameter("adresse")!=null &&  request.getParameter("ville")!=null &&  request.getParameter("pays")!=null &&  request.getParameter("tel")!=null &&  request.getParameter("email")!=null && request.getParameter("photo")!=null &&  request.getParameter("handicap")!=null &&  request.getParameter("nature_handicap")!=null &&  request.getParameter("num_carte_handicap")!=null &&  request.getParameter("bourse")!=null &&  request.getParameter("activite")!=null &&  request.getParameter("etablissement")!=null) {
            
            int n_inscription = Integer.parseInt(request.getParameter("ninsc"));
            update_pers(n_inscription,request.getParameter("cne"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("date_naissance"),request.getParameter("ville_naissance"),request.getParameter("pays_naissance"),request.getParameter("nationalite"),request.getParameter("sexe"),request.getParameter("cin"),request.getParameter("datecin"),request.getParameter("adresse"),request.getParameter("ville"),request.getParameter("pays"),request.getParameter("tel"),  request.getParameter("email"), request.getParameter("photo"),request.getParameter("handicap"),request.getParameter("nature_handicap"),request.getParameter("num_carte_handicap"),request.getParameter("bourse"),request.getParameter("activite"),request.getParameter("etablissement"));
            request.setAttribute("ninsc",n_inscription);
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
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminmodif2.jsp").forward(request, response);
            
        } else if (request.getParameter("nom_pere")!=null && request.getParameter("prenom_pere")!=null && request.getParameter("profession_pere")!=null && request.getParameter("nom_mere")!=null && request.getParameter("prenom_mere")!=null && request.getParameter("profession_mere")!=null && request.getParameter("nom_tuteur")!=null && request.getParameter("prenom_tuteur")!=null && request.getParameter("profession_tuteur")!=null && request.getParameter("adresse_tuteur")!=null && request.getParameter("tel_tuteur")!=null && request.getParameter("mail_tuteur")!=null) {

            int n_inscription = Integer.parseInt(request.getParameter("ninsc"));
            
            update_tuteur(n_inscription,request.getParameter("nom_pere"),request.getParameter("prenom_pere"),request.getParameter("profession_pere"),request.getParameter("nom_mere"),request.getParameter("prenom_mere"),request.getParameter("profession_mere"),request.getParameter("nom_tuteur"),request.getParameter("prenom_tuteur"),request.getParameter("profession_tuteur"),request.getParameter("adresse_tuteur"),request.getParameter("tel_tuteur"),request.getParameter("mail_tuteur"));
            request.setAttribute("ninsc",n_inscription);
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
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminmodif3.jsp").forward(request, response);
            
        } else if(request.getParameter("type_bac")!=null && request.getParameter("serie_bac")!=null && request.getParameter("mention_bac")!=null && request.getParameter("moy_ER")!=null && request.getParameter("moy_EN")!=null && request.getParameter("math_EN")!=null && request.getParameter("phys_EN")!=null && request.getParameter("nat_EN")!=null && request.getParameter("lycee")!=null && request.getParameter("academie")!=null && request.getParameter("province")!=null && request.getParameter("filiere")!=null){
            int n_inscription = Integer.parseInt(request.getParameter("ninsc"));
            update_bac(n_inscription, request.getParameter("type_bac"), request.getParameter("serie_bac"), request.getParameter("mention_bac"), request.getParameter("moy_ER"), request.getParameter("moy_EN"), request.getParameter("math_EN"), request.getParameter("phys_EN"), request.getParameter("nat_EN"), request.getParameter("lycee"), request.getParameter("academie"), request.getParameter("province"), request.getParameter("filiere"));
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminmodif4.jsp").forward(request, response);
        }
    }
        
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    public String extractor(int n_inscription,String table,String select) {
        String result=null; 
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
            String query = "SELECT "+select+" FROM "+table+" WHERE n_inscription='"+n_inscription+"'";
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
    
    public void update_pers(int n_inscription,String cne, String nom, String prenom, String date_naissance, String ville_naissance, String pays_naissance, String nationalite, String sexe, String cin, String datecin, String adresse, String ville, String pays, String tel, String email, String photo, String handicap, String nature_handicap, String num_carte_handicap, String bourse, String activite,String etablissement) {
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("UPDATE personnelle SET cne=?,nom=?, prenom=?, date_naissance=?, ville_naissance=?, pays_naissance=?, nationalite=?, sexe=?, cin=?, datecin=?, adresse=?, ville=?, pays=?, tel=?, email=?, photo=?, handicap=?, nature_handicap=?, num_carte_handicap=?, bourse=?, activite=?, etablissement=? WHERE n_inscription=?"); 
              pr3.setString(1, cne);
              pr3.setString(2, nom); 
              pr3.setString(3, prenom);
              pr3.setString(4, date_naissance);
              pr3.setString(5, ville_naissance);
              pr3.setString(6, pays_naissance);
              pr3.setString(7, nationalite);
              pr3.setString(8, sexe);
              pr3.setString(9, cin);
              pr3.setString(10, datecin);
              pr3.setString(11, adresse);
              pr3.setString(12, ville);
              pr3.setString(13, pays);
              pr3.setString(14, tel);
              pr3.setString(15, email);
              pr3.setString(16, photo);
              pr3.setString(17, handicap);
              pr3.setString(18, nature_handicap);
              pr3.setString(19, num_carte_handicap);
              pr3.setString(20, bourse);
              pr3.setString(21, activite);
              pr3.setString(22, etablissement);
              pr3.setInt(23, n_inscription);

              pr3.execute();
              System.out.println(pr3.toString());
              
        } catch(Exception e) {
                e.printStackTrace();   
        }  
    }
    
    public void update_tuteur(int n_inscription, String nom_pere, String prenom_pere, String profession_pere, String nom_mere, String prenom_mere, String profession_mere, String nom_tuteur, String prenom_tuteur, String profession_tuteur, String adresse_tuteur, String tel_tuteur, String mail_tuteur){
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("UPDATE tuteur SET nom_pere=?, prenom_pere=?, profession_pere=?, nom_mere=?, prenom_mere=?, profession_mere=?, nom_tuteur=?, prenom_tuteur=?, profession_tuteur=?, adresse_tuteur=?, tel_tuteur=?, mail_tuteur=? WHERE n_inscription=?"); 
              
              pr3.setString(1, nom_pere); 
              pr3.setString(2, prenom_pere);
              pr3.setString(3, profession_pere);
              pr3.setString(4, nom_mere);
              pr3.setString(5, prenom_mere);
              pr3.setString(6, profession_mere);
              pr3.setString(7, nom_tuteur);
              pr3.setString(8, prenom_tuteur);
              pr3.setString(9, profession_tuteur);
              pr3.setString(10, adresse_tuteur);
              pr3.setString(11, tel_tuteur);
              pr3.setString(12, mail_tuteur);
              pr3.setInt(13, n_inscription);

              pr3.execute();
              
        } catch(Exception e) {
                e.printStackTrace();   
        }  
    }
    public void update_bac(int n_inscription, String type_bac, String serie_bac, String mention_bac, String moy_ER, String moy_EN, String math_EN, String phys_EN, String nat_EN, String lycee, String academie, String province, String filiere){
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("UPDATE baccalaureat SET type_bac=?, serie_bac=?, mention_bac=?, moy_ER=?, moy_EN=?, math_EN=?, phys_EN=?, nat_EN=?, lycee=?, academie=?, province=?, filiere=? WHERE n_inscription=?"); 
              
              pr3.setString(1, type_bac); 
              pr3.setString(2, serie_bac);
              pr3.setString(3, mention_bac);
              pr3.setString(4, moy_ER);
              pr3.setString(5, moy_EN);
              pr3.setString(6, math_EN);
              pr3.setString(7, phys_EN);
              pr3.setString(8, nat_EN);
              pr3.setString(9, lycee);
              pr3.setString(10, academie);
              pr3.setString(11, province);
              pr3.setString(12, filiere);
              pr3.setInt(13, n_inscription);

              pr3.execute();
              
        } catch(Exception e) {
                   e.printStackTrace();   
        }  
    }
}
