<%-- 
    Document   : inscription1.jsp
    Created on : 22 mai 2015, 11:45:09
    Author     : macbookpro
--%>
<%String cne=(String)request.getSession().getAttribute("cne");

if(cne == null){
    out.println("aucune session trouvé !");
    response.sendRedirect("InscriptionServlet");
}

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="PDFServlet?n_inscription=<%=request.getAttribute("numins")%>" method="GET" >
            <h1>Préinscription-Étape 4!</h1>
            <h2> Félicitation l'inscription est faite !</h2>
            <h3> Vous devez télécharger votre pdf pour le présenter durant votre inscription finale dans l'institut</h3>
            <input type="hidden" name="download" value="yes"/>
            <input type="hidden" name="n_inscription" value="<%=request.getAttribute("numins")%>" />
            <input type='submit' value="Download"/>
        </form>
    </body>
</html>
