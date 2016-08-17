package wowpub.cn;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class userInfo {

	private String userName;
	private String userPassword;
	private String confirmPwd;
	private String email;
	private Map<String, String> msgMap = new HashMap<String, String>();
	
	public Map<String, String> getMsgMap(){
		return msgMap;
	}
	
	public void setMsgMap(Map<String, String> msgMap){
		this.msgMap = msgMap;
	}
	
	public void setUserName(String name){
		this.userName = name;
	}
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserPassword(String pwd){
		this.userPassword = pwd;
	}
	
	public String getUserPassword(){
		return this.userPassword;
	}
	
	public void setConfirmPwd(String pwd){
		this.confirmPwd = pwd;
	}
	
	public String getConfirmPwd(){
		return this.confirmPwd;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	
	public boolean IsValidate(){
		boolean isValidate = true;
		if(this.userName == null || !this.userName.matches("\\w{5,12}")){
			msgMap.put("userName", "用户名长度5-12位且用户名仅为字母或者数字！");
			isValidate = false;
		}
		
		if(this.userPassword == null || this.userPassword.length()<6 || this.userPassword.length()>12){
			msgMap.put("userPassword", "密码长度6-12位，最少包含1大写字母，数字，标点符号!");
			isValidate = false;
		}
		
		if(this.confirmPwd == null || !this.confirmPwd.equals(this.userPassword)){
			msgMap.put("confirmPwd", "两次密码不一致！");
			isValidate = false;
		}
		
		if(this.email == null || !this.email.matches("[a-zA-Z0-9]{3,12}@.+[a-zA-Z]")){
			msgMap.put("email", "邮箱格式不对！");
			isValidate = false;
		}
			
		return isValidate;
	}
}
