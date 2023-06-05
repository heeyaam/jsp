package co.sang.notice.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.member.service.MemberVO;
import co.sang.notice.member.serviceImpl.MemberServiceImpl;
import co.sang.notice.service.MemberService;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		//Member List
		MemberService ms = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		members = ms.memberSelectList();
		
		request.setAttribute("members", members);
		return "member/memberList";
	}

}
