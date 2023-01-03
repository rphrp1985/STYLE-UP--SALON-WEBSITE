package backend;

import java.io.IOException;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		
		DataBase.insertRecord(name,email, mobile, password);
		
		RequestDispatcher rd=request.getRequestDispatcher("Entry");  
        rd.forward(request, response);  
        
        
		
				
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","1234" );
//			Statement stmt= con.createStatement();
//			System.out.println("inserting records");
//			String sql = "insert into users values('rp','pass')";
//			stmt.execute(sql);
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
