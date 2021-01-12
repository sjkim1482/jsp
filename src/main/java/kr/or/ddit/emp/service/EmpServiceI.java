package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;

public interface EmpServiceI {
	//전체 사용자 정보 조회
	List<EmpVo> selectAllEmployee();
	
	//userid에 해당하는 사용자 한명의 정보 조회
	EmpVo selectEmployee(String userid);

	List<EmpVo> selectPagingEmployee(PageVo vo);	
}
