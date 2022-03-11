package model;

import java.util.HashMap;
import java.util.Map;

public class User {

	public static Map<Integer, User> userMap = new HashMap<Integer, User>();
	private int accountNumber; // 계좌번호 - random 번호
	private String userId; // 아이디
	private String userPw; // 비번
	private String userName; // 이름

	public static Map<Integer, User> getUserMap() {
		return userMap;
	}

	public static void setUserMap(Map<Integer, User> userMap) {
		User.userMap = userMap;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

}
