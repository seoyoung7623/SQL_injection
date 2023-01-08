<%@ page import="java.util.List" %>
<%@ page import="edu.catholic.model.Account" %><%--
  Created by IntelliJ IDEA.
  User: nicek
  Date: 2022-10-26
  Time: 오후 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Data</title>
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
</body>
</html>
