<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>接受需求</title>
</head>
<body>
<style type="text/css">
    table.dataintable {
        margin-top:15px;
        border-collapse:collapse;
        border:1px solid #aaa;
        width:100%;
    }

    table.dataintable th {
        vertical-align:baseline;
        padding:5px 15px 5px 6px;
        background-color:#3F3F3F;
        border:1px solid #3F3F3F;
        text-align:left;
        color:#fff;
    }

    table.dataintable td {
        vertical-align:text-top;
        padding:6px 15px 6px 6px;
        border:1px solid #aaa;
    }

    table.dataintable tr:nth-child(odd) {
        background-color:#F5F5F5;
    }

    table.dataintable tr:nth-child(even) {
        background-color:#fff;
    }
</style>
<%--<form action ="ShowServlet" method="get">
    输入用户名：<input type="text" name="username"/>
    <input type="submit" value="查询" />
</form>--%>
&nbsp;
&nbsp;</div>
<table class="dataintable">
    <tr>
        <th>用户名</th>
        <th>电话号码</th>
        <th>地址</th>
    </tr>
    <%--<c:forEach var="user" items="${list}" >--%>
        <tr>
            <td><b>${user.getUsername()}</b></td>
            <td>${user.getTelephone()}</td>
            <td>${user.getAddress()}</td>
        </tr>
    <%--</c:forEach>--%>
</body>
</html>