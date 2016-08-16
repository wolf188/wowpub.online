package wowpub.cn;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class userInfo {
	private String userName;
	private String userPassword;
	private String confirmPwd;
	private String email;
	public Map<String, String> msgMap = new HashMap<String, String>();
	
	public void SetUserName(String name){
		this.userName = name;
	}
	public String GetUserName(){
		return this.userName;
	}
	
	public void SetUserPwd(String pwd){
		this.userPassword = pwd;
	}
	
	public String GetUserPwd(){
		return this.userPassword;
	}
	
	public void SetConfirmPwd(String pwd){
		this.confirmPwd = pwd;
	}
	
	public String GetConfirmPwd(){
		return this.confirmPwd;
	}
	
	public void SetEmail(String email){
		this.email = email;
	}
	public String GetEmail(){
		return this.email;
	}
	
	public boolean IsValidate(){
		boolean isValidate = true;
		if(this.userName != null && this.userName.length() <= 6){
			msgMap.put("userName", "请输入不小于6位长度的用户！");
			isValidate = false;
		}
		
		if(this.userPassword != null && this.userPassword.length() < 6){
			msgMap.put("userPassword", "密码长度不小于6位数！");
			isValidate = false;
		}
		
		if(this.confirmPwd != null && !this.confirmPwd.equals(this.userPassword)){
			msgMap.put("confirmPwd", "两次输入的密码不一致，请重新输入！");
			isValidate = false;
		}
		
		if(this.email != null && this.email.contains("@")){
			msgMap.put("email", "邮箱格式不对！");
			isValidate = false;
		}
			
		return isValidate;
	}
}
