package com.xiaoxcn.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.common.utils.IDUtilx;
import com.common.utils.MD5Utilx;
import com.common.utils.StringUtilx;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;
import com.xiaoxcn.listener.MyPreResultListener;
import com.xiaoxcn.service.AccountService;
import com.xiaoxcn.service.impl.AccountServiceImpl;

public class AccountAction extends ActionSupport {
	
	/**
	 * 登录操作
	 * @return
	 */
	public String login(){
		String password = MD5Utilx.toMD5(account.getPassword());
		account.setPassword(password);
		AccountService accountService = new AccountServiceImpl();
		UserEntity userEntity = accountService.doLogin(account);
		if(userEntity!=null&& !StringUtilx.isBlank(userEntity.getId())){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("userInfo", userEntity);
			String autoLogin = request.getParameter("autoLogin");
			Cookie cookie = new Cookie("accountInfo", account+"&"+password);
			cookie.setPath("/");
			if(!StringUtilx.isBlank(autoLogin)){
				cookie.setMaxAge(60*60*24*7);
			}else{
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			return "loginSuccess";
		}else{
			this.addActionError(this.getText("account_or_pwd_wrong"));
			return "loginFail";
		}
		
	}
	/**
	 * 登录验证
	 */
	public void validateLogin(){
		if(StringUtilx.isBlank(account.getAccount())){
			this.addFieldError("account", this.getText("account_not_null"));
		}
		if(StringUtilx.isBlank(account.getPassword())){
			this.addFieldError("password", this.getText("pwd_not_null"));
		}
	}
	/**
	 * 退出登录
	 * @return
	 */
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("userInfo");
		PreResultListener prl = new MyPreResultListener();
		ActionContext.getContext().getActionInvocation().addPreResultListener(prl);
		return "logoutSuccess";
	}
	
	public String register(){
			String userId = IDUtilx.getUUID();
			String accountId = IDUtilx.getUUID();
			user.setId(userId);
			user.getAccountList().get(0).setId(accountId);
			user.getAccountList().get(0).setPassword(MD5Utilx.toMD5(user.getAccountList().get(0).getPassword()));
			user.getAccountList().get(0).setUserId(userId);
			AccountService accountService = new AccountServiceImpl();
			Boolean flag = accountService.doRegister(user,user.getAccountList().get(0));
			if(flag){
				return "registerSuccess";
			}else{
				this.addActionError(this.getText("register_fail"));
				return "registerFail";
			}
		
	}
	
	private AccountEntity account;
	private UserEntity user;
	public AccountEntity getAccount() {
		return account;
	}
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
