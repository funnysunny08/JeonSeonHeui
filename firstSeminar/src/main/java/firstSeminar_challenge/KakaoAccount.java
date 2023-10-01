package firstSeminar_challenge;

public class KakaoAccount implements BankAccount {
    private String userName;
    private String accountNumber;
    private int balance;

    @Override
    public void deposit(int money) { // 입금
        this.balance += money;
        System.out.println("카카오뱅크로 " + money + "원이 입급되었습니다.");
    }

    @Override
    public void withdraw(int money) {
        if (this.balance < money) {
            System.out.println("잔액부족으로 출금이 실패하였습니다.");
        } else {
            this.balance -= money;
            System.out.println("카카오뱅크에서 " + money + "원이 출금되었습니다.");
        }
    }

    @Override
    public void getBalance() {
        System.out.println("현재 카카오뱅크 잔액은 " + this.balance + "원입니다.");
    }

    public KakaoAccount(String userName, String accountNumber, int balance) {
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public KakaoAccount(String userName, String accountNumber) {
        this(userName, accountNumber, 0);
    }
}
