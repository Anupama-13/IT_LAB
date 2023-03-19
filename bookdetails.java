

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
 * Servlet implementation class bookdetails
 */
@WebServlet("/bookdetails")
public class bookdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String title=request.getParameter("title");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","anu2001");
			String s="select * from  books where title=?";
			PreparedStatement p=con.prepareStatement(s);
			p.setString(1, title);
			ResultSet r=p.executeQuery();
			boolean status=r.next();
			if(status)
			{
					String title1=r.getString("title");
					String author=r.getString("author");
					float version=r.getFloat("version");
					String pub=r.getString("publisher");
					float cost=r.getFloat("cost");
					
					pw.println("<div align='center'>");
					pw.println("<h3>TITLE : "+ title1 +"</h3><br>");
					pw.println("<h3> AUTHOR : "+ author +"</h3><br>");
					pw.println("<h3> VERSION : "+ version +"</h3><br>");
					pw.println("<h3> PUBLISHER : "+ pub +"</h3><br>");
					pw.println("<h3> COST : "+ cost +"</h3><br>");
					pw.println("</div>");
				
			}
			else
			{
				pw.println("<h2>We don't have any book with that title..please retry for another book</h2><br>");
				pw.println("<a href='books.html'>RETRY</a>");	
			}
			}
		catch (Exception e)
		{
			pw.println("We don't book with that title..please retry for another book<br>");
			pw.println("<a href='books.html'>RETRY</a>");
		}
	}

}
