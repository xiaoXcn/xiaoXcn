package com.xiaoxcn.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.ActionEntity;
import com.common.utils.StrutsConfigUtilx;

/**
 * Servlet Filter implementation class StrutsConfigFilter
 */
public class StrutsConfigFilter implements Filter {
	
	private Map<String,ActionEntity> actionMap;

    /**
     * Default constructor. 
     */
    public StrutsConfigFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)rq;
		HttpServletResponse response = (HttpServletResponse)rp;
		String servletPath = request.getServletPath();
		int lastIndex = servletPath.lastIndexOf(".action");
		if(lastIndex>0){
		String name = servletPath.substring(1, lastIndex);
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		actionMap = StrutsConfigUtilx.resolveStrutsConfig();
	}

}
