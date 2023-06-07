package co.sang.notice.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.service.NoticeService;
import co.sang.notice.service.NoticeVO;
import co.sang.notices.service.Impl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeWriter(request.getParameter("noticeWriter"));
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeWdate(Date.valueOf(request.getParameter("noticeWdate")));
		vo.setNoticeSubhect(request.getParameter("noticeSubhect"));

		int n = ns.noticeInsert(vo);

		if (n != 0) {
			request.setAttribute("message", "게시글 등록 완료되었습니다");
		} else {
			request.setAttribute("message", "게시글 등록이 실패하였습니다");
		}

		return "notice/noticeMessage";
	}

}
