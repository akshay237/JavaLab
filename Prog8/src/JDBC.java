import  java.sql.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBC
 */
@WebServlet("/JDBC")
public class JDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBC() {
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
		PrintWriter out=response.getWriter();
		//Connection conn;
		boolean flag=false;
		//Statement stmt;
		java.sql.ResultSet rs=null;
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			int inp;
			try {
				inp=Integer.parseInt(request.getParameter("phone"));
				rs=stmt.executeQuery("Select * from tele_dir where contact="+inp);
			}
			catch(Exception e) {
				String name=request.getParameter("phone");
				rs=stmt.executeQuery("Select * from tele_dir where name='"+name+"'");
			}
			if(rs.next()) {
				String name=rs.getString(1);
				int contact=rs.getInt(2);
				String address=rs.getString(3);
				String company=rs.getString(4);
				int pin=rs.getInt(5);
				out.println("Name:"+name);
				out.println("Contact:"+contact);
				out.println("Address:"+address);
				out.println("Company:"+company);
				out.println("Pincode:"+pin);
			}
			else
				out.println("No contact found");
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
				e.printStackTrace();

			}
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
