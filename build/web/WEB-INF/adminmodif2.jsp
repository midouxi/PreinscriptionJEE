<%-- 
    Document   : adminmodif1
    Created on : 5 juin 2015, 09:01:32
    Author     : macbookpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <h1>Modification - Etape 2</h1>
        
        <form action="InscriptionServlet" method="POST" enctype="multipart/form-data">
            Nom du père : <input name="nom_pere" required/> <br /><br />
            Prénom du Père : <input name="prenom_pere" required/> <br /><br />
            Profession du Père : <input name="profession_pere" required/> <br /><br />
            Nom de la mère : <input name="nom_mere" required/> <br /><br />
            Prénom de la mère : <input name="prenom_mere" required/> <br /><br />
            Profession de la mère : <input name="profession_mere" required/> <br /><br />
            Nom Tuteur : <input name="nom_tuteur" required/> <br /><br />
            Prénom Tuteur : <input name="prenom_tuteur" required/> <br /><br />
            Profession Tuteur : <input name="profession_tuteur" required/> <br /><br />
            Adresse Tuteur : <input name="adresse_tuteur" required/> <br /><br />
            Téléphone Tuteur : <input name="tel_tuteur" required/> <br /><br />
            Email Tuteur : <input name="mail_tuteur" required/> <br /><br /><br />
            <input type="hidden" name="n_inscription" value="<%=request.getAttribute("numins")%>" />
            <input type="hidden" name="lang" value="fr"/>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
