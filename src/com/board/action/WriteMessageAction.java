package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dto.Message;
import com.board.service.ServiceException;
import com.board.service.WriteMessageService;

public class WriteMessageAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Message message = new Message();
		
		message.setPassword(request.getParameter("password"));
		message.setMessage(request.getParameter("message"));
		message.setGuestName(request.getParameter("guestName"));
		message.setId(request.getParameter("messageId"));
		
		
		WriteMessageService writeService = WriteMessageService.getInstance();
		
		try {
			writeService.write(message);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:listMessage";
	}

}
