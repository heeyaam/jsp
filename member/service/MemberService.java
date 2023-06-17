package co.market.lemon.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	MemberVO memberSelectName(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	MemberVO memberLogin(MemberVO vo); 
	
	
	//주말 수정
	int memberDeleteName(MemberVO vo);
	int memberGradeUpdate(MemberVO vo);
	
	
}
