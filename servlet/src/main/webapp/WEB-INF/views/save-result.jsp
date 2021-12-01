<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ page import="hello.servlet.domain.member.Member" %>  --%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
<%-- getAttribute 사용법 -> 복잡하므로 아래와 같은 jsp ${} 문법을 사용하여 attribute에 담긴 데이터를 조회한다. --%>
<%--
      <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
      <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
      <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
--%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>