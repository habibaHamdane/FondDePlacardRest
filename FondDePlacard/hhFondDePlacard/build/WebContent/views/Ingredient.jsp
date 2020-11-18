<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fond de placard</title>
</head>
<body>
 <form action="/controller" method="post">
 Mot Cle:<input type="text" name="motCle" value="${modele.motCle}">
 <input type="submit" value="OK">
 </form>
 <table border="1" >
   <tr>
     <th>ID</th>
     <th>Name</th>
   </tr>
   <c:forEach items="${modele.ingredients}" var="i">
     <tr>
      <td>${i.idIngredient}</td> 
      <td>${i.name}</td>
     </tr>
   </c:forEach>
 </table>

</body>
</html> --%>