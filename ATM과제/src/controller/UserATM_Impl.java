package controller;


import model.BankAccount;
import model.User;
import view.MenuImpl;

public class UserATM_Impl implements UserATM{

	public int accountNumber; // 계좌번호
	public String userName; // 회원 이름
	public static String userId; // 회원 아이디
	public String userPw; // 회원 비번
	
	public String bank; // 계좌조회 , 영수증 변수
	public int balance; // 계좌잔액
	
	
	MenuImpl menu = MenuImpl.getInstance();
	
private static UserATM_Impl userImpl = new UserATM_Impl();
public static UserJoin_Impl userJoin = new UserJoin_Impl();
	
	public static UserATM_Impl getInstance() {
		if(userImpl == null) {
			userImpl = new UserATM_Impl();
		}
		return userImpl;
	}
	
	public UserATM_Impl(int accountNumber, String userName, String userId, String userPw) {
		// 로그인한 회원의 계좌 인스턴스를 생성할 때 필요한 값
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
	}
	public UserATM_Impl(){}

	
	@Override
	public void userBalance() {
		this.bank = "Receipt";		
		userReceipt();
	}

	@Override
	public void userWithdraw() {
		System.out.println(userId);
		System.out.print("출금하실 금액을 입력 [취소:0] :");
		try {
		int money = MenuImpl.scan.nextInt();
		if(money <= 0) {
			System.out.println("금액을 확인해주세요.");
			return;
		}
		accountNumber = User.userMap.get(userId).getAccountNumber();
		userName = User.userMap.get(userId).getUserName();							
		balance = BankAccount.bankMap.get(accountNumber).getBalance();
		if(money > balance) {
			System.out.println("잔액이 모자랍니다.");
			return;
		}
		BankAccount bank = new BankAccount(accountNumber,userName,balance-money);
		BankAccount.bankMap.put(accountNumber,bank);
		userReceipt();
		bank.setBankFile();
		}catch(Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}		
	}

	@Override
	public void userDeposit() {
		
		System.out.print("입금하실 금액을 입력 [취소:0] :");
		try {
		int money = MenuImpl.scan.nextInt();
		if(money <= 0) {
			System.out.println("금액을 확인해주세요.");
			return;
		}		
		accountNumber = User.userMap.get(userId).getAccountNumber();
		userName = User.userMap.get(userId).getUserName();							
		balance = BankAccount.bankMap.get(accountNumber).getBalance();
		
		BankAccount bank = new BankAccount(accountNumber,userName,money+balance);
		BankAccount.bankMap.put(accountNumber,bank);
		userReceipt();
		bank.setBankFile();
		}catch(Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}	
	}

	@Override
	public void userTransfer() {
		
		System.out.println("입금하실 계좌를 입력하세요.");
		try {
			int account = menu.scan.nextInt();
			boolean check = false;
			for(int key:BankAccount.bankMap.keySet()) {			
				if(account == (BankAccount.bankMap.get(key).getAccountNumber())) {
					check = true; break;		
				}
			}
			if(check == false) {
				System.out.println("계좌번호를 확인해주세요."); return;
			}
			
			String name = BankAccount.bankMap.get(account).getUserName();
			System.out.println("");
			System.out.println("  ┏━━━━*Transfer━━━━┓");
			System.out.println("  ┃                 *");
			System.out.println("  ┃ 받으실분의 계좌 :" + account);
			System.out.println("  ┃ 받으실분의 성함 :" + name);
			System.out.println("  ┃ ");
			System.out.println("  ┃                 *");
			System.out.println("  ┗━━━━━━━━━━━━━━━━━┛\n");
			System.out.print("입금하실 금액을 입력 [취소:0] :");
			try {
			int money = MenuImpl.scan.nextInt();
			this.accountNumber = User.userMap.get(userId).getAccountNumber();
			this.userName = User.userMap.get(userId).getUserName();							
			this.balance = BankAccount.bankMap.get(accountNumber).getBalance();
			
			if(money <= 0 || money > balance) {
				System.out.println("금액을 확인해주세요.");
				return;
			}
			int cash = BankAccount.bankMap.get(account).getBalance();
			BankAccount bank = new BankAccount(account,name,cash + money);
			BankAccount.bankMap.put(accountNumber,bank);
			bank.setBankFile();
			
			
			BankAccount bank2 = new BankAccount(accountNumber,userName,balance - money);
			BankAccount.bankMap.put(accountNumber,bank2);	
			bank2.setBankFile();
			
			userReceipt();
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				return;
			}	
		
		}catch(Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
		System.out.println();
		menu.userView();
		
	}

	@Override
	public void userReceipt() {
		this.accountNumber = User.userMap.get(userId).getAccountNumber();
		this.userName = User.userMap.get(userId).getUserName();							
		this.balance = BankAccount.bankMap.get(accountNumber).getBalance();
		
		
		this.bank = "Receipt";
		System.out.println("");
		System.out.println("  ┏━━━━* "+bank+"━━━━┓");
		System.out.println("  ┃                 *");
		System.out.println("  ┃ 계좌번호 : A"+accountNumber);
		System.out.println("  ┃    성함 : "+userName);
		System.out.println("  ┃    잔액 : "+balance+"원");
		System.out.println("  ┃ ");
		System.out.println("  ┃ 0) 확인 ");
		System.out.println("  ┃                 *");
		System.out.println("  ┗━━━━━━━━━━━━━━━━━┛\n");
		
		String sel = MenuImpl.scan.next();
		if(sel.equals("0")) return;
	
	}

}
