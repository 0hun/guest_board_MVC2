package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.DeleteMessageService;
import com.board.service.InvalidMessagePasswordException;
import com.board.service.MessageNotFoundException;
import com.board.service.ServiceException;

public class DeleteMessageAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int message_id = Integer.parseInt(request.getParameter("messageId"));
		String password=request.getParameter("password");
		boolean invalidPassowrd=false;
		try {
			DeleteMessageService.getInstance().deleteMessage(message_id, password);
		} catch (ServiceException e) {		
			e.printStackTrace();
		} catch (InvalidMessagePasswordException e) {
			invalidPassowrd=true;
		} catch (MessageNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("invalidPassowrd", invalidPassowrd);
		
		return "deleteMessage.jsp";
	}

}
