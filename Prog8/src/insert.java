import java.io.PrintWriter;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

    static Connection getConnection() throws Exception
	{
	 String Driver="com.mysql.jdbc.Driver";
	 String url="jdbc:mysql://localhost:3306/onlinedirectory";
	 String uname="root";
	 String pass="1628";
	 Connection conn=DriverManager.getConnection(url,uname,pass);
	 return conn;
	}
	Connection conn;
	Statement stmt;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		boolean flag=false;
		java.sql.ResultSet rs=null;
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			if(conn!=null) {
				String name=request.getParameter("name");
				int contact=Integer.parseInt(request.getParameter("contact"));
				String address=request.getParameter("address");
				String company=request.getParameter("company");
				int pin=Integer.parseInt(request.getParameter("pin"));
				out.println("Name:"+name);
				out.println("Contact:"+contact);
				out.println("Address:"+address);
				out.println("Company:"+company);
				out.println("Pincode:"+pin);
				String qu;
				qu="insert into tele_dir values('"+name+"',"+contact+",'"+address+"','"+company+"',"+pin+");";
				stmt.executeUpdate(qu);
				out.println("Records Updated");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("can not connect to SQL");
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();}			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
