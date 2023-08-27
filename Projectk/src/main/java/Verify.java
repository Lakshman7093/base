import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Verify")
public class Verify extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	 
    	 String url="jdbc:mysql://localhost:3306?user=root&password=12345";
    	 String query="select * from online.singup where email=? password=?";
    	 
    	 String email=req.getParameter("email");
    	 
    	 String password=req.getParameter("password");
    	try
    	{
    		 resp.setContentType("text/html");
   		  
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection =DriverManager.getConnection(url);
			
			PreparedStatement ps =connection.prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs =ps.executeQuery();
			 resp.setContentType("text/html");
		        PrintWriter out=resp.getWriter();
			if (rs.next())
			{
				
				out.println("login sucessfull");
			}
			else
			{
			
				out.println("login unsucessfull");
			}
		} 
    	catch (Exception e)
    	{
			
			e.printStackTrace();
		}
    	
    }
}
