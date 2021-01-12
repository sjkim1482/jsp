package kr.or.ddit.emp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.emp.model.EmpVo;

public class EmpDao implements EmpDaoI {
	
	@Override
	public List<EmpVo> selectAllEmployee() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<EmpVo> empList = sqlSession.selectList("emp.selectAllEmployee");
		
		sqlSession.close();
		
		return empList;
	}

	@Override
	public EmpVo selectEmployee(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		EmpVo vo = sqlSession.selectOne("emp.selectEmployee", userid);
		
		sqlSession.close();
		
		return vo;
	}

	@Override
	public List<EmpVo> selectPagingEmployee(PageVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<EmpVo> empList = sqlSession.selectList("emp.selectPagingEmployee",vo);
		
		sqlSession.close();
		
		return empList;
	}

}
