package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.action.Action;



@WebServlet("/")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}
	
	// 사용자의 요청을 분석해서 해당 작업을 처리
		private void requestPro(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, 
				IOException {

			request.setCharacterEncoding("utf-8");		
			response.setContentType("text/html;charset=utf-8");
			
			String view = null;
			Action action = null;
			try {
				String command = request.getRequestURI();			
				if (command.indexOf(request.getContextPath()) == 0) {
					command = command.substring(request.getContextPath().length());
				}
				action =  ActionFactory.getAction(command);
				if (action == null) {
					System.out.println("not found : " + command);
					return;
				}

				view = action.execute(request, response);
				if (view == null) {
					return;
				}

			} catch (Throwable e) {
				throw new ServletException(e);

			}

			if (view == null)
				return;
			
			ViewResolver.view(view, request, response);
			
		}

	
}
