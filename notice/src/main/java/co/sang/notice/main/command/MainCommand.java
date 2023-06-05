package co.sang.notice.main.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// main.jsp 돌려주는 곳
		return "main/main"; //

	}

}
