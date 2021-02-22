package com.finastra.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDbServlet() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Setting up connection variables 
		
				//Establishing the connection with the Database
				
				String username = "adhya";
				String password = "tiger";
				
				String connectionUrl = "jdbc:mysql://localhost:3306/finastra?useSSL=false" ;
				// Set driver
				String driver = "com.mysql.jdbc.Driver";
				
				//Establishing the connection with the DB
				
				try
				{
					
					//Getting handle for response object - we don't want to write on command prompt
					PrintWriter pw = response.getWriter();
					pw.println("Connecting to Database with " + connectionUrl);
					
					// To load the Database Driver 
					Class.forName(driver);
					
					// Establishing a connection with MySql Database
					Connection con = DriverManager.getConnection(connectionUrl, username, password);
					
					pw.println("Connection Successful!!");
				
					// Close the connection
					con.close();
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
	}


}
