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
<html lang="ar" dir="rtl" xml:lang="ar">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>استمارة التسجيل- المرحلة الثالثة</h1>
        <form action="InscriptionServlet" method="POST" enctype="multipart/form-data">
            نوع الباكالوريا  : <input name="type_bac" required/> <br /><br />
            شعبة الباكالوريا : <input name="serie_bac" required/> <br /><br />
            ميزة الباكالوريا : <input name="mention_bac" required/> <br /><br />
            المعدل الجهوي : <input name="moy_ER" required/> <br /><br />
            المعدل الوطني : <input name="moy_EN" required/> <br /><br />
            معدل الرياضيات في الامتحان الوطني : <input name="math_EN" required/> <br /><br />
            معدل الفيزياء في الامتحان الوطني : <input name="phys_EN" required/> <br /><br />
            معدل الحياة و الارض في في الامتحان الوطني : <input name="nat_EN" required/> <br /><br />
            الثانوية التأهيلية : <input name="lycee" required/> <br /><br />
            أكاديمية : <input name="academie" required/> <br /><br />
            الإقليم : <input name="province" required/> <br /><br />
            الشعبة : <input name="filiere" required/> <br /><br />
            <input type="hidden" name="n_inscription" value="<%=request.getAttribute("numins")%>" />
            <input type="hidden" name="lang" value="ar"/>
            <input type="submit" value="الخطوة التالية"/>
        </form>
            
    </body>
</html>
