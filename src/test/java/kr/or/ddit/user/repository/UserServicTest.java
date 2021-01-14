package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServicTest {
	UserServiceI userService;
	
	@Before
	public void userService() {
		userService = new UserService();
		
		//테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new  UserVo("testUser","테스트사용자","testUserPass",new Date(),"대덕","대전 중구 중앙로 76","4층","34940");
		
		userService.registUser(userVo);
		//신규입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제
		userService.deleteUser("nnnn");
		
		
	}

	@After
	public void tearDown() {
		
		userService.deleteUser("testUser");
	}
	
	
	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUserServiceTest() {
		/*** Given ***/

		/*** When ***/
		List<UserVo> userList = userService.selectAllUser();

		/*** Then ***/
		assertEquals(74, userList.size());
	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserServiceTest() {
		/*** Given ***/
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
		PageVo vo = new PageVo(1, 5);

		/*** When ***/
		Map<String, Object> map = userService.selectPagingUser(vo);
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
		int page = (int)Math.ceil((double)userCnt/vo.getPageSize());
		/*** Then ***/

		assertEquals(5, userList.size());
		assertEquals(15, page);
	}
	
	@Test
	public void userModifyServiceTest() {
		/***Given***/

		UserVo userVo = new UserVo("ddit","대덕인재", "dditpass",new Date(), "개발원 m","대전시 중구 중앙로 76",
				"4층 대덕인재개발원","34940");

		/***When***/
		int updateCnt = userService.modifyUser(userVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void registUserTest() {
		/***Given***/
		
		
		//userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		UserVo userVo = new UserVo("nnnn","대덕인재", "dditpass",new Date(), "개발원 m","대전시 중구 중앙로 76",
				"4층 대덕인재개발원","34940");

		/***When***/
		int intsertCnt = userService.registUser(userVo);

		/***Then***/
		assertEquals(1, intsertCnt);
		
	}
	
	
	
	//삭제 테스트
		@Test
		public void deleteUserTest() {
			/***Given***/
			//해당 테스트가 실행될 때는 testUser라는 사용자가 before 메소드에 의해 등록이 된 상태
			String userid = "testUser";
			/***When***/
			int deleteCnt = userService.deleteUser(userid);
			/***Then***/
			assertEquals(1, deleteCnt);
		}

}





