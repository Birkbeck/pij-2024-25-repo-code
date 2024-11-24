package pij.day17.bankAccount;

public class BankAccount {
    private int balanceInPence;

    public int getBalanceInPence() {
        return this.balanceInPence;
    }

    public void deposit(int moneyInPence) {
        this.balanceInPence = this.balanceInPence + moneyInPence;
    }

    public int retrieve(int moneyInPence) {
        int result = 0;
        if (this.balanceInPence > moneyInPence) {
            result = moneyInPence;
        } else {
            result = this.balanceInPence;
        }
        this.balanceInPence = this.balanceInPence - result;
        return result;
    }
}
