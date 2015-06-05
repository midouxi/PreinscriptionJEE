/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author macbookpro
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class InscriptionServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription0.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        
        if(request.getParameter("n_inscription")!=null){
           System.out.println(request.getParameter("n_inscription")); 
           request.setAttribute("numins", request.getParameter("n_inscription"));
        }
        
        if(request.getParameter("cne")!=null && request.getParameter("nom")!=null &&  request.getParameter("prenom")!=null && request.getParameter("date_naissance")!=null &&  request.getParameter("ville_naissance")!=null &&  request.getParameter("pays_naissance")!=null &&  request.getParameter("nationalite")!=null &&  request.getParameter("sexe")!=null &&  request.getParameter("cin")!=null &&  request.getParameter("date_cin")!=null &&  request.getParameter("adresse")!=null &&  request.getParameter("ville")!=null &&  request.getParameter("pays")!=null &&  request.getParameter("tel")!=null &&  request.getParameter("email")!=null && request.getPart("photo")!=null &&  request.getParameter("handicap")!=null &&  request.getParameter("nature_handicap")!=null &&  request.getParameter("num_carte_handicap")!=null &&  request.getParameter("bourse")!=null &&  request.getParameter("activite")!=null &&  request.getParameter("etablissement")!=null) {

            String path = request.getServletContext().getRealPath("");
            final Part filePart = request.getPart("photo");
            final String fileName = getFileName(filePart);

            OutputStream out = null;
            InputStream filecontent = null;
            //final PrintWriter writer = response.getWriter();

            try {
                out = new FileOutputStream(new File(path + File.separator
                        + fileName));
                filecontent = filePart.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                System.out.println("New file " + fileName + " created at " + path);
                /*LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                        new Object[]{fileName, path});*/
            } catch (FileNotFoundException fne) {
                System.out.println("You either did not specify a file to upload or are "
                        + "trying to upload a file to a protected or nonexistent "
                        + "location.");
                System.out.println("<br/> ERROR: " + fne.getMessage());

               /* LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                        new Object[]{fne.getMessage()});*/
            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
            }
            insertPersonnelle(request.getParameter("cne"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("date_naissance"), request.getParameter("ville_naissance"), request.getParameter("pays_naissance"), request.getParameter("nationalite"), request.getParameter("sexe"), request.getParameter("cin"), request.getParameter("date_cin"), request.getParameter("adresse"), request.getParameter("ville"), request.getParameter("pays"), request.getParameter("tel"), request.getParameter("email"), path+"/"+fileName , request.getParameter("handicap"), request.getParameter("nature_handicap"), request.getParameter("num_carte_handicap"), request.getParameter("bourse"), request.getParameter("activite"),request.getParameter("etablissement"));
            request.setAttribute("numins", getnumins(Integer.parseInt(request.getParameter("cne"))));
                        if(request.getParameter("lang").equals("fr")) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription2.jsp").forward(request, response);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/inscription2_ar.jsp").forward(request, response);
            }
            
        }
        else if(request.getParameter("n_inscription")!=null && request.getParameter("nom_pere")!=null && request.getParameter("prenom_pere")!=null && request.getParameter("profession_pere")!=null && request.getParameter("nom_mere")!=null && request.getParameter("prenom_mere")!=null && request.getParameter("profession_mere")!=null && request.getParameter("nom_tuteur")!=null && request.getParameter("prenom_tuteur")!=null && request.getParameter("profession_tuteur")!=null && request.getParameter("adresse_tuteur")!=null && request.getParameter("tel_tuteur")!=null && request.getParameter("mail_tuteur")!=null) {
            insertTuteur(request.getParameter("n_inscription"), request.getParameter("nom_pere"), request.getParameter("prenom_pere"), request.getParameter("profession_pere"), request.getParameter("nom_mere"), request.getParameter("prenom_mere"), request.getParameter("profession_mere"), request.getParameter("nom_tuteur"), request.getParameter("prenom_tuteur"), request.getParameter("profession_tuteur"), request.getParameter("adresse_tuteur"), request.getParameter("tel_tuteur"), request.getParameter("mail_tuteur"));
            if(request.getParameter("lang").equals("fr")) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription3.jsp").forward(request, response);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/inscription3_ar.jsp").forward(request, response);
            }
        }
        else if(request.getParameter("n_inscription")!=null && request.getParameter("type_bac")!=null && request.getParameter("serie_bac")!=null && request.getParameter("mention_bac")!=null && request.getParameter("moy_ER")!=null && request.getParameter("moy_EN")!=null && request.getParameter("math_EN")!=null && request.getParameter("phys_EN")!=null && request.getParameter("nat_EN")!=null && request.getParameter("lycee")!=null && request.getParameter("academie")!=null && request.getParameter("province")!=null && request.getParameter("filiere")!=null){
            insertBac(request.getParameter("n_inscription"), request.getParameter("type_bac"), request.getParameter("serie_bac"), request.getParameter("mention_bac"), request.getParameter("moy_ER"), request.getParameter("moy_EN"), request.getParameter("math_EN"), request.getParameter("phys_EN"), request.getParameter("nat_EN"), request.getParameter("lycee"), request.getParameter("academie"), request.getParameter("province"), request.getParameter("filiere"));
            if(request.getParameter("lang").equals("fr")) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription4.jsp").forward(request, response);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/inscription4_ar.jsp").forward(request, response);
            }
        }
        else if(request.getParameter("download")!=null && request.getParameter("n_inscription")!=null){
            //download un pdf
            System.out.println("c bon");
        } else if(request.getParameter("action1")!=null || request.getParameter("action2")!=null ) {
                request.setAttribute("cne", request.getParameter("cne"));
                ArrayList l = LectureFichier();
                if(l.contains(request.getParameter("cne"))){
                    for(int i = 0;i<l.size();i++) {
                        if(l.get(i).equals(request.getParameter("cne"))){
                            if(request.getParameter("action1")!=null) {
                                String nom=(String) l.get(i+1);
                                String prenom=(String) l.get(i+2);
                                System.out.println(nom+prenom);
                                request.setAttribute("nom",nom);  
                                request.setAttribute("prenom",prenom);
                                this.getServletContext().getRequestDispatcher("/WEB-INF/inscription1.jsp").forward(request, response);
                            } else {
                                String nom=(String) l.get(i+8);
                                String prenom=(String) l.get(i+9);
                                request.setAttribute("nom",nom);  
                                request.setAttribute("prenom",prenom);
                                System.out.println(nom+prenom);
                                 this.getServletContext().getRequestDispatcher("/WEB-INF/inscription1_ar.jsp").forward(request, response);
                            }
                        }
                    } 
                } 
            }
       
    }
    
     //METHODES   
    
    public void insertPersonnelle(String cne, String nom, String prenom, String date_naissance, String ville_naissance, String pays_naissance, String nationalite, String sexe, String cin, String datecin, String adresse, String ville, String pays, String tel, String email, String photo, String handicap, String nature_handicap, String num_carte_handicap, String bourse, String activite,String etablissement){
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("INSERT INTO personnelle (cne, nom, prenom, date_naissance, ville_naissance, pays_naissance, nationalite, sexe, cin, datecin, adresse, ville, pays, tel, email, photo, handicap, nature_handicap, num_carte_handicap, bourse,activite,etablissement) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)"); 
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
              pr3.execute();
              //pr3.toString();
        } catch(Exception e) {
                   e.printStackTrace();   
        }  
    }
    public void insertTuteur(String n_inscription, String nom_pere, String prenom_pere, String profession_pere, String nom_mere, String prenom_mere, String profession_mere, String nom_tuteur, String prenom_tuteur, String profession_tuteur, String adresse_tuteur, String tel_tuteur, String mail_tuteur){
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("INSERT INTO tuteur (n_inscription, nom_pere, prenom_pere, profession_pere, nom_mere, prenom_mere, profession_mere, nom_tuteur, prenom_tuteur, profession_tuteur, adresse_tuteur, tel_tuteur, mail_tuteur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
              pr3.setString(1, n_inscription);
              pr3.setString(2, nom_pere); 
              pr3.setString(3, prenom_pere);
              pr3.setString(4, profession_pere);
              pr3.setString(5, nom_mere);
              pr3.setString(6, prenom_mere);
              pr3.setString(7, profession_mere);
              pr3.setString(8, nom_tuteur);
              pr3.setString(9, prenom_tuteur);
              pr3.setString(10, profession_tuteur);
              pr3.setString(11, adresse_tuteur);
              pr3.setString(12, tel_tuteur);
              pr3.setString(13, mail_tuteur);

              pr3.execute();
              
        } catch(Exception e) {
                e.printStackTrace();   
        }  
    }
    public void insertBac(String n_inscription, String type_bac, String serie_bac, String mention_bac, String moy_ER, String moy_EN, String math_EN, String phys_EN, String nat_EN, String lycee, String academie, String province, String filiere){
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("INSERT INTO baccalaureat (n_inscription, type_bac, serie_bac, mention_bac, moy_ER, moy_EN, math_EN, phys_EN, nat_EN, lycee, academie, province, filiere) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
              pr3.setString(1, n_inscription);
              pr3.setString(2, type_bac); 
              pr3.setString(3, serie_bac);
              pr3.setString(4, mention_bac);
              pr3.setString(5, moy_ER);
              pr3.setString(6, moy_EN);
              pr3.setString(7, math_EN);
              pr3.setString(8, phys_EN);
              pr3.setString(9, nat_EN);
              pr3.setString(10, lycee);
              pr3.setString(11, academie);
              pr3.setString(12, province);
              pr3.setString(13, filiere);

              pr3.execute();
              
        } catch(Exception e) {
                   e.printStackTrace();   
        }  
    }
    
    public int getnumins(int cne){
        int[] resultat= new int[10];
        try {
           Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiant","root","");
	    PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement("SELECT n_inscription FROM personnelle WHERE CNE=?"); 
              pr3.setInt(1, cne);
              ResultSet ret=pr3.executeQuery();
              while(ret.next()){
                resultat[0]=ret.getInt(1);
              }
              pr3.close();
        } catch(Exception e) {
                   e.printStackTrace();   
        }  
        return resultat[0];
    }
    
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("Header--->"+partHeader);
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    public ArrayList LectureFichier(){
        File filename= new File("/Users/macbookpro/NetBeansProjects/PreInsciption/build/web/MEN_Candidats.txt");
        String line; 
        ArrayList liste=new ArrayList();
        try {
            BufferedReader input= new BufferedReader(new FileReader (filename));
            if(!input.ready()) {
                throw  new IOException() ;
            }
            while((line=input.readLine())!=null) {
                    
                StringTokenizer s = new StringTokenizer(new String(line.getBytes(),"UTF-8"));

                String cne =(String)s.nextToken();
                liste.add(cne);
                String nom=(String)s.nextToken();
                liste.add(nom);
                String prenom=(String)s.nextToken();
                liste.add(prenom);
                String type_bac =(String)s.nextToken();
                liste.add(type_bac);
                String serie_bac =(String)s.nextToken();
                liste.add(serie_bac);
                String mention_bac =(String)s.nextToken();
                liste.add(mention_bac);
                String lycee =(String)s.nextToken();
                liste.add(lycee);
                String academie =(String)s.nextToken();
                liste.add(academie);
                String nom_ar=(String)s.nextToken();
                liste.add(nom_ar);
                String prenom_ar=(String)s.nextToken();
                liste.add(prenom_ar);
                String type_bac_ar =(String)s.nextToken();
                liste.add(type_bac_ar);
                String serie_bac_ar =(String)s.nextToken();
                liste.add(serie_bac_ar);
                String mention_bac_ar =(String)s.nextToken();
                liste.add(mention_bac_ar);
                String lycee_ar =(String)s.nextToken();
                liste.add(lycee_ar);
                String academie_ar =(String)s.nextToken();
                liste.add(academie_ar);      
          
            }
            input.close();
	} catch (IOException e) {
            System.out.println(e);
	}
        return liste;
   }
}
    

