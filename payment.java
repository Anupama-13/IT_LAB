

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
 * Servlet implementation class payment
 */
@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String book=request.getParameter("bookslist");
		int qnt=Integer.parseInt(request.getParameter("qnty"));
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","anu2001");
			String s="select * from  books where title=?";
			PreparedStatement p=con.prepareStatement(s);
			p.setString(1, book);
			ResultSet r=p.executeQuery();
			boolean status=r.next();
			float cost=r.getFloat("cost");
			if(status)
			{
				float num=cost*qnt;
				
				pw.println("<h3> Total cost is : "+num +"</h3>");
				pw.println("<form method='post' action='order'>");
				pw.println("UserName : <input type='text' name='name'><br>");
				pw.println("Credit Card NUmber : <input type='text' name='ccnum'><br>");
				pw.println("<input type='submit'>");
			}	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
