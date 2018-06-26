package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserinfoBean;
import service.UserinfoService;
import service.UserinfoServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String username="";
		String password="";
		String conPassword="";
		username=request.getParameter("username");
		password=request.getParameter("password");
		conPassword=request.getParameter("con_password");
		if((username==null||username.equals(""))&&(password==null||password.equals(""))
		){
		request.setAttribute("msg_username", "user name shouldn't be none");
		request.setAttribute("msg_password", "password shouldn't be none");
		request.getRequestDispatcher("Register.jsp").forward(request,
		response);
		}else if(username==null||username.equals("")){
		request.setAttribute("password", password);
		request.setAttribute("msg_username", "user name shouldn't be none");
		request.getRequestDispatcher("Register.jsp").forward(request,
		response);
		}else if(password==null||password.equals("")){
		request.setAttribute("username", username);
		request.setAttribute("msg_password", "password shouldn't be none");
		request.getRequestDispatcher("Register.jsp").forward(request,
		response);
		}else{
		if(conPassword==""||conPassword.equals("")){
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("msg_con_password", "Please confirm password");
		request.getRequestDispatcher("Register.jsp").forward(request,
		response);
		}else{
			if(!conPassword.equals(password)){
				request.setAttribute("password", password);
				request.setAttribute("username", username);
				request.setAttribute("msg_con_password", "Two password is not same");
				request.setAttribute("con_password", "");
				request.getRequestDispatcher("Register.jsp").forward(request,
				response);
				}
			else{
				System.out.println("Success");
				UserinfoService userinfoService=new UserinfoServiceImpl();
				UserinfoBean userinfoBean=new UserinfoBean();
				userinfoBean.setUsername(username);
				userinfoBean.setPassword(password);
				int result=userinfoService.registerUserinfo(userinfoBean);
				System.out.println("In servlet"+result);
				if(result==1){
				request.setAttribute("msg", "Register is success, please login to the system");
				request.setAttribute("username", username);
				request.getRequestDispatcher("Login.jsp").forward(request,
				response);
				}else{
				request.setAttribute("msg", "Register is failed");
				request.getRequestDispatcher("Register.jsp").forward(request,
				response);

				}
				}
		}}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
