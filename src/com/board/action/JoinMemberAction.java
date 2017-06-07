package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dto.Member;
import com.board.service.MemberService;

public class JoinMemberAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="joinSuccess.jsp";
		String message=null;
		
		request.setCharacterEncoding("utf-8");
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		MemberService.getInstance().joinMember(member);
		
		message = "회원가입을 축하합니다.";
		request.setAttribute("message", message);
		
		return url;
	}

}
