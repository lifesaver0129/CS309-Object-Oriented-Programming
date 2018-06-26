package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.UserinfoBean;
import service.BookService;
import service.BookServicelmpl;
import service.UserinfoService;
import service.UserinfoServiceImpl;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookname = "";
		String author = "";
		double price = 0;
		String dateAdded = "";
		
		bookname = request.getParameter("bookname");
		author = request.getParameter("author");
		price = Double.valueOf(request.getParameter("price")).doubleValue();
		dateAdded = request.getParameter("dateAdded");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Success");
		BookService bookService=new BookServicelmpl();
		BookBean bookBean=new BookBean();
		bookBean.setBookName(bookname);
		bookBean.setAuthor(author);
		bookBean.setPrice(price);
		bookBean.setAddingDate(dateAdded);
		int result=bookService.AddBookinfo(bookBean);
		System.out.println("In servlet"+result);
		if(result==1){
			request.setAttribute("msg", "Add book is success!");
			request.setAttribute("bookname", bookname);
			request.setAttribute("author", author);
			request.setAttribute("price", price);
			request.setAttribute("dateAdded", dateAdded);
			request.getRequestDispatcher("BookServlet").forward(request,
			response);
			}else{
			request.setAttribute("msg", "Add book is failed");
			request.getRequestDispatcher("BookServlet").forward(request,
		response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
