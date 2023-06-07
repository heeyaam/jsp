package co.sang.notice.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.service.NoticeService;
import co.sang.notice.service.NoticeVO;
import co.sang.notices.service.Impl.NoticeServiceImpl;

public class NoticeUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// 게시글을 DB에 수정해서 저장한다.
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo.setNoticeWdate(Date.valueOf(request.getParameter("noticeWdate")));
		vo.setNoticeTitle(request.getParameter("noticeTItle"));
		vo.setNoticeSubhect(request.getParameter("noticeSubhect"));

		int n = ns.noticeUpdate(vo);
		if (n != 0) {
			request.setAttribute("message", "정상적으로 수정되었습니다");

		} else {
			request.setAttribute("message", "게시글 수정이 실패했습니다");
		}
		return "notice/noticeMessage";
	}

}
