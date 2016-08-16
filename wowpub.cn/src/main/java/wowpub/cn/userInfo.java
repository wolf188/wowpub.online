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
			msgMap.put("userName", "�����벻С��6λ���ȵ��û���");
			isValidate = false;
		}
		
		if(this.userPassword != null && this.userPassword.length() < 6){
			msgMap.put("userPassword", "���볤�Ȳ�С��6λ����");
			isValidate = false;
		}
		
		if(this.confirmPwd != null && !this.confirmPwd.equals(this.userPassword)){
			msgMap.put("confirmPwd", "������������벻һ�£����������룡");
			isValidate = false;
		}
		
		if(this.email != null && this.email.contains("@")){
			msgMap.put("email", "�����ʽ���ԣ�");
			isValidate = false;
		}
			
		return isValidate;
	}
}
