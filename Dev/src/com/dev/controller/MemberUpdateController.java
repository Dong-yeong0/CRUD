package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String id = request.getParameter("id");
			String pass = request.getParameter("passwd");
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
			
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPasswd(pass);
			member.setName(name);
			member.setMail(mail);
			
			MemberService service = MemberService.getInstance();
			service.memberUpdate(member);
			
			request.setAttribute("member", member);
			
			RequestDispatcher rd = request.getRequestDispatcher("Result/memberUpdateOutput.jsp");
			rd.forward(request, response);
	}

}
