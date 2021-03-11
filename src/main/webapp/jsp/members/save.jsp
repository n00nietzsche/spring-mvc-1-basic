<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // request, response 는 `jsp` 가 결국 `servlet`으로 변환되어 사용되기 때문에 그냥 사용 가능
    // 사실은 이전에 `servlet`에서 작성했던 것 처럼 `service`가 그대로 호출된다고 보아도 됨
    MemberRepository memberRepository = MemberRepository.getInstance();

    String userName = request.getParameter("userName");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(userName, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>userName=<%=member.getUserName()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>

<a href="/index.html">메인</a>

</body>
</html>
