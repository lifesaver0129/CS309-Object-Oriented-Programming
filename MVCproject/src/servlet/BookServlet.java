package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import service.BookService;
import service.BookServicelmpl;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
BookService bookService=new BookServicelmpl();
List<BookBean> bookList=bookService.fetchBookList();
request.setAttribute("bookList", bookList);
request.getRequestDispatcher("BookList.jsp").forward(request,
response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
doGet(request, response);
}
}
