<%--
  Created by IntelliJ IDEA.
  User: nataese
  Date: 2017-12-18
  Time: 오전 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>로그인페이지</h1>
    <div>
        <form action="/login" method="post">
            <tr>
                <td>로그인</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>비번</td>
                <td><input type="password" name="passwrod"/></td>
            </tr>
            <input type="submit" name="submit" value="로그인"/>
        </form>

    </div>
</body>
</html>
