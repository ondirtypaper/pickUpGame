package dataManager;

import java.awt.geom.Point2D;
import java.util.regex.*;
import java.util.ArrayList;

public class Users {

	public static final int PW_VALID = 0;
	public static final int PW_ERROR_LENGTH = 1;
	public static final int PW_ERROR_SPACE = 2;
	public static final int PW_ERROR_CHAR = 3;
	
	public static final int LOG_IN_SUCCESS = 0;
	public static final int LOG_IN_WRONG_PW = 1;
	public static final int LOG_IN_WRONG_EMAIL = 2;
	public static final int LOG_IN_CANT_FIND_DB = 3;
	
	ArrayList<User> regList;
	ArrayList<ActiveUser> activeList;
	
	
	
	public Users(){
		regList = new ArrayList<User>();
		activeList = new ArrayList<ActiveUser>();
	}
	public int logInRequest(String email, String passWord) {
		if(regList.size() == 0) return LOG_IN_CANT_FIND_DB;
			
		for(User u : regList) {
			if(u.getEmail().equals(email)) {
				if(u.getPassWord().equals(passWord)) return LOG_IN_SUCCESS;
				else return LOG_IN_WRONG_PW;
			}
		}
		
		return LOG_IN_WRONG_EMAIL;
	}
	
	public boolean addUser(String name, String email, String passWord) {
		if(!isValidEmail(email)) {
			System.out.println("dataManager.Users : 가입 요청 거부 - 잘못된 형식 email");
			return false;
		}
		
		if(!isValidName(name)) {
			System.out.println("dataManager.Users : 가입 요청 거부 - 잘못된 형식 user name");
			return false;
		}
		int pwErrCode = isValidPassWord(passWord);
		if(pwErrCode != 0) {
			switch(pwErrCode) {
			case 1:
				System.out.println("dataManager.Users : 가입 요청 거부 - password 길이");
				return false;
			case 2:
				System.out.println("dataManager.Users : 가입 요청 거부 - password 공백 포함");
				return false;
			case 3:
				System.out.println("dataManager.Users : 가입 요청 거부 - password 영문 숫자 특수문자 중 미포함 있음");
				return false;
			}
		}
		for(int i = 0; i < regList.size() ; i++) {
			if(regList.get(i).getEmail().equals(email)) {
				System.out.println("dataManager.Users : 가입 요청 거부 - 중복 email ");
				return false;
			}
		}
		
		regList.add(new User(name, email, passWord));
		System.out.println("dataManager.Users : 가입 승인 " + email);
		//for Test
		for(User u : regList) {
			System.out.println("dataBase : " + u.getEmail());
		}
		return true;
	}
	/**
	 * 이메일 유효성 판단을 위한 method
	 * @param email
	 * @return 적합한 형식(is defined as regular expression)의 이메일인지 여부를 boolean 타입으로 반환
	 */
	public boolean isValidEmail(String email) {
		
		//if(!email.contains("@")) return false;
		
		Pattern emailPattern = Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
		
		Matcher emailMatcher = emailPattern.matcher(email);
		
		return emailMatcher.matches();
	}
	
	public boolean isValidName(String name) {
		return true;
	}
	/**
	 * 비밀번호 유효성 판단을 위한 method
	 * 
	 * @param passWord
	 * @return 	 0 PW_VALID - 유효함
	 * 		   	 1 PW_ERROR_LENGTH - 길이 오류
	 *           2 PW_ERROR_SPACE  - 공백포함 오류
	 *           3 PW_ERROR_CHAR   - 숫자, 영문, 특수문자 모두포함 관련 오류 
	 */
	public int isValidPassWord(String passWord) {
		
		Pattern hasSpace = Pattern.compile("\\s");
		Pattern hasNum = Pattern.compile("[0-9]");
		Pattern hasEng = Pattern.compile("[a-zA-Z]");
		Pattern hasSpe = Pattern.compile("[`~!@#$%^&*;:/?\'\"\\|]");
		
		
		if(passWord.length() < 8 || passWord.length() > 20) {
			return PW_ERROR_LENGTH;
		}else if(hasSpace.matcher(passWord).matches()) {
			return PW_ERROR_SPACE;
		}else if(!(hasNum.matcher(passWord).find() &&
				hasEng.matcher(passWord).find() &&
				hasSpe.matcher(passWord).find())){
			//System.out.println(passWord + hasNum.matcher(passWord).find() + " " +
			//		hasEng.matcher(passWord).find() + " " +
			//		hasSpe.matcher(passWord).find());
			return PW_ERROR_CHAR;
		}
		
		return PW_VALID;
	}
	
	
}
