package Assignment8;

public class BankAccount {
    private double balance;
    private final Object LOCK = new Object();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    private void deposit(int amount) throws InterruptedException {
        synchronized (LOCK) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " Deposit amount: $"
                    + amount + " New balance: $" + balance);
            Thread.sleep(1000);
        }
    }

    private void withdraw(int amount) throws InterruptedException {
        synchronized (LOCK) {
            if (balance < amount) {
                System.out.println(Thread.currentThread().getName() + " cannot withdraw $"
                        + amount + " because of low balance");
            }else {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " Withdraw amount: $"
                        + amount + " New balance: $" + balance);
                Thread.sleep(1000);
            }
        }
    }

    private double getBalance() {
        synchronized (LOCK) {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(0);
        BankAccount ba2 = new BankAccount(0);
        BankAccount ba3 = new BankAccount(0);

        Thread t1 = new Thread(()->{

            ba1.getBalance();
            try {
                ba1.deposit((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                ba1.withdraw((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ba1.getBalance();

        });
        Thread t2 = new Thread(()->{

            ba2.getBalance();
            try {
                ba2.deposit((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                ba2.withdraw((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ba2.getBalance();

        });
        Thread t3 = new Thread(()->{

            ba3.getBalance();
            try {
                ba3.deposit((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                ba3.withdraw((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ba3.getBalance();

        });

        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e ){
            e.printStackTrace();
        }
    }
}

