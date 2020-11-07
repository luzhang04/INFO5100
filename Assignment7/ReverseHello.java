package Assignment7;

public class ReverseHello extends Thread {
    private int num;

    public ReverseHello(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (num > 50) {
            return;
        }
        Thread thread = new ReverseHello(num + 1);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Hello from Thread " + num);
    }

    public static void main(String[] args) {
        Thread thread = new ReverseHello(1);
        thread.start();
    }
}
