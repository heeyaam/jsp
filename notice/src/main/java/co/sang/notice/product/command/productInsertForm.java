package co.sang.notice.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;

public class productInsertForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// 입력폼 호출
		return "product/productInsert";
	}

}