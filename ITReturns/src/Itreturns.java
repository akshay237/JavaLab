import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Itreturns
 */
@WebServlet("/Itreturns")
public class Itreturns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Itreturns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		Float salary=Float.parseFloat(request.getParameter("salary"));
		Float taxp=Float.parseFloat(request.getParameter("tax"));
		Float taxamt=(taxp/100)*salary;
		Float basic=salary-taxamt;
		PrintWriter out = response.getWriter();
		File file=new File("1.txt");
		file.createNewFile();
		FileOutputStream fout = new FileOutputStream(file);
		out.println("Name:"+name);
		out.println("Gender:"+gender);
		out.println("Salary:"+salary);
		out.println("Tax:"+taxamt);
		out.println("Net:"+basic);
		fout.write(("Hello"+ " " +name+ " " +gender+ " " +salary+ " " +taxamt+ " " +basic).getBytes());
		fout.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
