<%-- 
    Document   : adminvalid0
    Created on : 6 juin 2015, 03:52:36
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
        <h1>Validation</h1>
        <form action='AdminValidationServlet' method='GET'/>
            CNE : <%out.print(request.getAttribute("cne"));%><br /><br />
            <input type="hidden" name="cne" value="<%out.print(request.getAttribute("cne"));%>"/>
            Établissement souhaité : <%out.print(request.getAttribute("etablissement"));%><br /><br />
            <input type="hidden" name="etablissement" value="<%out.print(request.getAttribute("etablissement"));%>"/>
            Nom : <%out.print(request.getAttribute("nom"));%><br /><br />
            <input type="hidden" name="nom" value="<%out.print(request.getAttribute("nom"));%>"/>
            Prénom : <%out.print(request.getAttribute("prenom"));%><br /><br />
            <input type="hidden" name="prenom" value="<%out.print(request.getAttribute("prenom"));%>"/>
            Date de Naissance : <%out.print(request.getAttribute("date_naissance"));%><br /><br />
            <input type="hidden" name="date_naissance" value="<%out.print(request.getAttribute("date_naissance"));%>"/>
            Ville de Naissance : <%out.print(request.getAttribute("ville_naissance"));%><br /><br />
            <input type="hidden" name="ville_naissance" value="<%out.print(request.getAttribute("ville_naissance"));%>"/>
            Pays de Naissance : <%out.print(request.getAttribute("pays_naissance"));%><br /><br />
            <input type="hidden" name="pays_naissance" value="<%out.print(request.getAttribute("pays_naissance"));%>"/>
            Nationalité : <%out.print(request.getAttribute("nationalite"));%><br /><br />
            <input type="hidden" name="nationalite" value="<%out.print(request.getAttribute("nationalite"));%>"/>
            Sexe : <%out.print(request.getAttribute("sexe"));%><br /><br />
            <input type="hidden" name="sexe" value="<%out.print(request.getAttribute("sexe"));%>"/>
            CIN : <%out.print(request.getAttribute("cin"));%><br /><br />
            <input type="hidden" name="cin" value="<%out.print(request.getAttribute("cin"));%>"/>
            Date de CIN : <%out.print(request.getAttribute("datecin"));%><br /><br />
            <input type="hidden" name="datecin" value="<%out.print(request.getAttribute("datecin"));%>"/>
            Adresse : <%out.print(request.getAttribute("adresse"));%><br /><br />
            <input type="hidden" name="adresse" value="<%out.print(request.getAttribute("adresse"));%>"/>
            Ville : <%out.print(request.getAttribute("ville"));%><br /><br />
            <input type="hidden" name="ville" value="<%out.print(request.getAttribute("ville"));%>"/>
            Pays : <%out.print(request.getAttribute("pays"));%><br /><br />
            <input type="hidden" name="pays" value="<%out.print(request.getAttribute("pays"));%>"/>
            Téléphone : <%out.print(request.getAttribute("tel"));%><br /><br />
            <input type="hidden" name="tel" value="<%out.print(request.getAttribute("tel"));%>"/>
            Email : <%out.print(request.getAttribute("email"));%><br /><br />
            <input type="hidden" name="email" value="<%out.print(request.getAttribute("email"));%>"/>
            Photo : <%out.print(request.getAttribute("photo"));%><br /><br />
            <input type="hidden" name="photo" value="<%out.print(request.getAttribute("photo"));%>"/>
            Handicapé ? : <%out.print(request.getAttribute("handicap"));%><br /><br />
            <input type="hidden" name="handicap" value="<%out.print(request.getAttribute("handicap"));%>"/>
            Nature de l'handicap : <%out.print(request.getAttribute("nature_handicap"));%> <br /><br />
            <input type="hidden" name="nature_handicap" value="<%out.print(request.getAttribute("nature_handicap"));%>"/>
            Num de la carte de l'handicap : <%out.print(request.getAttribute("num_carte_handicap"));%><br /><br />
            <input type="hidden" name="num_carte_handicap" value="<%out.print(request.getAttribute("num_carte_handicap"));%>"/>
            Bourse : <%out.print(request.getAttribute("bourse"));%><br /><br />
            <input type="hidden" name="bourse" value="<%out.print(request.getAttribute("bourse"));%>"/>
            Activité : <%out.print(request.getAttribute("activite"));%><br /><br />
            <input type="hidden" name="activite" value="<%out.print(request.getAttribute("activite"));%>"/>
            Nom du père : <%out.print(request.getAttribute("nom_pere"));%><br /><br />
            <input type="hidden" name="nom_pere" value="<%out.print(request.getAttribute("nom_pere"));%>"/>
            Prénom du Père : <%out.print(request.getAttribute("prenom_pere"));%><br /><br />
            <input type="hidden" name="prenom_pere" value="<%out.print(request.getAttribute("prenom_pere"));%>"/>
            Profession du Père : <%out.print(request.getAttribute("profession_pere"));%><br /><br />
            <input type="hidden" name="profession_pere" value="<%out.print(request.getAttribute("profession_pere"));%>"/>
            Nom de la mère : <%out.print(request.getAttribute("nom_mere"));%><br /><br />
            <input type="hidden" name="nom_mere" value="<%out.print(request.getAttribute("nom_mere"));%>"/>
            Prénom de la mère : <%out.print(request.getAttribute("prenom_mere"));%><br /><br />
            <input type="hidden" name="prenom_mere" value="<%out.print(request.getAttribute("prenom_mere"));%>"/>
            Profession de la mère : <%out.print(request.getAttribute("profession_mere"));%><br /><br />
            <input type="hidden" name="profession_mere" value="<%out.print(request.getAttribute("profession_mere"));%>"/>
            Nom Tuteur : <%out.print(request.getAttribute("nom_tuteur"));%><br /><br />
            <input type="hidden" name="nom_tuteur" value="<%out.print(request.getAttribute("nom_tuteur"));%>"/>
            Prénom Tuteur : <%out.print(request.getAttribute("prenom_tuteur"));%><br /><br />
            <input type="hidden" name="prenom_tuteur" value="<%out.print(request.getAttribute("prenom_tuteur"));%>"/>
            Profession Tuteur : <%out.print(request.getAttribute("profession_tuteur"));%><br /><br />
            <input type="hidden" name="profession_tuteur" value="<%out.print(request.getAttribute("profession_tuteur"));%>"/>
            Adresse Tuteur : <%out.print(request.getAttribute("adresse_tuteur"));%><br /><br />
            <input type="hidden" name="adresse_tuteur" value="<%out.print(request.getAttribute("adresse_tuteur"));%>"/>
            Téléphone Tuteur : <%out.print(request.getAttribute("tel_tuteur"));%><br /><br />
            <input type="hidden" name="tel_tuteur" value="<%out.print(request.getAttribute("tel_tuteur"));%>"/>
            Email Tuteur : <%out.print(request.getAttribute("mail_tuteur"));%><br /><br />
            <input type="hidden" name="mail_tuteur" value="<%out.print(request.getAttribute("mail_tuteur"));%>"/>
            Type Bac : <%out.print(request.getAttribute("type_bac"));%><br /><br />
            <input type="hidden" name="type_bac" value="<%out.print(request.getAttribute("type_bac"));%>"/>
            Série Bac : <%out.print(request.getAttribute("serie_bac"));%><br /><br />
            <input type="hidden" name="serie_bac" value="<%out.print(request.getAttribute("serie_bac"));%>"/>
            Mention Bac : <%out.print(request.getAttribute("mention_bac"));%><br /><br />
            <input type="hidden" name="mention_bac" value="<%out.print(request.getAttribute("mention_bac"));%>"/>
            Moyenne de l'examen régional : <%out.print(request.getAttribute("moy_ER"));%><br /><br />
            <input type="hidden" name="moy_ER" value="<%out.print(request.getAttribute("moy_ER"));%>"/>
            Moyenne de l'examen national : <%out.print(request.getAttribute("moy_EN"));%><br /><br />
            <input type="hidden" name="moy_EN" value="<%out.print(request.getAttribute("moy_EN"));%>"/>
            Note Math de l'examen National : <%out.print(request.getAttribute("math_EN"));%><br /><br />
            <input type="hidden" name="math_EN" value="<%out.print(request.getAttribute("math_EN"));%>"/>
            Note Physique de l'examen National : <%out.print(request.getAttribute("phys_EN"));%><br /><br />
            <input type="hidden" name="phys_EN" value="<%out.print(request.getAttribute("phys_EN"));%>"/>
            Note Sciences de la vie et de la terre de l'examen National : <%out.print(request.getAttribute("nat_EN"));%><br /><br />
            <input type="hidden" name="nat_EN" value="<%out.print(request.getAttribute("nat_EN"));%>"/>
            Lycée : <%out.print(request.getAttribute("lycee"));%><br /><br />
            <input type="hidden" name="lycee" value="<%out.print(request.getAttribute("lycee"));%>"/>
            Académie : <%out.print(request.getAttribute("academie"));%><br /><br />
            <input type="hidden" name="academie" value="<%out.print(request.getAttribute("academie"));%>"/>
            Province : <%out.print(request.getAttribute("province"));%><br /><br />
            <input type="hidden" name="province" value="<%out.print(request.getAttribute("province"));%>"/>
            Filière : <%out.print(request.getAttribute("filiere"));%><br /><br /><br />
            <input type="hidden" name="filiere" value="<%out.print(request.getAttribute("filiere"));%>"/>
            <input type="hidden" name="ninsc" value="<%out.print(request.getAttribute("ninsc"));%>"/>
            <input type='submit' name="validation" value='Validation Finale'/>
        </form>
    </body>
</html>
