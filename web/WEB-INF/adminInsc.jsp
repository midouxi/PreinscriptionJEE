<%-- 
    Document   : admin1
    Created on : 1 juin 2015, 01:21:00
    Author     : macbookpro
--%>

<%@page import="Beans.EtudiantBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <div>
                <div>
                    <ul>
                        <li><a href="adminpage.php">Inscription</a></li>
                        <li><a href="adminpage2.php">Inscription final</a></li>
                        <li><a href="AdminSearchServlet" >Chercher Etudiant </a></li>
                        <li><a href="logoutadmin.php" >Ajout Etudiant</a></li>
                        <li><a href="logoutadmin.php" >Statistique</a></li>
                        <li><a href="logoutadmin.php" >Déconnexion</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <table class="table table-striped table-bordered">
 				<thead>
            <tr>
              <td>DATE D'INSCRIPTION</td>
              <td>N˚INSCRIPTION</td>
              <td>CNE</td>
              <td>NOM</td>
              <td>PRENOM</td>
              <td>SERIE BAC</td>
              <td>NOTE NATIONAL</td>
              <td>ETABLISSEMENT</td>
              <td>FILIERE</td>
             <td>TRAITEMENT</td>
            </tr>
        </thead>
         <%ArrayList l=(ArrayList)request.getAttribute("e");
                    
            for(int j=0;j<l.size();j++){%>
            <tr>
                <td class="style1"><%EtudiantBean i =(EtudiantBean)l.get(j); 
                    out.println(i.getDate()); %> </td>
                <td class="style1">  <% out.println(i.getN_inscription());%> </td>
                <td class="style1"> <% out.println(i.getCne());%> </td>
                <td class="style1"><% out.println(i.getNom());%> </td>
                <td class="style1"><%  out.println(i.getPrenom());%></td>
                <td class="style1"><%  out.println(i.getSerie_bac());%></td>
                <td class="style1"><%  out.println(i.getMoy_EN());%></td>
                <td class="style1"><%  out.println(i.getEtablissement());%></td>
                <td class="style1"><%  out.println(i.getFiliere());%></td>
                <td> 
                    <form action="AdminModifServlet" method="get"/>
                        <input type="submit" name="modifie" value="Modifier" />
                        <input type="hidden" name="ninsc" value="<% out.print(i.getN_inscription());%>" />
                    </form>
                    <form action="AdminSupprServlet" method="get"/>
                        <input type="submit" name="suppr" value="Supprimer" onclick="return confirm('Etes-vous sûr que vous voulez supprimer ce compte ?')" />
                        <input type="hidden" name="ninsc" value="<% out.print(i.getN_inscription());%>" />
                    </form>
                    <form action="AdminValidationServlet" method="get"/>
                        <input type="submit" name="valid" value="Valider" />
                        <input type="hidden" name="ninsc" value="<% out.print(i.getN_inscription());%>" />
                    </form>
                </td>
               
            </tr>
            <%}
            %>
    </body>
</html>
