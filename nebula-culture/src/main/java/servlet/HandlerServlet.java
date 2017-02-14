package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.StringUtilx;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class HandlerServlet
 */
public class HandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HandlerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//利用将请求Url组装成类和方法，利用反射进行调用
		String requestUri = request.getContextPath();
		if(!StringUtilx.isBlank(requestUri)){
			String[] uriArr = requestUri.split("/");
			if(uriArr.length==3){
				if(!StringUtilx.isBlank(uriArr[1])){
					String oldRequestClassName = uriArr[1]+"Controller";
					String requestClassName = StringUtilx.upperFirstWord(oldRequestClassName);
					if(!StringUtilx.isBlank(uriArr[2])){
						String requestMehodName = uriArr[2].split("\\.")[0];
						try {
							Class<?> clazz = Class.forName("com.xiaoxcn.controller."+requestClassName);
							Object  object = clazz.newInstance();
							Method method = clazz.getMethod(requestMehodName, HttpServletRequest.class,HttpServletResponse.class);
							Object returnObj = method.invoke(object, request,response);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
