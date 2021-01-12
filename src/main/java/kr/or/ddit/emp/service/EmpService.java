package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.repository.EmpDao;
import kr.or.ddit.emp.repository.EmpDaoI;

public class EmpService implements EmpServiceI {

	private EmpDaoI dao = new EmpDao();
	
	@Override
	public List<EmpVo> selectAllEmployee() {
		// TODO Auto-generated method stub
		return dao.selectAllEmployee();
	}

	@Override
	public EmpVo selectEmployee(String userid) {
		// TODO Auto-generated method stub
		return dao.selectEmployee(userid);
	}

	@Override
	public List<EmpVo> selectPagingEmployee(PageVo vo) {
		// TODO Auto-generated method stub
		return dao.selectPagingEmployee(vo);
	}

}
