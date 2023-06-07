package co.sang.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.member.service.MemberVO;
import co.sang.notice.member.serviceImpl.MemberServiceImpl;
import co.sang.notice.service.MemberService;

public class AjaxCheckId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		MemberService ms= new MemberServiceImpl();
		MemberVO vo= new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		vo = ms.memberSelect(vo);
		String str="Ajax:";
		if(vo!=null) {
			str+="No";
		}else {
		str+="Yes";
		}
		return str;
	}

}
