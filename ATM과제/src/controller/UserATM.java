package controller;

public interface UserATM {
	

	public void userBalance(); //잔액확인
	public void userWithdraw(); //출금
	public void userDeposit(); //입금
	public void userTransfer(); //계좌이체
	public void userReceipt(); //영수증
}