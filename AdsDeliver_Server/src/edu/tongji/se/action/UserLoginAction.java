package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.AuthorInterceptor;

public class UserLoginAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService mUserService;
	
	private String loginname;
	
	private String password;
	
	private int result;
	
	private Map<String, Object> session;

	public void setmUserService(UserService mUserService) {
		this.mUserService = mUserService;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginname() {
		return loginname;
	}

	public String getPassword() {
		return password;
	}
	
	

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	public String login() throws Exception {
		
		result = mUserService.validateUser(loginname, password);

		if(result == 1) {
			session.put(AuthorInterceptor.USER_SESSION_KEY, loginname);
		}
		
		return SUCCESS;
	}

	
	public String goindex() throws Exception {
		return SUCCESS;
	}
	
}