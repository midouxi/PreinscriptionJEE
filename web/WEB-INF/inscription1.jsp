<%-- 
    Document   : inscription1
    Created on : 26 mai 2015, 13:37:53
    Author     : macbookpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <body>
        <h1>Inscription</h1>
        <form action="InscriptionServlet" method="POST" enctype="multipart/form-data">
            CNE : <input name="cne" value="<%out.println(request.getAttribute("cne"));%>" required/> <br /><br />
            Établissement souhaité : 
            <select name="etablissement" required>
                <option value="">--Choisir--</option>
                <option value="Faculte des sciences et techniques">Faculté des sciences et techniques</option>
                <option value="Ecole nationale de commerce et de gestion">Ecole nationale de commerce et de gestion</option>
                <option value="Faculte des sciences juridiques economiques et sociales">Faculté des sciences juridiques économiques et sociales</option>
                <option value="Faculte polydisciplinaires">Faculté polydisciplinaires</option>
                <option value="Ecole nationale des sciences appliquees">Ecole nationale des sciences appliquées</option>
                <option value="Ecole superieure de technologie">Ecole supérieure de technologie</option>
                <option value="Institut superieur des sciences de la sante">Institut supérieur des sciences de la santé</option>
            </select><br /><br />
            Nom : <input name="nom" value="<%out.println(request.getAttribute("nom"));%>" required/> <br /><br />
            Prénom : <input name="prenom" value="<%out.println(request.getAttribute("prenom"));%>" required/> <br /><br />
            Date de Naissance : <input name="date_naissance" type="date" required/> <br /><br />
            Ville de Naissance : <input name="ville_naissance" required/> <br /><br />
            Pays de Naissance : <input name="pays_naissance" required/> <br /><br />
            Nationalité : <input name="nationalite" required/> <br /><br />
            Sexe : <select name="sexe" required>
                      <option value="masculin">Masculin</option>
                      <option value="feminin">Féminin</option>
                    </select> <br /><br />
            CIN : <input name="cin" required/> <br /><br />
            Date de CIN : <input name="date_cin" type="date" required/> <br /><br />
            Adresse : <textarea name="adresse" required></textarea> <br /><br />
            Ville : <input name="ville" required/> <br /><br />
            Pays : <input name="pays" required/> <br /><br />
            Téléphone : <input name="tel" required/> <br /><br />
            Email : <input name="email" required/> <br /><br />
            Photo : <input type="file" name="photo" required/> <br /><br />
            Handicapé ? : <select name="handicap" required>
                            <option value="1">Oui</option>
                            <option value="0">Non</option>
                        </select> <br /><br />
            Nature de l'handicap : <input name="nature_handicap"/> <br /><br />
            Num de la carte de l'handicap : <input name="num_carte_handicap"/> <br /><br />
            Bourse : <input name="bourse"  required/> <br /><br /><br />
            Activité : <input name="activite"  required/> <br /><br /><br />
            <input type="hidden" name="lang" value="fr"/>
            <input type="submit" value="Envoyer" />
        </form>      
    </body>
</html>
