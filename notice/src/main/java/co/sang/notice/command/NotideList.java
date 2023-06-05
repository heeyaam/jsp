package co.sang.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.service.NoticeService;
import co.sang.notice.service.NoticeVO;
import co.sang.notices.service.Impl.NoticeServiceImpl;

public class NotideList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// 게시글 목록 가져오기
		NoticeService ns = new NoticeServiceImpl(); //모델 호출
		List<NoticeVO> notices = new ArrayList<>();  // 호출한 결과 담을것
		notices = ns.noticeSelectList();
		
		request.setAttribute("notices", notices); // jsp 에 보내기 위해 결과를 객체에 담는다 어떤이름으로 어떤걸 담겠다
							//   변수명 , 값
		return "notice/noticeList";   //바로위에 결과를 담아 이 페이지에 담아 달라
	}

}
