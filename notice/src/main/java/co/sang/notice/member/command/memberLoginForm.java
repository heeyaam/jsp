package co.sang.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;

public class memberLoginForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// TODO Auto-generated method stub
		return "member/memberLogin";
	}

}
