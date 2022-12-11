<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* 
const a = () => {
	let win = open("${pageContext.request.contextPath }/data/openwin.jsp", "win", "width=300,height=200");
}
 */
</script>
</head>
<body>
<c:if test="${sessionScope.loginId != vo.writer }">
<c:set var="str">readonly</c:set>
</c:if>
<h3>자료 상세페이지</h3>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/download/getall">목록으로</a><br/>
<form action="${pageContext.request.contextPath }/DispatcherServlet?url=/download/edit&num=${vo.num}" method="post" name="f">
<table border="1">
<tr><th>글번호</th><td><input type="text" name="writer" value="${vo.num }" readonly></td></tr>
<tr><th>작성자</th><td><input type="text" name="writer" value="${vo.writer }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title" value="${vo.title }" ${str }></td></tr>
<tr><th>내용</th><td><input type="text" name="content" value="${vo.content }" ${str}></td></tr>
<tr><th>자료</th><td><a href="${pageContext.request.contextPath }/DispatcherServlet?url=/download/down&fname=${vo.down_path }&num=${vo.num}">${vo.down_path }</a></td></tr>
<tr><th>자료 다운로드수</th>
<td>${vo.down_cnt }</td></tr>
<c:if test="${sessionScope.loginId == vo.writer }">
<tr><th>수정</th><td><input type="submit" value="수정">
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/download/del&num=${vo.num}"><input type="button" value="삭제"></a></td></tr>
</c:if>
</table>
<%-- <input type="hidden" name="down_path" value="${vo.down_path }"> --%>
</form>
</body>
</html>