<%@page import="bean.BookBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<BookBean> bookBeanList = (List<BookBean>)request.getAttribute("bookList");
request.getAttribute("bookList");
%>
<table>
<%=request.getAttribute("msg") != null ? request.getAttribute("msg") :
""%>
<caption id="a"><h2>BookList<h2></caption>
<tr>
<th>BookID</th>
<th>BookName</th>
<th>Author</th>
<th>Price</th>
<th>Adding Date</th>
<th>Operation</th>
</tr>

<%
if (bookBeanList != null && bookBeanList.size() > 0){
	for (int i=0;i<bookBeanList.size();i++) {
	%>
	<tr>
	<td><%=i+1%></td>
	<td><%=bookBeanList.get(i).getBookName()%></td>
	<td><%=bookBeanList.get(i).getAuthor()%></td>
	<td><%=bookBeanList.get(i).getPrice() %></td>
	<td><%=bookBeanList.get(i).getAddingDate() %></td>
	<td><a href="DeleteBookServlet?id=<%=bookBeanList.get(i).getId()%>">delete</a></td>
	</tr>
	<%
}
} else {
%>
<tr>
<td colspan="6">can not get the book information</td>
</tr>
<%
}
%>
<br />
<form action="AddBook" method="post">
bookname: <input type="text" name="bookname"
value="<%=request.getAttribute("bookname") != null ?
request.getAttribute("bookname") : ""%>" />

<br /> 
author:<input type="text" name="author"
value="<%=request.getAttribute("author") != null ?
request.getAttribute("author") : ""%>" />

<br />	
price:<input type="text" name="price"
value="<%=request.getAttribute("price") != null ?
request.getAttribute("price") : ""%>" />

<br />
dateAdded:<input type = "text" name = "dateAdded"
value = "<%=request.getAttribute("dateAdded")!=null?
request.getAttribute("price"):""%>"
/>
<br />
<input type="submit" value="Add" />
</form>
</table>

</body>
</html>