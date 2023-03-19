

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String uname =request.getParameter("usrnm");
		String pwd=request.getParameter("pwd");
		String phno=request.getParameter("phno");
		String addr=request.getParameter("address");
		
		pw.print("<html><head><title>Storing into database</title></head><body style='text-align:center;'>");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","anu2001");
			String s="insert into Register values(?,?,?,?,?,?)";
			PreparedStatement p=con.prepareStatement(s);
			p.setString(1, name);
			p.setString(2, email);
			p.setString(3, uname);
			p.setString(4, pwd);
			p.setString(5, phno);
			p.setString(6, addr);
			int i=p.executeUpdate();
			if(i>0)
			{
				pw.println("<h1>Congrtas you registered successfully</h1>");
			}
			else
			{
				pw.println("<h1> Something wrong happened please try agin </h1>");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		pw.print("</body></html>");
	}

}
