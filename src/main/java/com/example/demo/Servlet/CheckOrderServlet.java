package com.example.demo.Servlet;


import com.example.demo.Dao.CheckOrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Check_Order
 */
@WebServlet("/CheckOrderServlet")
public class CheckOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String classnumber=request.getParameter("classnumber");  
		String phonenumber=request.getParameter("phonenumber");
		String ordertable=request.getParameter("ordertable");
		
        String i ="" ;

        System.out.println("׼����ѯ������"+classnumber+"�ֻ���"+phonenumber+"��������"+ordertable);
        
        response.setContentType("text/html;charset-UTF-8");
        
        PrintWriter outPrintWriter=response.getWriter();
        CheckOrderDao checkOrderDao = new CheckOrderDao();
        
        try {
			i=checkOrderDao.checkOrder(classnumber,phonenumber,ordertable);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.print("��ϸ��ѯ����,�������"+i);
		outPrintWriter.println(i);
		outPrintWriter.close();
	}

}
