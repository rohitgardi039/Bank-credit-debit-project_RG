package Banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import Banking.Dao.Bank_dbo;
import Banking.bo.credit_bo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreditController
 */
@WebServlet("/CreditController")
public class CreditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreditController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		 String date_time=request.getParameter("date_time");		
		 String amount=request.getParameter("amount");
		 
		 
		 
		
		 
		 
		 credit_bo rt=new credit_bo();
		 rt.setDate_time(date_time);
		 rt.setAmount(amount);
		 
		 int status=Bank_dbo.credit(rt);
		 
		
		 
		 if(status>0)
		 {
			 
			 System.out.println("Created Succesfully");
			 pw.print(date_time+amount);
			//RequestDispatcher rd=request.getRequestDispatcher("Allownwe");
			//rd.forward(request, response);
		 }
		 else
		 {
			 pw.print("data not added");
		 }
	}

}
