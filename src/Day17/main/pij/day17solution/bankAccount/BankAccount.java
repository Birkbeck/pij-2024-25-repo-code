package pij.day17solution.bankAccount;

public class BankAccount {
    private int balanceInPence;

    // It is debatable whether we need to make method
    // getBalanceInPence(int) synchronized. If we are okay with an outdated
    // value as a result, synchronisation of getBalanceInPence(int) despite
    // an ongoing update to the balance should not be needed. If instead we
    // prefer to wait a bit for an accurate result in this case, we need
    // to make the method synchronized.
    public /* synchronized */ int getBalanceInPence() {
        return this.balanceInPence;
    }

    // Make method deposit(int) synchronized so that no money gets
    // lost in the following scenario:
    // 1. myAccount.balanceInPence is 500
    // 2. Thread 1 calls myAccount.deposit(100)
    // 3. Thread 1 reads myAccount.balanceInPence as 500, adds 100 to get the
    //    new value 600 that will be written into myAccount.balanceInPence
    // 4. Thread 2 calls myAccount deposit(200)
    // 5. Thread 2 reads myAccount.balanceInPence as 500, adds 200 to get the
    //    new value 700 that will be written into myAccount.balanceInPence
    // 6. Thread 2 writes the value 700 into myAccount.balanceInPence
    // 7. Thread 1 writes the value 600 (which it computed earlier) into
    //    myAccount.balanceInPence
    // => The 200 pence from Thread 2 mysteriously disappear!
    //    If we make method deposit synchronized, Thread 2 must wait for the
    //    lock in Step 4; eventually, it is Thread 1's turn again, and it
    //    writes 600 into myAccount.balanceInPence; and only now does
    //    Thread 2 enter method deposit(int) to deposit 200 more (and read
    //    myAccount.balanceInPence as 600, to which 200 more are added,
    //    so we have a balanceInPence of 800 when all is done)
    public synchronized void deposit(int moneyInPence) {
        this.balanceInPence = this.balanceInPence + moneyInPence;
    }

    // Make method retrieve(int) synchronized (so with the same lock as
    // deposit(int)). Analogous to two threads running deposit(int)
    // concurrently, we can construct scenarios where two calls to
    // retrieve(int) by different threads mess up the balance, and we
    // can also construct scenarios where a thread running retrieve(int)
    // and a second thread running deposit(int) mess up the balance.
    public synchronized int retrieve(int moneyInPence) {
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
