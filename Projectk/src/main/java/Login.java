import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet
{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
     {
    	   String url="jdbc:mysql://localhost:3306?user=root&password=12345";
  		 
    	   String query="insert into online.singup values(?,?)";
    	  String email= req.getParameter("email");
    	  
    	  String password=req.getParameter("password");
    	  
    	  
    	  try
    	  {
    		  resp.setContentType("text/html");
    		  
    	 	Class.forName("com.mysql.jdbc.Driver");
    	 	
    	 	Connection connection =DriverManager.getConnection(url);
    	 	
    	 	PreparedStatement ps = connection.prepareStatement(query);
    	 	
    	 	ps.setString(1, email);
    	 	ps.setString(2, password);
    	 	
    	 	ps.execute();
    	 	
    	 	PrintWriter out=resp.getWriter();
    	 	
    	 	out.println("singup sucessfully");
    	 	
    	  } 
    	  
    	  catch (Exception e)
    	  {
    		
    		e.printStackTrace();
    	  }
    	  


    	
    }
}
