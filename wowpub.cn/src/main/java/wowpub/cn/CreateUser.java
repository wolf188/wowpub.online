package wowpub.cn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Servlet implementation class CreateUser
 */
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			userInfo userinfo = WebUtil.Request2Bean(request, userInfo.class);
			if(!userinfo.IsValidate()){
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
						
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loading mysql driver !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/realmd1", "root", "mangos");
			System.out.println("Connect mysql !");
			Statement state = connection.createStatement();
			ResultSet rs = state.executeQuery("select username, gmlevel from account;");
			while(rs.next()){
				System.out.println(rs.getString("username"));
				response.getWriter().append("username = ").append(rs.getString("username")).append("    ");
				response.getWriter().append("gmlevel = ").append(rs.getString("gmlevel")).append("\r\n");
				
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();	
		}
		response.getWriter().append("Create account OK!").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		doGet(request, response);
	}

}
