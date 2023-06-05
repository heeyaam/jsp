package co.sang.notice.service;

import java.util.List;

import co.sang.notice.member.service.MemberVO;

public interface MemberService {

	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
