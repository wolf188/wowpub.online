package wowpub.cn;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import java.io.Serializable;

public class userInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userName;
	public String userPassword;
	public String confirmPwd;
	public String email;
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
		if(this.userName != null && this.userName.length() < 5){
			msgMap.put("userName", "111");
			isValidate = false;
		}
		
		if(this.userPassword != null && this.userPassword.length() < 6){
			msgMap.put("userPassword", "222");
			isValidate = false;
		}
		
		if(this.confirmPwd != null && !this.confirmPwd.equals(this.userPassword)){
			msgMap.put("confirmPwd", "333");
			isValidate = false;
		}
		
		if(this.email != null && !this.email.contains("@")){
			msgMap.put("email", "444");
			isValidate = false;
		}
			
		return isValidate;
	}
}
