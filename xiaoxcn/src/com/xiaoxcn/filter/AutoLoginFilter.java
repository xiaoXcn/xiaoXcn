package com.xiaoxcn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;
import com.xiaoxcn.service.AccountService;
import com.xiaoxcn.service.impl.AccountServiceImpl;

public class AutoLoginFilter implements Filter{
	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)rq;
		HttpServletResponse response = (HttpServletResponse)rp;
		HttpSession session = request.getSession();
		Boolean isLogin = false;
		if(session.getAttribute("userInfo")!=null){
			isLogin = true;
			filterChain.doFilter(rq, rp);
		}else{
			Cookie[] cookies = request.getCookies();
			if(cookies!=null&&cookies.length>0){
				for(Cookie cookie:cookies){
					if("accountInfo".equalsIgnoreCase(cookie.getName())){
						String accountInfo = cookie.getValue();
						String[] strArr = accountInfo.split("&");
						if(strArr!=null&&strArr.length==2){
							String account = strArr[0];
							String password = strArr[1];
							AccountEntity accountEntity = new AccountEntity();
							accountEntity.setAccount(account);
							accountEntity.setPassword(account);
							AccountService accountService = new AccountServiceImpl();
							UserEntity userEntity= accountService.doLogin(accountEntity);
							if(userEntity!=null){
								isLogin = true;
								session.setAttribute("userInfo", userEntity);
								filterChain.doFilter(rq, rp);
							}
						}
					}
				}
			}
		}
		if(!isLogin){
			response.sendRedirect("/login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
