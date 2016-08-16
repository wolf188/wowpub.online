package wowpub.cn;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

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
		userInfo userinfo1;
		// TODO Auto-generated method stub
		try {
			//userInfo userinfo1 = WebUtil.Request2Bean(request, userInfo.class);
			userinfo1 = new userInfo();

			userinfo1.userName = request.getParameter("userName");
			userinfo1.userPassword = request.getParameter("userPassword");
			userinfo1.confirmPwd = request.getParameter("confirmPwd");
			userinfo1.email = request.getParameter("email");

			if(!userinfo1.IsValidate()){
				request.setAttribute("userinfo1", userinfo1);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
						
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loading mysql driver !");

			Connection connection = DriverManager.getConnection("jdbc:mysql://120.76.120.122:3306/realmd1", "root", "Mangos!1");
			System.out.println("Connect mysql !");
			Statement state = connection.createStatement();
			String sql = String.format("INSERT INTO account(username, sha_pass_hash, expansion) VALUES(%s,SHA1(CONCAT(UPPER(%s),':',UPPER(%s))), 1)", 
					userinfo1.userName, userinfo1.userName, userinfo1.userPassword);
			//ResultSet rs = state.executeQuery(sql);
			int nRs = state.executeUpdate(sql);
			if(nRs != 1){
				response.getWriter().append("创建账号失败！");
			}
			else{
				request.getRequestDispatcher("/web-inf/login.jsp").forward(request, response);
			}
				
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();	
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
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
