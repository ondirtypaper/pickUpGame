package dataManager;

import java.awt.geom.Point2D;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Random;

public class DataManager {

	public static final int PW_VALID = 0;
	public static final int PW_ERROR_LENGTH = 1;
	public static final int PW_ERROR_SPACE = 2;
	public static final int PW_ERROR_CHAR = 3;
	
	public static final int LOG_IN_SUCCESS = 0;
	public static final int LOG_IN_WRONG_PW = -1;
	public static final int LOG_IN_WRONG_EMAIL = -2;
	public static final int LOG_IN_CANT_FIND_DB = -3;
	
	public static final String USER_DATA_BASE = "data/user.data";
	
	ArrayList<User> regList;
	ArrayList<ActiveUser> activeList;
	
	
	
	public DataManager(){
		regList = new ArrayList<User>();
		initRegList();
		for (User u : regList) {
			System.out.println(u.getEmail() + ", " + u.getName() + ", " + u.getPassWord());
		}
		activeList = new ArrayList<ActiveUser>();
	}
	public int logInRequest(String email, String passWord) {
		if(regList.size() == 0) return LOG_IN_CANT_FIND_DB;
			
		for(int i=0; i < regList.size() ; i++) {
			if(regList.get(i).getEmail().equals(email)) {
				if(regList.get(i).getPassWord().equals(passWord)) {
					//return LOG_IN_SUCCESS;
					return i;
				}
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
		/**
		 * File out
		 */
		saveRegList();
		
		return true;
	}
	/**
	 * 현재 가입된 회원 전체를 파일 user.data에 mapping하는 method
	 */
	private void saveRegList() {
		File f = new File(USER_DATA_BASE);
		try (FileOutputStream fos = new FileOutputStream(f, false);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			for(User u : regList) {
				oos.writeObject(u);
			}
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("file out failed");
			}
	}
	/**
	 * 현재 가입된 회원 전체를 파일로부터 불러와 regList에 mapping하는 method
	 */
	private void initRegList() {
		File f = new File(USER_DATA_BASE);
		Object data = new Object();
		try(FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			System.out.println("dataManager : " + f.toString() + "file found successfully");
			while(true) {
				try {
					data = ois.readObject();
					
					User u = (User)data;
					if(regList.add(u)) System.out.println("dataManager : " + u.getEmail() + " data is just read from file.");
				} catch (EOFException e) {
					ois.close();
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
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
	/**
	 * 
	 */
	public User getRegUser(int index) {
		return regList.get(index);
	}
	
	/**
	 * Test를 위한 Active User 생성 method
	 */
	public void initForTest() {
		Random r = new Random();
		// Test를 위한 Fake Active Users 생성...
		for(int i = 0; i < 10 ; i++) {
			ActiveUser u = new ActiveUser("testid" + i, "test" + i + "@test.com", "testpass11!!");
			Position p = new Position();
			p.setLocation( (r.nextDouble()-0.5)*600.0, (r.nextDouble()-0.5)*600.0 );
			u.setCurrentLocation(p);
			u.setFavoriteCourtId(-1);
			activeList.add(u);
			//System.out.println("dataManeger : " + activeList.get(i).getCurrentLocation().getX());
			
		}
	}
	/**
	 * 해당 위치 주변의 Active User list를 반환하는 method
	 */
	public ArrayList<ActiveUser> getAroundActvieUser(Position p){
		ArrayList<ActiveUser> rList = new ArrayList<ActiveUser>();
		//System.out.println("dataManager : getAroundActiveUser > " + p.x + ", " + p.y);
		for(ActiveUser a : activeList) {
			// Just For Test
			makeMoveActiveUserForDemo(a);
			if(p.getDistance(a.getCurrentLocation()) < 300.0) {
				rList.add(a);
				//System.out.println("dataManager : aroundActiveUser Found" + a.getName());
			}
		}
		return rList;
	}
	/**
	 * 
	 */
	public void makeMoveActiveUserForDemo(ActiveUser au) {
		Random r  = new Random();
		
		double x = au.getCurrentLocation().getX();
		double y = au.getCurrentLocation().getY();
		
		au.setCurrentLocation(x + (r.nextDouble()-0.5)*10, y + (r.nextDouble()-0.5)*10 );
	}
}
