package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServicTest {

	
	
	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUserServiceTest() {
		/*** Given ***/
		UserServiceI userService = new UserService();

		/*** When ***/
		List<UserVo> userList = userService.selectAllUser();

		/*** Then ***/
		assertEquals(16*4, userList.size());
	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserServiceTest() {
		/*** Given ***/
		UserServiceI userService = new UserService();
		String userid = "brown";

		/*** When ***/
		UserVo user = userService.selectUser(userid);
		/*** Then ***/

		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}

	// 사용자 아이디가 존지하지 않을 때, 특정 사용자 조회
	@Test
	public void selectUserNotExsistTest() {
		/*** Given ***/
		UserServiceI userService = new UserService();
		String userid = "ss";

		/*** When ***/
		UserVo user = userService.selectUser(userid);
		/*** Then ***/

		assertNull(user);
	}
	
	// 사용자 페이징 조회 테스트
	@Test
	public void selectPagingUserServiceTest() {
		/*** Given ***/
		UserServiceI userService = new UserService();
		PageVo vo = new PageVo(1, 5);

		/*** When ***/
		Map<String, Object> map = userService.selectPagingUser(vo);
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
		int page = (int)Math.ceil((double)userCnt/vo.getPageSize());
		/*** Then ***/

		assertEquals(5, userList.size());
		assertEquals(13, page);
	}
	
	@Test
	public void userModifyServiceTest() {
		/***Given***/
		UserService userService = new UserService();

		UserVo userVo = new UserVo("ddit","대덕인재", "dditpass",new Date(), "개발원 m","대전시 중구 중앙로 76",
				"4층 대덕인재개발원","34940");

		/***When***/
		int updateCnt = userService.modifyUser(userVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}

}





