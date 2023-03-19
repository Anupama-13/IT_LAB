

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","anu2001");
			String s="select * from  Register where user_name=? and password=?";
			PreparedStatement p=con.prepareStatement(s);
			p.setString(1, id);
			p.setString(2, pwd);
			ResultSet r=p.executeQuery();
			boolean status=r.next();
			String userid=r.getString("user_name");
			String pwd1=r.getString("password");
			if(status)
			{
				if(id.equals(userid)&& pwd.equals(pwd1))
				{
					pw.println("<h2><b>Your details are verified.click to continue to home page</b></h2><br><br>");
					pw.println("<a href='home.html'>HOME</a>");
				}
			}	
		}
		catch (Exception e)
		{
			pw.println("Your details are wrong please try again");
			pw.println("<a href='login.html'>RETRY</a>");
		}
	}

}
