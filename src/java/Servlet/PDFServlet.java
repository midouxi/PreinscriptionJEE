/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author macbookpro
 */
public class PDFServlet extends HttpServlet {
        
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
        Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String FILE = getServletContext().getRealPath("")+"/Inscription"+"_"+extractor(request.getParameter("n_inscription"), "personnelle", "cne")+".pdf";
        try {
            
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            
            //addMetaData(document);
            addTitlePage(document,request.getParameter("n_inscription"));
            document.add(createTable(request.getParameter("n_inscription")));
            
            
            //addContent(document);
            document.close();
            } catch (Exception e) {
              e.printStackTrace();
            }
        File downloadFile = new File(FILE);
        FileInputStream inStream = new FileInputStream(downloadFile);
        // obtains ServletContext
        ServletContext context = getServletContext();
         
        // gets MIME type of the file
        String mimeType = context.getMimeType(FILE);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();
        
    }
    
    public void addTitlePage(Document document,String ninsc) throws DocumentException, UnsupportedEncodingException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        
        // Lets write a big header
        Image CurentImage;
            try {
                CurentImage = Image.getInstance("/Users/macbookpro/NetBeansProjects/PreInsciption/build/web/uh2.png");
                
                //CurentImage.setAbsolutePosition(0,0);
                preface.add(CurentImage);
                //preface.add(2,CurentImage);
            } catch (BadElementException ex) {
                Logger.getLogger(PDFServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PDFServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        preface.add(new Paragraph("Université Hassan 1er", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph("Formulaire d'inscription (faite "+new SimpleDateFormat("'le' dd MMMM yyyy 'à' HH:mm:ss").format(new Date())+")", smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(new String(extractor(ninsc, "personnelle", "etablissement"),"UTF-8"),smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Veuillez présenter ce formulaire au service de scolarité",
            redFont));
        addEmptyLine(preface, 1);
        document.add(preface);
        // Start a new page
        //document.newPage();
    }
    
    public PdfPTable createTable(String n_inscription) throws BadElementException, UnsupportedEncodingException {
        int [] f = new int[2];
        f[0]=300;
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        String ninsc = n_inscription;
        PdfPCell c1 = new PdfPCell(new Phrase("Informations"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Données"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        table.setHeaderRows(1);

                table.addCell("CNE");
        table.addCell(new String(extractor(ninsc, "personnelle", "cne"),"UTF-8"));
        table.addCell("Nom");
        table.addCell(new String(extractor(ninsc, "personnelle", "nom"),"UTF-8"));
        table.addCell("Prénom");
        table.addCell(new String(extractor(ninsc, "personnelle", "prenom"),"UTF-8"));
        table.addCell("Date de Naissance");
        table.addCell(new String(extractor(ninsc, "personnelle", "date_naissance"),"UTF-8"));
        table.addCell("Ville de Naissance");
        table.addCell(new String(extractor(ninsc, "personnelle", "ville_naissance"),"UTF-8"));
        table.addCell("Pays de Naissance");
        table.addCell(new String(extractor(ninsc, "personnelle", "pays_naissance"),"UTF-8"));
        table.addCell("Nationalité");
        table.addCell(new String(extractor(ninsc, "personnelle", "nationalite"),"UTF-8"));
        table.addCell("Sexe");
        table.addCell(new String(extractor(ninsc, "personnelle", "sexe"),"UTF-8"));
        table.addCell("N˚ CIN");
        table.addCell(new String(extractor(ninsc, "personnelle", "cin"),"UTF-8"));
        table.addCell("Date de Délivrance");
        table.addCell(new String(extractor(ninsc, "personnelle", "datecin"),"UTF-8"));
        table.addCell("Adresse");
        table.addCell(new String(extractor(ninsc, "personnelle", "adresse"),"UTF-8"));
        table.addCell("Ville");
        table.addCell(new String(extractor(ninsc, "personnelle", "ville"),"UTF-8"));
        table.addCell("Pays");
        table.addCell(new String(extractor(ninsc, "personnelle", "pays"),"UTF-8"));
        table.addCell("Téléphone");
        table.addCell(new String(extractor(ninsc, "personnelle", "tel"),"UTF-8"));
        table.addCell("Email");
        table.addCell(new String(extractor(ninsc, "personnelle", "email"),"UTF-8"));
        table.addCell("Handicap ?");
        table.addCell(new String(extractor(ninsc, "personnelle", "handicap"),"UTF-8"));
        table.addCell("Nature d'Handicap");
        table.addCell(new String(extractor(ninsc, "personnelle", "nature_handicap"),"UTF-8"));
        table.addCell("N˚ Carte Handicap");
        table.addCell(new String(extractor(ninsc, "personnelle", "num_carte_handicap"),"UTF-8"));
        table.addCell("Bourse");
        table.addCell(new String(extractor(ninsc, "personnelle", "bourse"),"UTF-8"));
        table.addCell("Activité Parascolaire");
        table.addCell(new String(extractor(ninsc, "personnelle", "activite"),"UTF-8"));
        table.addCell("Type de Bac");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "type_bac"),"UTF-8"));
        table.addCell("Série du Bac");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "serie_bac"),"UTF-8"));
        table.addCell("Mention du Bac");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "mention_bac"),"UTF-8"));
        table.addCell("Moyenne de l'examen régional");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "moy_ER"),"UTF-8"));
        table.addCell("Moyenne de l'examen national");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "moy_EN"),"UTF-8"));
        table.addCell("Moyenne des mathématiques de l'examen national");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "math_EN"),"UTF-8"));
        table.addCell("Moyenne du physique de l'examen national");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "phys_EN"),"UTF-8"));
        table.addCell("Moyenne de SVT de l'examen national");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "nat_EN"),"UTF-8"));
        table.addCell("Lycée");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "lycee"),"UTF-8"));
        table.addCell("Académie");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "academie"),"UTF-8"));
        table.addCell("Province");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "province"),"UTF-8"));
        table.addCell("Filière");
        table.addCell(new String(extractor(ninsc, "baccalaureat", "filiere"),"UTF-8"));
        table.addCell("Nom du Père");
        table.addCell(new String(extractor(ninsc, "tuteur", "nom_pere"),"UTF-8"));
        table.addCell("Prénom du Père");
        table.addCell(new String(extractor(ninsc, "tuteur", "prenom_pere"),"UTF-8"));
        table.addCell("Profession du Père");
        table.addCell(new String(extractor(ninsc, "tuteur", "profession_pere"),"UTF-8"));
        table.addCell("Nom de la Mère");
        table.addCell(new String(extractor(ninsc, "tuteur", "nom_mere"),"UTF-8"));
        table.addCell("Prénom de la Mère");
        table.addCell(new String(extractor(ninsc, "tuteur", "prenom_mere"),"UTF-8"));
        table.addCell("Profession de la Mère");
        table.addCell(new String(extractor(ninsc, "tuteur", "profession_mere"),"UTF-8"));
        table.addCell("Nom du Tuteur");
        table.addCell(new String(extractor(ninsc, "tuteur", "nom_tuteur"),"UTF-8"));
        table.addCell("Prénom du Tuteur");
        table.addCell(new String(extractor(ninsc, "tuteur", "prenom_tuteur"),"UTF-8"));
        table.addCell("Profession du Tuteur");
        table.addCell(new String(extractor(ninsc, "tuteur", "profession_tuteur"),"UTF-8"));
        table.addCell("Adresse du Tuteur");
        table.addCell(new String(extractor(ninsc, "tuteur", "adresse_tuteur"),"UTF-8"));
        table.addCell("Téléphone du Tuteur");
        table.addCell(new String(extractor(ninsc, "tuteur", "tel_tuteur"),"UTF-8"));
        table.addCell("Email du Tuteur");
        table.addCell(new String(extractor(ninsc, "tuteur", "mail_tuteur"),"UTF-8"));
        return table;
        
        
     }

    public void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
          paragraph.add(new Paragraph(" "));
        }
    }
    
    public byte[] extractor(String n_inscription,String table,String select) throws UnsupportedEncodingException{
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
        return result.getBytes();
    }
}