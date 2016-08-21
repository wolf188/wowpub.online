package wowpub.cn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//socket test
		WebSocket.sendData("java socket test!");
		userInfo registInfo;
		// TODO Auto-generated method stub
		try {
			registInfo = WebUtil.Request2Bean(request, userInfo.class);
			//registInfo = new userInfo();
//			registInfo.setUserName(request.getParameter("userName"));
//			registInfo.setUserPassword(request.getParameter("userPassword"));
//			registInfo.setConfirmPwd(request.getParameter("confirmPwd"));
//			registInfo.setEmail(request.getParameter("email"));

			if(!registInfo.IsValidate()){
				request.setAttribute("registInfo", registInfo);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}	
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loading mysql driver !");

			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/realmd1", "root", "Mangos!1");
			System.out.println("Connect mysql !");
			Statement state = connection.createStatement();
			
			/***************start 确认账号是否已存在*******/
			String sql = String.format("select username from account where username='%s'", registInfo.getUserName());
			ResultSet Rs = state.executeQuery(sql);
			if(Rs.next()){
				registInfo.getMsgMap().put("userName", "用户名已存在！");
				request.setAttribute("registInfo", registInfo);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				state.close();
				return;
			}
			/***************end 确认账号是否已存在*******/
			
			/***************start 确认账号是否已存在*******/
			sql = String.format("select email from account where email='%s'", registInfo.getEmail());
			Rs = state.executeQuery(sql);
			if(Rs.next()){
				registInfo.getMsgMap().put("email", "邮箱已有人使用！");
				request.setAttribute("registInfo", registInfo);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				state.close();
				return;
			}
			/***************end 确认账号是否已存在*******/
			
			sql = String.format("INSERT INTO account(username, sha_pass_hash, email, expansion) VALUES(\"%s\",SHA1(CONCAT(UPPER(\"%s\"),':',UPPER(\"%s\"))), \"%s\",1)", 
					registInfo.getUserName(), registInfo.getUserName(), registInfo.getUserPassword(), registInfo.getEmail());
			
			int nRs = state.executeUpdate(sql);
			if(nRs != 1){
				registInfo.getMsgMap().put("failed", "哦哦,创建账号失败,请重试！");
				request.setAttribute("registInfo", registInfo);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(request, response);
			}
			state.close();	
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
		doGet(request, response);
	}

}
