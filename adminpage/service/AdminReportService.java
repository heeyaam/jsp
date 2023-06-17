package co.market.lemon.adminpage.service;

import java.util.List;

public interface AdminReportService {

	List<AdminReportVO> reportSelectList();

	AdminReportVO reportSelect(AdminReportVO vo);

	int reportUpdate(AdminReportVO vo);

	int reportDelete(AdminReportVO vo);
	
	//주말 수정
	
	int reportAllDelete(AdminReportVO vo);

}
