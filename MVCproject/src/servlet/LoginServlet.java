package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserinfoService;
import service.UserinfoServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String	username=request.getParameter("username");
		String	password=request.getParameter("password");
		if((username==null||username.equals(""))&&(password==null||password.equals(""))
				){
				request.setAttribute("msg_username","user name shouldn't be	none");
				request.setAttribute("msg_password","password shouldn't	be	none");
				request.getRequestDispatcher("Login.jsp").forward(request,	response);
				}else if(password==null||password.equals("")){
				request.setAttribute("username",	username);
				request.setAttribute("msg_password","password	shouldn't	be	none");
				request.getRequestDispatcher("Login.jsp").forward(request,	response);
				}else if(username==null||username.equals("")){
				request.setAttribute("password",	password);
				request.setAttribute("msg_username","user	name	shouldn't	be	none");
				request.getRequestDispatcher("Login.jsp").forward(request,	response);
				}
				else{
				System.out.println("success");
				UserinfoService	userinfoservice=new UserinfoServiceImpl();
				int result=userinfoservice.login (username,password);
				if(result==1){
				System.out.println("visiting	database	successfully");
				request.getRequestDispatcher("BookServlet").forward(request,response);
				}else{
				System.out.println("failing	to	visit	database");
				request.setAttribute("msg",	"the	username	or	password	is	wrong");
				request.getRequestDispatcher("Login.jsp").forward(request,	response);
				}
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
