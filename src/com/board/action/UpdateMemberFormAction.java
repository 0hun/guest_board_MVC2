package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dto.Member;
import com.board.service.MemberService;

public class UpdateMemberFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		Member member = null;

		member = MemberService.getInstance().selectMember(memberId);
		request.setAttribute("member", member);
		
		return "updateMemberForm.jsp";
	}

}
