<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
	<title>방명록 메시지 삭제 확인</title>
</head>
<body>

<form action="deleteMember" method="post">
<input type="hidden" name="memberId" value="${param.memberId }" />
메시지를 삭제하시려면 암호를 입력하세요:<br/>
관리자암호: <input type="password" name="password" /> <br />
<input type="submit" value="메시지 삭제하기" />
</form>
</body>
</html>