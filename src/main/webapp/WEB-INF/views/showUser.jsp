<%@ page import="edu.catholic.model.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello, World!</title>
    <style>
        table, th, td{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<% List<Account> accountList = (List<Account>) request.getAttribute("accountList"); %>
<table>
    <tr>
        <th scope="col">
            ID
        </th>
        <th scope="col">
            PASSWORD
        </th>
    </tr>
    <%
        for(int i=0; i<accountList.size(); i++){
    %>
    <tr>
        <td>
            <%=accountList.get(i).getId()%>
        </td>
        <td>
            <%=accountList.get(i).getPassword()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%--    <h3>ID: ${id}</h3>--%>
<%--    <h3>PASSWORD: ${password}</h3>--%>
<%--    <br/>--%>
</body>
</html>