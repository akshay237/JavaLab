

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tcon
 */
@WebServlet("/tcon")
public class tcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tcon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String[] Accessories= {};
		Accessories=request.getParameterValues("access");
		String tshirtAccessories="";
		String tshirtTagLine=request.getParameter("tagline");
		String tshirtOption=request.getParameter("option");
		String tshirtColor=request.getParameter("color");
		out.println("<html>");
		out.println("<head><title>Tshirt</title></head>");
		out.println("<body>");
		try {
			String Driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/tshirt";
			String uname="root";
			String pass="1628";
			Statement stmt;
			Class.forName(Driver);
			Connection conn=DriverManager.getConnection(url,uname,pass);
			if(conn!=null) {
				stmt=conn.createStatement();
				String query;
				if(tshirtAccessories!=null&&tshirtTagLine!=null&&tshirtOption!=null&&tshirtColor!=null) {
					for(String option:Accessories) {
						tshirtAccessories+=option;
					}
				}
				query="insert into Tshirts values("+null+",'"+tshirtAccessories+"','"+tshirtTagLine+"','"+tshirtOption+"','"+tshirtColor+"');";
				stmt.executeUpdate(query);
				String query1="Select * from Tshirts;";
				ResultSet rs=stmt.executeQuery(query1);
				out.println("<table border=2>");
				out.println("<tr>");
				out.println("<td>OrderNo</td>");
				out.println("<td>tshirtAccessories</td>");
				out.println("<td>tshirtTagLine</td>");
				out.println("<td>tshirtOption</td>");
				out.println("<td>tshirtColor</td>");
				out.println("</tr>");
				if(!rs.isBeforeFirst()) {
					out.println("<tr>");
						out.println("<td>100</td>");
						out.println("<td>null</td>");
						out.println("<td>null</td>");
						out.println("<td>null</td>");
						out.println("<td>null</td>");
				    out.println("</tr>");
				}
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>"+(Integer.parseInt(rs.getString("OrderNo"))+99)+"</td>");
					out.println("<td>"+rs.getString("tshirtAccessories")+"</td>");
					out.println("<td>"+rs.getString("tshirtTagLine")+"</td>");
					out.println("<td>"+rs.getString("tshirtOption")+"</td>");
					out.println("<td>"+rs.getString("tshirtColor")+"</td>");
				}
				out.println("</table>");
				out.println("<a href=\"tshirts.jsp\">Click here</a>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		catch(Exception e) {
		    e.printStackTrace();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	//}
	}
}
