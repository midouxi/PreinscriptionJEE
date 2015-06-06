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
        <h1>Chercher Etudiant</h1>
        <form action="AdminSearchServlet" method="GET"/>
            N˚Inscription : <input type="text" name="ninsc" required/><br /><br />
            <input type="submit" name="search" value="Chercher"/>
        </form>
    </body>
</html>
