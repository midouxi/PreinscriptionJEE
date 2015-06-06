/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.EtudiantBean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author macbookpro
 */
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(check(request.getParameter("login"),request.getParameter("mdp"))) {
            request.setAttribute("e", Display(0));
            request.getSession().setAttribute("login",request.getParameter("login"));
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminInsc.jsp").forward(request, response);
        }
        else {
            request.setAttribute("alerte", "Combinaison login/Mot de passe est incorrecte");
            this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        }
      
    }
    
    public boolean check(String login,String mdp){
        String[] result = new String[3];
        boolean resultat = false;
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Admin","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("SELECT * FROM User WHERE login=? AND mdp=?"); 
            pr3.setString(1, login);
            pr3.setString(2, mdp);
            ResultSet re= (ResultSet) pr3.executeQuery();
            //System.out.println(re.getString(0)+re.getString(1)+re.getString(2));
            while(re.next()){
                result[0]=re.getString(2);
                result[1]=re.getString(3);
            }
            if(result[0].equals(login) && result[1].equals(mdp)){
                resultat = true;  
            }
            //return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resultat;
    }
    
    public ArrayList Display(int valide){
    
 ArrayList Info = new ArrayList<EtudiantBean>();
 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 try{
          Class.forName("com.mysql.jdbc.Driver");
       
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
          Statement statement = con.createStatement() ;

          
          
          ResultSet rs = statement. executeQuery("SELECT personnelle.n_inscription,personnelle.cne,personnelle.nom,personnelle.prenom,personnelle.etablissement,baccalaureat.serie_bac,baccalaureat.moy_EN,baccalaureat.filiere,baccalaureat.date_inscription FROM personnelle INNER JOIN baccalaureat on personnelle.n_inscription=baccalaureat.n_inscription WHERE baccalaureat.valide ='"+valide+"' AND baccalaureat.supprime='0'");

          while(rs.next() ){
     
         Integer n_inscription = rs.getInt("n_inscription" );
         String cne = rs.getString("cne" );
         String nom = rs.getString("nom" );
         String prenom = rs.getString("prenom" );
         String serie_bac = rs.getString("serie_bac" );
         String moy_EN = rs.getString("moy_EN");
         String filiere= rs.getString("filiere");
         String etablissement = rs.getString("etablissement" );
         //String date = df.format(df.parse(rs.getTimestamp("date_inscription").toString()));
         String date = rs.getString("date_inscription");

         
         
        EtudiantBean et;
        et = new EtudiantBean(n_inscription, cne, nom, prenom, serie_bac, moy_EN, filiere, etablissement,date);
        Info.add(et);
      }
 } catch(Exception a){
        System.out.println(a); }
      
   
    return Info;
}
    
    public void Supprimer(int n_inscription){
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
          Statement statement = con.createStatement() ;
          ResultSet rs = statement.executeQuery("UPDATE baccalaureat SET supprime ='1' WHERE n_inscription ="+n_inscription+"");   
         } catch (Exception e){
             e.printStackTrace();
         }
    }
    
    public void ajouteretudiant(){
       
    }
}
