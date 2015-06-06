<%-- 
    Document   : adminsearch0
    Created on : 6 juin 2015, 15:41:18
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
        <% if(request.getAttribute("alerte")==null) {%> 
        <h1>Etudiant Trouvé</h1>
        CNE : <%out.print(request.getAttribute("cne"));%><br /><br />
        Établissement souhaité : <%out.print(request.getAttribute("etablissement"));%><br /><br />
        Nom : <%out.print(request.getAttribute("nom"));%><br /><br />
        Prénom : <%out.print(request.getAttribute("prenom"));%><br /><br />
        Date de Naissance : <%out.print(request.getAttribute("date_naissance"));%><br /><br />
        Ville de Naissance : <%out.print(request.getAttribute("ville_naissance"));%><br /><br />
        Pays de Naissance : <%out.print(request.getAttribute("pays_naissance"));%><br /><br />
        Nationalité : <%out.print(request.getAttribute("nationalite"));%><br /><br />
        Sexe : <%out.print(request.getAttribute("sexe"));%><br /><br />
        CIN : <%out.print(request.getAttribute("cin"));%><br /><br />
        Date de CIN : <%out.print(request.getAttribute("datecin"));%><br /><br />
        Adresse : <%out.print(request.getAttribute("adresse"));%><br /><br />
        Ville : <%out.print(request.getAttribute("ville"));%><br /><br />
        Pays : <%out.print(request.getAttribute("pays"));%><br /><br />
        Téléphone : <%out.print(request.getAttribute("tel"));%><br /><br />
        Email : <%out.print(request.getAttribute("email"));%><br /><br />
        Photo : <%out.print(request.getAttribute("photo"));%><br /><br />
        Handicapé ? : <%out.print(request.getAttribute("handicap"));%><br /><br />
        Nature de l'handicap : <%out.print(request.getAttribute("nature_handicap"));%> <br /><br />
        Num de la carte de l'handicap : <%out.print(request.getAttribute("num_carte_handicap"));%><br /><br />
        Bourse : <%out.print(request.getAttribute("bourse"));%><br /><br />
        Activité : <%out.print(request.getAttribute("activite"));%><br /><br />
        Nom du père : <%out.print(request.getAttribute("nom_pere"));%><br /><br />
        Prénom du Père : <%out.print(request.getAttribute("prenom_pere"));%><br /><br />
        Profession du Père : <%out.print(request.getAttribute("profession_pere"));%><br /><br />
        Nom de la mère : <%out.print(request.getAttribute("nom_mere"));%><br /><br />
        Prénom de la mère : <%out.print(request.getAttribute("prenom_mere"));%><br /><br />
        Profession de la mère : <%out.print(request.getAttribute("profession_mere"));%><br /><br />
        Nom Tuteur : <%out.print(request.getAttribute("nom_tuteur"));%><br /><br />
        Prénom Tuteur : <%out.print(request.getAttribute("prenom_tuteur"));%><br /><br />
        Profession Tuteur : <%out.print(request.getAttribute("profession_tuteur"));%><br /><br />
        Adresse Tuteur : <%out.print(request.getAttribute("adresse_tuteur"));%><br /><br />
        Téléphone Tuteur : <%out.print(request.getAttribute("tel_tuteur"));%><br /><br />
        Email Tuteur : <%out.print(request.getAttribute("mail_tuteur"));%><br /><br />
        Type Bac : <%out.print(request.getAttribute("type_bac"));%><br /><br />
        Série Bac : <%out.print(request.getAttribute("serie_bac"));%><br /><br />
        Mention Bac : <%out.print(request.getAttribute("mention_bac"));%><br /><br />
        Moyenne de l'examen régional : <%out.print(request.getAttribute("moy_ER"));%><br /><br />
        Moyenne de l'examen national : <%out.print(request.getAttribute("moy_EN"));%><br /><br />
        Note Math de l'examen National : <%out.print(request.getAttribute("math_EN"));%><br /><br />
        Note Physique de l'examen National : <%out.print(request.getAttribute("phys_EN"));%><br /><br />
        Note Sciences de la vie et de la terre de l'examen National : <%out.print(request.getAttribute("nat_EN"));%><br /><br />
        Lycée : <%out.print(request.getAttribute("lycee"));%><br /><br />
        Académie : <%out.print(request.getAttribute("academie"));%><br /><br />
        Province : <%out.print(request.getAttribute("province"));%><br /><br />
        Filière : <%out.print(request.getAttribute("filiere"));%><br /><br /><br />
        <% } else { 
            out.println(request.getAttribute("alerte"));
        } %><br /><br />
        <a href ="AdminServlet">Retour à la page d'administrateur</a>
    </body>
</html>
