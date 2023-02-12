package Banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Banking.Dao.Bank_dbo;
import Banking.bo.debit_bo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViweController
 */
@WebServlet("/ViweController")
public class ViweController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViweController()
    {
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
		pw.print("<table border ='2px' width='100%' border-collapse='collapse'>");
		pw.print("<tr> <th> ID </th><th> Date Time </th><th> Type </th> <th> Amount </th></tr>");
		
		List<debit_bo> list =Bank_dbo.veiw();
		for(debit_bo eb:list)
		{
			pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getDate_time()+"</td><td>"+eb.getType()+"</td><td>"+eb.getAmount()+"</td></tr>");
		}
		pw.print("</table>");
		pw.print("<a href='Home.html'>Home </a>");
		
			
	}
}