package co.sang.notice;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.command.NoticeDelete;
import co.sang.notice.command.NoticeEdit;
import co.sang.notice.command.NoticeInsert;
import co.sang.notice.command.NoticeInsertForm;
import co.sang.notice.command.NoticeUpdate;
import co.sang.notice.command.NotideList;
import co.sang.notice.command.noticeSelect;
import co.sang.notice.common.Command;
import co.sang.notice.main.command.MainCommand;
import co.sang.notice.member.command.AjaxCheckId;
import co.sang.notice.member.command.MemberInsert;
import co.sang.notice.member.command.MemberJoin;
import co.sang.notice.member.command.MemberList;
import co.sang.notice.member.command.MemberLogin;
import co.sang.notice.member.command.MemberLogout;
import co.sang.notice.member.command.memberLoginForm;
import co.sang.notice.product.command.ProductInsert;
import co.sang.notice.product.command.ProductList;
import co.sang.notice.product.command.productInsertForm;
//자바코드에서 Html을 생성하는 것 controller를 구성할떄 보통 사용
//mvc패턴을 사용할때는 init, service 를 주로 사용
/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") //mapping하는 부분
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

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
		// 처음 시작될 때 동작하는 메소드, 요청한 것을 담아 두는 곳
		//초기화 함 딱 처음 한번만
		map.put("/main.do", new MainCommand()); // 처음 들어오는 페이지를 돌려 준다.
		map.put("/noticeList.do", new NotideList()); // 게시글 목록 보기
		map.put("/noticeSelect.do", new noticeSelect()); //게시글 상세보기
		map.put("/noticeInsertForm.do", new NoticeInsertForm());
		map.put("/noticeInsert.do", new NoticeInsert());
		map.put("/noticeEdit.do",  new NoticeEdit());
		map.put("/noticeUpdate.do", new NoticeUpdate());
		map.put("/noticeDelete", new NoticeDelete());
		map.put("/memberList.do", new MemberList()); //맴버 목록 보기
		map.put("/memberJoin.do", new MemberJoin()); //회원강비 화면 호출
		map.put("/memberInsert.do", new MemberInsert()); //
		map.put("/ajaxCheckId.do", new AjaxCheckId());
		map.put("/memberLoginForm.do", new memberLoginForm());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLogout.do", new MemberLogout());
		
		//제품관리
		map.put("/productList.do", new ProductList()); //제품 목록 보기
		map.put("/productInsertForm.do", new productInsertForm());
		map.put("/productInsert.do", new ProductInsert());
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서비스 하는 부분
		// 요청을 분석하고 수행할 Command를 찾아서 수행하고 결과를 돌려준다.
		request.setCharacterEncoding("utf-8"); // 한글 깨짐방지
		String uri = request.getRequestURI(); // 호출한 uri를 구함.
		String contextPath = request.getContextPath(); // root를 구함.
		String page = uri.substring(contextPath.length()); // 실제 요청한 페이지 구함.

		Command command = map.get(page); // 수행할 command를 가져온다.
		String viewPage = command.exec(request, response);

		if (!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("Ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage); // 결과가 *.do 이면 위임해 버린다.
		}


	}

}
