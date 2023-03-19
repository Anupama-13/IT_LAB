

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

/**
 * Servlet implementation class order
 */
@WebServlet("/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String ccno=request.getParameter("ccnum");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","anu2001");
			String s="select * from  card_details where user_name=?";
			PreparedStatement p=con.prepareStatement(s);
			p.setString(1, name);
			ResultSet r=p.executeQuery();
			boolean status=r.next();
			String ccnum=r.getString("cc_num");
			if(status)
			{
				if(ccno.equals(ccnum))
				{
					pw.println("<h2><b>Your Order is confirmed</b></h2><br><br>");
					pw.println("<h2><b> Thank YOU </h2></b>");
				}
				else
				{
					pw.println("Your card  details are wrong please try again");
					pw.println("<a href='payment.java'>RETRY</a>");
				}
			}
			else
			{
				pw.println("Your details are wrong please try again<br>");
				pw.println("<a href='shopping.html'>RETRY</a>");
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
