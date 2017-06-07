package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dto.MemberListView;
import com.board.service.MemberService;
import com.board.service.ServiceException;

public class ListMemberAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageNumberStr = request.getParameter("page");
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}

		MemberService memberService = MemberService.getInstance();
		MemberListView viewData=null;
		try {
			 viewData= memberService.selectMemberList(pageNumber);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("viewData",viewData);
		request.setAttribute("pageNumber",pageNumber);
		
		
		return "memberList.jsp";
	}

}
