package co.sang.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.sang.notice.common.Command;
import co.sang.notice.member.service.MemberVO;
import co.sang.notice.member.serviceImpl.MemberServiceImpl;
import co.sang.notice.service.MemberService;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		//로그인 처리
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = ms.memberLogin(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("name", vo.getMemberName());
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다");
			
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가틀리다 ㅋ");
		}
		return "member/memberMessage";
	}

}
