/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Toshiba
 */
public class ServletAjouterEtudiant extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
          ArrayList liste=new ArrayList();
        
   
        
    
    liste.add(0,request.getParameter("cne"));
    liste.add(1,request.getParameter("nom"));
    liste.add(2,request.getParameter("prenom"));
    liste.add(3,request.getParameter("type_bac"));
    liste.add(4,request.getParameter("serie_bac"));
    liste.add(5,request.getParameter("mention_bac"));
    liste.add(6,request.getParameter("lycee"));
    liste.add(7,request.getParameter("academie"));
    liste.add(8,request.getParameter("nom_ar"));
    liste.add(9,request.getParameter("prenom_ar"));
    liste.add(10,request.getParameter("type_bac_ar"));
    liste.add(11,request.getParameter("serie_bac_ar"));
    liste.add(12,request.getParameter("mention_bac_ar"));
    liste.add(13,request.getParameter("lycee_ar"));
    liste.add(14,request.getParameter("academie_ar"));
    if((request.getParameter("ajouter"))!=null){

	
	try
	{
            String line=liste.get(0)+" "+liste.get(1)+" "+liste.get(2)+" "+liste.get(3)+" "
       +liste.get(4)+" "+liste.get(5)+" "+liste.get(6)+" "
        +liste.get(7)+" "+liste.get(8)+" "+liste.get(9)+" "+liste.get(10)+" "
        +liste.get(11)+" "+liste.get(12)+" "+liste.get(13)+" "+liste.get(14);


            String l;
            ArrayList<String> lines = new ArrayList<String>();
            File filename= new File("C:\\Users\\Toshiba\\Documents\\NetBeansProjects\\Preinscription en ligne\\info_Bacheliers.txt");
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(filename), "UTF8"));
            while ((l= br.readLine()) != null) {
                lines.add(l);
            }
            
            lines.add(new String(line.getBytes(),"UTF-8"));
            
        fr.close();
        br.close();
        FileWriter fw = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(fw);
        Pattern pattern = Pattern.compile("\r\n");
        for(int h=0;h<lines.size();h++){
            String t=new String(lines.get(h).getBytes(),"UTF-8");
            out.write(t);
            out.newLine();
        }
         out.flush();
         out.close();
        }
	 catch (IOException e) {
		 System.out.println( e);
	}
        
        this. getServletContext( ).getRequestDispatcher( "/WEB-INF/admin.jsp").forward( request, response ) ;
    }
         this. getServletContext( ).getRequestDispatcher( "/WEB-INF/AjoutEtudiant.jsp").forward( request, response ) ;
    }

}
