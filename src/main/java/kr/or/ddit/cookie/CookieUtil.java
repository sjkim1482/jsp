package kr.or.ddit.cookie;

public class CookieUtil {
	/** 
	 * Method : getCookieValue
	 * 작성자 : PC-02
	 * 변경이력 : 
	 * @param cookieStr
	 * @param cookieName
	 * @return 
	 * Method 설명 : cookieStr에서 cookieName에 해당하는 쿠키 값을 조회
	 */
	
	//cookieStr : userid=brown; rememberme=Y; test=testcookie
	//cookieName : userid, rememberme
	//return : brown, Y
	public static String getCookieValue(String cookieStr, String cookieName) {
		String[] cookies = cookieStr.split("; ");
		
		String result = "";
		
		for(int i = 0; i<cookies.length; i++) {
			String[] cookies1 = cookies[i].split("=");
			if(cookies1[0].equals(cookieName)) {
				result = cookies1[1];
			}
			
		}
		
		
		
		
		return result;
	}
	

	
	
	
}
