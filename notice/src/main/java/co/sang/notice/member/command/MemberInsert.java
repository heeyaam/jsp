package co.sang.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.member.service.MemberVO;
import co.sang.notice.member.serviceImpl.MemberServiceImpl;
import co.sang.notice.service.MemberService;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// T회원가입을 수행한다
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId")); //name을 사용(자바에서 사용)
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberGender(request.getParameter("memberGender"));
		vo.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
		
		int n = ms.memberInsert(vo);
		
		if(n != 0) {
			request.setAttribute("message", "회원가입이 정상적으로 처리되었다");
		}else {
			request.setAttribute("message", "회원가입이 실패 되었습니다. 다시하세요");
		}
		return "member/memberMessage";
	}

}
