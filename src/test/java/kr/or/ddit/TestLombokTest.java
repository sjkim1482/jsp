package kr.or.ddit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestLombokTest {

	
	@Test
	public void Test() {
		/***Given***/
		TestLombok test = new TestLombok();

		/***When***/
		test.setNum(1);
		test.setName("김선중");

		/***Then***/
		assertEquals(1, test.getNum());
		assertEquals("김선중", test.getName());
		
	}

}
