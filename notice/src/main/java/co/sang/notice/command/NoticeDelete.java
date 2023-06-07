package co.sang.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.service.NoticeService;
import co.sang.notice.service.NoticeVO;
import co.sang.notices.service.Impl.NoticeServiceImpl;

public class NoticeDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		NoticeService ns = new NoticeServiceImpl();
		NoticeVO vo= new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		int n = ns.noticeDelete(vo);
		
		if(n!=0) {
			request.setAttribute("message", "게시글이 정상적으로 삭제 되었습니다");
		}else {
			request.setAttribute("message", "게시글 삭제에 실패하였습니다");
		}
		
		return "notice/noticeMessage";
	}

}
