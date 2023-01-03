package backend;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Entry
 */
@WebServlet("/Entry")
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Entry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		try {
			
			Cookie ck[] = request.getCookies();
			String name= null,mobile=null;
			
			for(Cookie c: ck) {
				
				if(c.getName().toString().equals("name") )
					name= c.getValue();
				

				if(c.getName().toString().equals("mobile") )
					mobile= c.getValue();
				
				
			}
			
			if(name!=null && mobile !=null) {
				
				System.out.println("User Is Logged in");
				
				PrintWriter pw = response.getWriter();
				pw.print(HTMLProvider.getIndex(name));
				pw.close();
				
				
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println("User Is Logged out ");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print(HTMLProvider.getIndex());
		pw.close();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
