package com.board.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dto.Message;
import com.board.service.UpdateMessageService;

public class UpdateMessageFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("updateMessageForm.jsp");
		String messageId=request.getParameter("messageId");
		int message_id=Integer.parseInt(messageId);
		Message message=null;
		try {
			message=
	UpdateMessageService.getInstance().getMessage(message_id);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		
		return "updateMessageForm.jsp";
	}

}
