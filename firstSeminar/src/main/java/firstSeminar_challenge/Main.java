package firstSeminar_challenge;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new KakaoAccount("써니", "302-0123-9122-11", 30000);
        account1.withdraw(1000000000);
        account1.deposit(1);
        account1.withdraw(2000);
    }
}
