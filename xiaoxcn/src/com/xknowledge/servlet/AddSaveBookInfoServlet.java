package com.xknowledge.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.tomcat.util.http.fileupload.DiskFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

import com.common.utils.IDUtilx;
import com.xknowledge.domain.Book;
import com.xknowledge.domain.BookPlus;
import com.xknowledge.service.BookService;
import com.xknowledge.service.impl.BookServiceImpl;

/**
 * Servlet implementation class AddBookInfoServlet
 */
public class AddSaveBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改代码支持封面上传
		String savePath =this.getServletContext().getRealPath("upload/"+Calendar.YEAR);
		File file = new File(savePath);
		if(!(file.exists()&&file.isDirectory())){
			file.mkdirs();
		}
		//临时文件保存目录
		String tempPath = this.getServletContext().getRealPath("temp");
		File tempFile = new File(tempPath);
		if(!(file.exists()&&file.isDirectory())){
			tempFile.mkdirs();
		}
		Map<String,Object> requestMap = new HashMap();
		String saveFile = "";
		DiskFileUpload dfu = new DiskFileUpload();
		dfu.setHeaderEncoding("UTF-8");
		//如果上次的文件大于指定大小，则将生成的临时文件放在临时目录
		dfu.setSizeThreshold(1024*100); //100kb
		dfu.setRepositoryPath(tempPath);
		
		if(dfu.isMultipartContent(request)){
			try {
				List<FileItem> list = dfu.parseRequest(request);
				for(FileItem item:list){
					if(item.isFormField()){
						requestMap.put(item.getFieldName(), item.getString("UTF-8"));
					}else{
						String fileName = item.getName();
						if(fileName==null||fileName.trim().equals("")){
							continue;
						}
						fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
						InputStream is = item.getInputStream();
						saveFile = savePath+"\\"+IDUtilx.getUUID()+"_"+fileName;
						System.out.println(saveFile);
						FileOutputStream os = new FileOutputStream(saveFile);
						byte buffer[] = new byte[1024];
						int len=0;
						while((len=is.read(buffer))>0){
							os.write(buffer,0,len);
						}
						is.close();
						os.close();
						item.delete();
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			requestMap.put("cover", saveFile);
			Book book = new Book();
			BookPlus bookPlus = new BookPlus();
			try {
				BeanUtils.populate(book, requestMap);
				BeanUtils.populate(bookPlus, requestMap);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			book.setBookPlus(bookPlus);
			BookService bookService = new BookServiceImpl();
			bookService.addBookInfo(book);
			request.getRequestDispatcher("/xknowledge/queryBookPageServlet?operateType=skip").forward(request, response);
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
