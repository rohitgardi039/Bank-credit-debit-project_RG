package Banking.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Banking.bo.credit_bo;
import Banking.bo.debit_bo;
import Banking.bo.login_bo;



public class Bank_dbo
{
	public static Connection getConnection()
	{
		Connection con=null;
		
		try
		{
			String url="jdbc:mysql://localhost:3306/account";
			String username="root";
			String password="rohit";
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection(url,username,password);
			
	         
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		return con;
	}
	public static boolean login(String account, String password)
	{
		
		boolean status=false;
		try
		{
			Connection con =Bank_dbo.getConnection();
			String sql="select * from login where account=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,account);
			ps.setString(2,password);
			
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} 
		catch (Exception e)
		{
			System.out.println(e);
			
		}
		return status;
	}
	public static int credit(credit_bo em)
	{
		int status=0;
		try
		{
			Connection con =Bank_dbo.getConnection();
			String Quary="insert into  credit( id,date_time,amount)values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(Quary);
			ps.setInt(1,em.getId());
			ps.setString(2,em.getDate_time());
			ps.setString(3,em.getAmount());
			
			
			
			
			status=ps.executeUpdate();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			
		}
		return status;
	}
	public static int debit(debit_bo em)
	{
		int status=0;
		try
		{
			Connection con =Bank_dbo.getConnection();
			String Quary="insert into debit( id,date_time,amount,type,bal)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(Quary);
			ps.setInt(1,em.getId());
			ps.setString(2,em.getDate_time());
			ps.setString(3,em.getAmount());
			ps.setString(4, em.getType());
			ps.setString(5, em.getBalance());
			
			status=ps.executeUpdate();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			
		}
		return status;
	}
	public static List veiw()
	{
		List<debit_bo> list=new ArrayList<debit_bo>();
	try {
		Connection con =Bank_dbo.getConnection();
		String sql="select id ,date_time,amount,type from debit";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			debit_bo eb=new debit_bo();
			eb.setId(rs.getInt(1));
			eb.setDate_time(rs.getString(2));
			eb.setAmount(rs.getString(3));
			eb.setType(rs.getString(4));
			
			list.add(eb);
			
		}
		
	}catch(Exception e)
	{
		
	}
		return list;
	}
	
	
}
	


