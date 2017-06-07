package com.board.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dto.Member;
import com.board.service.MemberService;

public class UpdateMemberAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));	
		try {
			MemberService.getInstance().updateMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String url="listMember?page="+request.getParameter("page");
		
		return "redirect:"+url;
	}

}
