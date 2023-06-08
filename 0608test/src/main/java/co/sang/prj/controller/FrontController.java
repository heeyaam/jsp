package co.sang.prj.controller;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.prj.common.Command;
import co.sang.prj.main.command.MainCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); // 한글 깨짐방지
		String uri = request.getRequestURI(); // 호출한 uri를 구함.
		String contextPath = request.getContextPath(); // root를 구함.
		String page = uri.substring(contextPath.length()); // 실제 요청한 페이지 구함.

		Command command = map.get(page); // 수행할 command를 가져온다.
		String viewPage = command.exec(request, response);

		if (!viewPage.endsWith(".do")) {
//			viewPage = "WEB-INF/views/" + viewPage + ".jsp";    
			viewPage += ".tiles";     //tiles 탈때
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage); // 결과가 *.do 이면 위임해 버린다.
		}

}
}
