package com.dev.controller;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  전체 애플리케이션의 컨트롤러 등록
 *  *.do, *.action
 */
public class FrontController extends HttpServlet {
	HashMap<String, Controller> list;
	String charset = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		// front 요청하면 제일 처음 한번만 실행
		list = new HashMap<>();
		// list.put("/요청하는 패이지.do", "컨트롤러");
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);

		String uri = req.getRequestURI(); // /dev/insertMember.do
		String contextPath = req.getContextPath(); // /dev
		String path = uri.substring(contextPath.length()); // /insertMember.do
		System.out.println(path);

		Controller sub = list.get(path);
		sub.execute(req, resp);
	}
}
