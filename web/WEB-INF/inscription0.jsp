<%-- 
    Document   : inscription0
    Created on : 31 mai 2015, 14:09:14
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
        <h1>Inscription á l'université Hassan 1st!</h1>
        <form method="POST" action="InscriptionServlet"/>
            CNE : <input type="text" name="cne" />: ر.و.ت <br /><br /><br />
            <input type="submit" name="action1" value="Formulaire en Français" />
            <input type="submit" name="action2" value="استمارة باللغة العربية" />
        </form>
    </body>
</html>
