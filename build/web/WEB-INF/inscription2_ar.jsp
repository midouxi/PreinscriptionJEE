<%-- 
    Document   : inscription1.jsp
    Created on : 22 mai 2015, 11:45:09
    Author     : macbookpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ar" dir="rtl" xml:lang="ar">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
        <h1><u1>استمارة التسجيل- المرحلة الثانية  </h1>
        
        <form action="InscriptionServlet" method="POST" enctype="multipart/form-data">
            الاسم العائلي للاب : <input name="nom_pere" required/> <br /><br />
            الاسم الشخصي للام : <input name="prenom_pere" required/> <br /><br />
            مهنة الأب : <input name="profession_pere" required/> <br /><br />
            الاسم العائلي للام : <input name="nom_mere" required/> <br /><br />
            الاسم الشخصي للام : <input name="prenom_mere" required/> <br /><br />
            مهنة الأم : <input name="profession_mere" required/> <br /><br />
            الاسم العائلي للواصي : <input name="nom_tuteur" required/> <br /><br />
            الاسم الشخصي للواصي : <input name="prenom_tuteur" required/> <br /><br />
            مهنة  الواصي  : <input name="profession_tuteur" required/> <br /><br />
            عنوان الواصي : <input name="adresse_tuteur" required/> <br /><br />
            هاتف الواصي : <input name="tel_tuteur" required/> <br /><br />
            البريد الإلكتروني للواصي : <input name="mail_tuteur" required/> <br /><br /><br />
            <input type="hidden" name="n_inscription" value="<%=request.getAttribute("numins")%>" />
            <input type="hidden" name="lang" value="ar"/>
            <input type="submit" value="الخطوة التالية"/>
        </form>
    </body>
</html>
