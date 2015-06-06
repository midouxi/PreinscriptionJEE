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
        <h1>Modification - Etape 3</h1>
        <form action="AdminModifServlet" method="GET" enctype="multipart/form-data">
            Type Bac : <input name="type_bac" value="<%out.print(request.getAttribute("type_bac"));%>" required/> <br /><br />
            Série Bac : <input name="serie_bac" value="<%out.print(request.getAttribute("serie_bac"));%>" required/> <br /><br />
            Mention Bac : <input name="mention_bac" value="<%out.print(request.getAttribute("mention_bac"));%>" required/> <br /><br />
            Moyenne de l'examen régional : <input name="moy_ER" value="<%out.print(request.getAttribute("moy_ER"));%>" required/> <br /><br />
            Moyenne de l'examen national : <input name="moy_EN" value="<%out.print(request.getAttribute("moy_EN"));%>" required/> <br /><br />
            Note Math de l'examen National : <input name="math_EN" value="<%out.print(request.getAttribute("math_EN"));%>" required/> <br /><br />
            Note Physique de l'examen National : <input name="phys_EN" value="<%out.print(request.getAttribute("phys_EN"));%>" required/> <br /><br />
            Note Sciences de la vie et de la terre de l'examen National : <input name="nat_EN" value="<%out.print(request.getAttribute("nat_EN"));%>" required/> <br /><br />
            Lycée : <input name="lycee" value="<%out.print(request.getAttribute("lycee"));%>" required/> <br /><br />
            Académie : <input name="academie" value="<%out.print(request.getAttribute("academie"));%>" required/> <br /><br />
            Province : <input name="province" value="<%out.print(request.getAttribute("province"));%>" required/> <br /><br />
            Filière : <input name="filiere" value="<%out.print(request.getAttribute("filiere"));%>" required/> <br /><br />
            <input type="hidden" name="ninsc" value="<%out.print(request.getAttribute("ninsc"));%>"/>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
