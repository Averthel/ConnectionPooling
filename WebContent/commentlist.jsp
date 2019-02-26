<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, pl.ave.jdbc.data.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Komentarze</h2>
    <table style="width:50%" border="1">
        <tr>
            <th>Użytkownik: </th>
            <th>Treść: </th>
        </tr>
        <%
            List<User> komentarze = (List<User>)request.getAttribute("komentarze");
            if(komentarze != null)
                for(User kom: komentarze){
        %>
            <tr>
                <td><%=kom.getUsername()%></td>
                <td><%=kom.getComment()%></td>
            </tr>
        <%
                }
        %>



    </table>


</body>
</html>
