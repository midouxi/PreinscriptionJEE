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
        <h1>Modification</h1>
        <div>
            <div>
                <div>
                    <ul>
                        <li><a href="adminpage.php">Inscription</a></li>
                        <li><a href="adminpage2.php">Inscription final</a></li>
                        <li><a href="logoutadmin.php" >Chercher Etudiant </a></li>
                        <li><a href="logoutadmin.php" >Ajout Etudiant</a></li>
                        <li><a href="logoutadmin.php" >Statistique</a></li>
                        <li><a href="logoutadmin.php" >Déconnexion</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <form action="AdminModifServlet" method="GET" enctype="multipart/form-data">
            CNE : <input name="cne" value="<%out.print(request.getAttribute("cne"));%>" required/> <br /><br />
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
            Nom : <input name="nom" value="<%out.print(request.getAttribute("nom"));%>" required/> <br /><br />
            Prénom : <input name="prenom" value="<%out.print(request.getAttribute("prenom"));%>" required/> <br /><br />
            Date de Naissance : <input name="date_naissance" type="date" value="<%out.print(request.getAttribute("date_naissance"));%>" required/> <br /><br />
            Ville de Naissance : <input name="ville_naissance" value="<%out.print(request.getAttribute("ville_naissance"));%>" required/> <br /><br />
            Pays de Naissance : <input name="pays_naissance" value="<%out.print(request.getAttribute("pays_naissance"));%>" required/> <br /><br />
            Nationalité : <input name="nationalite" value="<%out.print(request.getAttribute("nationalite"));%>" required/> <br /><br />
            Sexe : <select name="sexe" required>
                      <option value="masculin">Masculin</option>
                      <option value="feminin">Féminin</option>
                    </select> <br /><br />
            CIN : <input name="cin" value="<%out.print(request.getAttribute("cin"));%>" required/> <br /><br />
            Date de CIN : <input name="datecin" type="date" value="<%out.print(request.getAttribute("datecin"));%>" required/> <br /><br />
            Adresse : <textarea name="adresse" required><%out.print(request.getAttribute("adresse"));%></textarea> <br /><br />
            Ville : <input name="ville" value="<%out.print(request.getAttribute("ville"));%>" required/> <br /><br />
            Pays : <input name="pays" value="<%out.print(request.getAttribute("pays"));%>" required/> <br /><br />
            Téléphone : <input name="tel" value="<%out.print(request.getAttribute("tel"));%>" required/> <br /><br />
            Email : <input name="email" value="<%out.print(request.getAttribute("email"));%>" required/> <br /><br />
            Photo : <input type="file" value="<%out.print(request.getAttribute("photo"));%>" name="photo" required/> <br /><br />
            Handicapé ? : <select name="handicap" required>
                            <option value="1">Oui</option>
                            <option value="0">Non</option>
                        </select> <br /><br />
            Nature de l'handicap : <input name="nature_handicap" value="<%out.print(request.getAttribute("nature_handicap"));%>"/> <br /><br />
            Num de la carte de l'handicap : <input name="num_carte_handicap" value="<%out.print(request.getAttribute("num_carte_handicap"));%>"/> <br /><br />
            Bourse : <input name="bourse"  value="<%out.print(request.getAttribute("bourse"));%>" required/> <br /><br /><br />
            Activité : <input name="activite"  value="<%out.print(request.getAttribute("activite"));%>" required/> <br /><br /><br />
            <input type="hidden" name="ninsc" value="<%out.print(request.getAttribute("ninsc"));%>"/>
            <input type="submit" value="Envoyer" />
        </form> 
    </body>
</html>
