package com.board.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dto.Message;
import com.board.service.UpdateMessageService;

public class UpdateMessageAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		Message message=new Message();
		message.setGuestName(request.getParameter("guestName"));
		message.setId((request.getParameter("messageId")));
		message.setMessage(request.getParameter("message"));
		message.setPassword(request.getParameter("password"));
		
		try {
			UpdateMessageService.getInstance()
			.updateMessage(message);
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		String url="listMessage?page="+request.getParameter("page");
		
		
		return "redirect:"+url;
	}

}
