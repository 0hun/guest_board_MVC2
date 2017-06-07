package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dto.Member;
import com.board.service.MemberService;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url="loginSuccess.jsp";
		String message=null;
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		Member member=
				MemberService.getInstance().loginMember(id, pwd);
		if(member!=null){
			if(member.getPwd().equals(pwd)){
				message="로그인 성공";
				request.getSession().setAttribute("loginUser", member);				
			}else{
				message="패스워드가 일치하지 않습니다.";
				url="loginForm.jsp";
			}			
		}else{
			message="아이디가 존재하지 않습니다.";
			url="loginForm.jsp";
		}
		request.setAttribute("message", message);		
		
		return url;
	}

}
