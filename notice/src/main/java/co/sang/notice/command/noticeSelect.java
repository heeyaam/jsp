package co.sang.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.service.NoticeService;
import co.sang.notice.service.NoticeVO;
import co.sang.notices.service.Impl.NoticeServiceImpl;

public class noticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// 게시글 상세보기
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo = ns.noticeSelect(vo);
		request.setAttribute("notice", vo);
		return "notice/noticeSelect";
	}

}
