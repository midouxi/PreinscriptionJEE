<%-- 
    Document   : inscription1.jsp
    Created on : 22 mai 2015, 11:45:09
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
        <h1>Préinscription - Etape 3</h1>
        <form action="InscriptionServlet" method="POST" enctype="multipart/form-data">
            Type Bac : <input name="type_bac" required/> <br /><br />
            Série Bac : <input name="serie_bac" required/> <br /><br />
            Mention Bac : <input name="mention_bac" required/> <br /><br />
            Moyenne de l'examen régional : <input name="moy_ER" required/> <br /><br />
            Moyenne de l'examen national : <input name="moy_EN" required/> <br /><br />
            Note Math de l'examen National : <input name="math_EN" required/> <br /><br />
            Note Physique de l'examen National : <input name="phys_EN" required/> <br /><br />
            Note Sciences de la vie et de la terre de l'examen National : <input name="nat_EN" required/> <br /><br />
            Lycée : <input name="lycee" required/> <br /><br />
            Académie : <input name="academie" required/> <br /><br />
            Province : <input name="province" required/> <br /><br />
            Filière : <input name="filiere" required/> <br /><br />
            <input type="hidden" name="n_inscription" value="<%=request.getAttribute("numins")%>" />
            <input type="hidden" name="lang" value="fr"/>
            <input type="submit" value="Valider"/>
        </form>
            
    </body>
</html>
