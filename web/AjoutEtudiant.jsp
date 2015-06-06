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
                        <li><a href="logoutadmin.php" >Chercher Etudiant </a></li>
                        <li><a href="logoutadmin.php" >Ajout Etudiant</a></li>
                        <li><a href="logoutadmin.php" >Statistique</a></li>
                        <li><a href="logoutadmin.php" >Déconnexion</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div lang="ar" dir="rtl" xml:lang="ar">
         <form methde="GET" action="ServletAjouterEtudiant">
                <center>
                <table>
                    <tr><td></td><td></td><td><input type="text" name="cne"/></td><td>cne</td></tr>
                    <tr><td>الاسم </td><td><input type="text" name="prenom_ar"/></td><td><input type="text" name="prenom"/><td>Prenom</td></tr>
                    <tr><td>النسب </td><td><input type="text" name="nom_ar"/></td><td><input type="text" name="nom"/></td><td>Nom</td></tr>
                    <tr><td>نوع الباكالوريا</td><td><input type="text" name="type_bac_ar"/></td><td><input type="text" name="type_bac"/></td><td>type_bac</td></tr>
                    <tr><td>شعبة الباكالوريا</td><td><input type="text" name="serie_bac_ar"/></td><td><input type="text" name="serie_bac"/></td><td>serie_bac</td></tr>
                    <tr><td>ميزة الباكالوريا</td><td><input type="text" name="mention_bac_ar"/></td><td><input type="text" name="mention_bac"/></td><td>mention_bac</td></tr>
                    <tr><td>الثانوية </td><td><input type="text" name="lycee_ar"/></td><td><input type="text" name="lycee"/></td><td>lycee</td></tr>
                    <tr><td>أكاديمية </td><td><input type="text" name="academie_ar"/></td></td><td><input type="text" name="academie"/></td><td>academie</td></tr>
               </table>
                    <center><input type="submit" name="ajouter" value="ajouter l'Etudiant"/></center>
                    <center>
            </form>
        </div>
    </body>
</html>
