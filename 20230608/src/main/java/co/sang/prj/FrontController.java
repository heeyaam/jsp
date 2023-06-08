package co.sang.prj;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.prj.command.MainCommand;
import co.sang.prj.common.Command;
import co.sang.prj.member.command.Contact;
import co.sang.prj.project.command.Projects;
import co.sang.prj.resume.command.Resume;

/**
 * Servlet implementation class FrontController2
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> map = new HashMap<String, Command>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		map.put("/main.do", new MainCommand());
		map.put("/resume.do", new Resume());
		map.put("/projects.do", new Projects());
		map.put("/contact.do", new Contact());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 하는 부분
				// 요청을 분석하고 수행할 Command를 찾아서 수행하고 결과를 돌려준다.
				request.setCharacterEncoding("utf-8"); // 한글 깨짐방지
				String uri = request.getRequestURI(); // 호출한 uri를 구함.
				String contextPath = request.getContextPath(); // root를 구함.
				String page = uri.substring(contextPath.length()); // 실제 요청한 페이지 구함.

				Command command = map.get(page); // 수행할 command를 가져온다.
				String viewPage = command.exec(request, response);

				if (!viewPage.endsWith(".do")) {
//					viewPage = "WEB-INF/views/" + viewPage + ".jsp";     tiles안탈때
					viewPage += ".tiles";     //tiles 탈때
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
					dispatcher.forward(request, response);
				} else {
					response.sendRedirect(viewPage); // 결과가 *.do 이면 위임해 버린다.
				}


	}

}
