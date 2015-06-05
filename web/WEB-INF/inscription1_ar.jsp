<%-- 
    Document   : inscription1
    Created on : 26 mai 2015, 13:37:53
    Author     : macbookpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ar" dir="rtl" xml:lang="ar">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <body>
        <h1>التسجيل- المرحلة الأولى</h1>
        <form action="InscriptionServlet" method="POST" enctype="multipart/form-data">
             رقم التسجيل :<input name="cne" value="<%out.println(request.getAttribute("cne"));%>"/><br /><br />
            المعهد المطلوب : <select name="etablissement" required>
                <option value="Faculte des sciences et techniques">كلية العلوم و التقنيات</option>
                <option value="Ecole nationale de commerce et de gestion">المدرسة الوطنية للتجارة و التسيير</option>
                <option value="Faculte des sciences juridiques economiques et sociales">كلية العلوم القانونية والاجتماعية والاقتصادية</option>
                <option value="Faculte polydisciplinaires">الكلية المتعددة التخصصات</option>
                <option value="Ecole nationale des sciences appliquees">المدرسة الوطنية للعلوم التطبيقية</option>
                <option value="Ecole superieure de technologie">المدرسة العليا للتكنولوجيا</option>
                <option value="Institut superieur des sciences de la sante">المعهد العالي للعلوم الصحية</option>
            </select><br /><br />
            الاسم العائلي : <input name="nom" value="<%out.println(request.getAttribute("nom"));%>" required/> <br /><br />
            الاسم الشخصي: <input name="prenom" value="<%out.println(request.getAttribute("prenom"));%>" required/> <br /><br />
            تاريخ الميلاد : <input name="date_naissance" type="date" required/> <br /><br />
            مدينة الإزدياد: <input name="ville_naissance" required/> <br /><br />
            مكان الإزدياد  : <input name="pays_naissance" required/> <br /><br />
            الجنسية : <input name="nationalite" required/> <br /><br />
            الجنس : <select name="sexe" required>
                      <option value="masculin">ذكر</option>
                      <option value="feminin">انثى</option>
                    </select> <br /><br />
            رقم البطاقة الوطنية : <input name="cin" required/> <br /><br />
            تاريخ  البطاقة الوطنية : <input name="date_cin" type="date" required/> <br /><br />
            العنوان : <textarea name="adresse" required></textarea> <br /><br />
            المدينة : <input name="ville" required/> <br /><br />
            البلد : <input name="pays" required/> <br /><br />
            الهاتف : <input name="tel" required/> <br /><br />
            البريد الإلكتروني : <input name="email" required/> <br /><br />
            الصورة : <input type="file" name="photo" required/> <br /><br />
            شخص ذو احتياجات خاصة ? : <select name="handicap" required>
                            <option value="1">نعم</option>
                            <option value="0">لا</option>
                        </select> <br /><br />
            طبيعة الإعاقة: <input name="nature_handicap"/> <br /><br />
            رقم بطاقة الإعاقة : <input name="num_carte_handicap"/> <br /><br />
            المنحة : <input name="bourse"  required/> <br /><br /><br />
            الأنشطة : <input name="activite"  required/> <br /><br /><br />
            <input type="hidden" name="lang" value="ar"/>
            <input type="submit" value="الخطوة التالية" />
        </form>
            
            
    </body>
</html>
