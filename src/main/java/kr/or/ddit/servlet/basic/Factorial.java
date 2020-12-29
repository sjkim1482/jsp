package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial {
	private static final Logger logger = LoggerFactory.getLogger(Factorial.class);

	int fac = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial factorial = new Factorial();
		int result = factorial.calculate(5);
		
		if(result == 120) {
			logger.debug("success");
		}else {
			logger.debug("fail");
		}
		int result1 = factorial.calculate(0);
		
		if(result1 == 1) {
			logger.debug("success");
		}else {
			logger.debug("fail");
		}
		
	}
	
	/** 
	 * Method : calculate
	 * 작성자 : PC-02
	 * 변경이력 : 
	 * @param fac
	 * @return 
	 * Method 설명 : 인자로 들어온 n 값을 이용하여 팩토리알을 계산
	 */
	public int calculate(int fac) {
		
		/*
		 * this.fac *= fac;
		 * 
		 * fac--;
		 * 
		 * if(fac>0) { calculate(fac); }
		 * 
		 * 
		 * return this.fac;
		 */
		if(fac <= 1) {
			return 1;
		}else {
			return fac * calculate(fac-1);
		}
	}

}





