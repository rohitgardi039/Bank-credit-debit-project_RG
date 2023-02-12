package Banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import Banking.Dao.Bank_dbo;
import Banking.bo.credit_bo;
import Banking.bo.debit_bo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class debitcontroller
 */
@WebServlet("/debitcontroller")
public class debitcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public debitcontroller() {
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
		 String type=request.getParameter("type");
		 
		 
		 
		 
		
		 
		 
		 debit_bo rt=new debit_bo();
		 rt.setDate_time(date_time);
		 rt.setAmount(amount);
		 rt.setType(type);
		 
		 
		 int status=Bank_dbo.debit(rt);
		 Integer bal=10000;
		 
		
		 
		 if(status>0)			 
		 {
			 
			 if(type.equals("Credit"))
			 {
			
					
					pw.write("Ammount is successfully Credeted\n\n");
					int b=Integer.parseInt(amount);
					Integer c=bal+(Integer)b;
					
					pw.write("total balance = \n"+c);
					bal=c;
					
					
				}
				else if(type.equals("Debit")) {
					pw.write("Ammount is successfully Debited\n\n");
					int b=Integer.parseInt(amount);
					Integer c=bal-(Integer)b;
					
					pw.write("total balance = \n"+c);
					bal=c;
					
				}
			
		 }
		 else
		 {
			 pw.print("Anmount Not inserted");
		 }
	}



	}


