package model;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
//DTO (Data Transfer Object)

	public static Map<Integer, BankAccount> bankMap = new HashMap<Integer, BankAccount>();

	private int accountNumber; // 계좌번호
	private int accountPass; // 계좌 비밀번호
	private String userName; // 회원 이름
	private int balance; // 계좌 금액

	public BankAccount(int accountNumber, int accountPass, String userName) {
		this.accountNumber = accountNumber;
		this.accountPass = accountPass;
		this.userName = userName;
	}

	public static Map<Integer, BankAccount> getBankMap() {
		return bankMap;
	}

	public static void setBankMap(Map<Integer, BankAccount> bankMap) {
		BankAccount.bankMap = bankMap;
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

	public int getAccountPass() {
		return accountPass;
	}

	public void setAccountPass(int accountPass) {
		this.accountPass = accountPass;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// to String()
	public String toString() {

		return accountNumber + "   " + userName;

	}
}
