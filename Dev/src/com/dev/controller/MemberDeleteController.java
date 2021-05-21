package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.MemberDAO;
import com.dev.service.MemberService;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String id = request.getParameter("id");
		System.out.println(id);
		
		MemberService service = MemberService.getInstance();
		service.memberDelete(id);
		
		request.setAttribute("id", id);
		
		RequestDispatcher rd = request.getRequestDispatcher("Result/memberDeleteOutput.jsp");
		rd.forward(request, response);
	}

}
