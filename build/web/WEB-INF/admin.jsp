<%-- 
    Document   : admin
    Created on : 1 juin 2015, 00:35:57
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
        <h1>Connexion Administrateur</h1>
        <form method="post" action="AdminServlet">
            Login : <input type="text" name="login"/><br /><br />
            Mot de passe : <input type="text" name="mdp"/>
            <input type="submit" value="Se connecter" />
        </form>
        <% if(request.getAttribute("alerte")!=null) {
            out.println(request.getAttribute("alerte").toString()); }%></p>
            
    </body>
</html>
