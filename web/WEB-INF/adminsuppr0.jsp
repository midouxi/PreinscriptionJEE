<%-- 
    Document   : adminsuppr
    Created on : 6 juin 2015, 02:36:03
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
        <h1>Suppression</h1>
        <form action="AdminSupprServlet" method="get">
            Motif : <br /><br />
            <textarea name="motif" required/></textarea><br /><br />
            <input type="hidden" name="ninsc" value="<%out.print(request.getAttribute("ninsc"));%>"/>
            <input type='submit' value='Valider'/>
        </form>
    </body>
</html>
