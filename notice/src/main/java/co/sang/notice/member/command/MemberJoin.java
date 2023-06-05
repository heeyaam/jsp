package co.sang.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// 회원가입 폼만 돌려주면 됨
		
		return "member/memberInsert";
	}

}
