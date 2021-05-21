FrontController (실행할 sub controller등록) -> subController(servlet) : 관리

com.dev.controller : 컨트롤러 com.dev.dao : DB처리 com.dev.service : 비지니스 로직 com.dev.vo : 모델

사용자 화면(view): memberDelete.jsp : memberInsert.jsp : memberSearch.jsp : memberUpdate.jsp

처리결과(view) : memberDeleteOutput.jsp : memberInsertOutput.jsp : memberSearchOutput.jsp : memberUpdateOutput.jsp

MVC Model : 클래스(Member), 서비스(Service), DB처리(DAO) View : 사용자에게 화면(JSP) Controller : jsp(MVC1), servlet(MVC2);
