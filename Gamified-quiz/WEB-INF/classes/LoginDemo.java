import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LoginDemo extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
{
	String s1=request.getParameter("u1");
	String s2=request.getParameter("u2");
PrintWriter out=response.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\" />");
out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css\" />");
out.println("<link href=\"css/style.css\" rel=\"stylesheet\" />");
out.println("<link href=\"css/responsive.css\" rel=\"stylesheet\" />");
out.println(" <title>Gamified Website</title>");
out.println("<meta name=\"keywords\" content=\"\" />");
out.println("<meta name=\"description\" content=\"\" />");
out.println("<meta name=\"author\" content=\"\" />");
out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />");
out.println("</head>");
out.println("<body>");
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql:///quiz","root","piemr");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from regis where UNAME='"+s1+"' and UPASS='"+s2+"'");
	if(rs.next())
	{
	 response.sendRedirect("menudemo.html");
	}
	else{
     response.sendRedirect("menudemo.html");
	}
    con.close();
}
catch(Exception e)
{
	out.println(e);
}
out.println("</body>");
out.println("</html>");
out.close();
}
}