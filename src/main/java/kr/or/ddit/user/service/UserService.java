package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;

public class UserService implements UserServiceI {
	
	private UserDaoI dao = new UserDao();
	
	@Override
	public List<UserVo> selectAllUser() {
		// TODO Auto-generated method stub
		return dao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
		// TODO Auto-generated method stub
		return dao.selectUser(userid);
	}

	@Override
	public Map<String, Object> selectPagingUser(PageVo vo) {
		Map<String, Object> map = new HashMap<String,Object>();
		
		List<UserVo> userList = dao.selectPagingUser(vo);
		int userCnt = dao.selectAllUserCount();
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		return map;
	}

	@Override
	public int modifyUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return dao.modifyUser(userVo);
	}

	@Override
	public int registUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return dao.registUser(userVo);
	}

	@Override
	public int deleteUser(String userid) {
		// TODO Auto-generated method stub
		return dao.deleteUser(userid);
	}

	

}
