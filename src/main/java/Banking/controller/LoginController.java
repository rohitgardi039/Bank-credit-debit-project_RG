package Banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import Banking.Dao.Bank_dbo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		String account=request.getParameter("account");				 
		 String password=request.getParameter("pass");
		 
		try {
			
		
		 if(Bank_dbo.login(account, password))
		 {
			
			 pw.print("succses");
			 RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			 rd.forward(request, response);
		 }
		 else
		 {
			 pw.print("worong");
			 RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			 rd.include(request, response);
		 }
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			
		} 
	}

}
