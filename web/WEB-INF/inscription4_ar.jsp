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
        <form action="PDFServlet?n_inscription=<%=request.getAttribute("numins")%>" method="GET" >
            <h1>استمارة التسجيل- المرحلة الرابعة</h1>
            <h2> هنيئا لقد تم التسجيل بنجاح !</h2>
            <h3> يجب تحميل  PDF لتقديمه أثناء التسجيل النهائي في المعهد المطلوب . </h3>
            <input type="hidden" name="download" value="yes"/>
            <input type="hidden" name="n_inscription" value="<%=request.getAttribute("numins")%>" />
            <input type='submit' value="تحميل طلب التسجيل<"/>
        </form>
    </body>
</html>
