package com.xknowledge.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadCoverServlet
 */
public class DownloadCoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadCoverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String fileQualifiedName = request.getParameter("cover");
		System.out.println(fileQualifiedName);
		File file = new File(fileQualifiedName);
		if(file.exists()){
			String realName = fileQualifiedName.substring(fileQualifiedName.indexOf("_")+1);
			System.out.println(realName);
			response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(realName,"UTF-8"));
			FileInputStream in = new FileInputStream(fileQualifiedName);
			OutputStream out = response.getOutputStream();
			byte buffer[] = new byte[1024];
			int len=0;
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
			in.close();
			out.close();
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
