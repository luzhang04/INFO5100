package Assignment7;
class SumThread extends Thread {
    private int[] arr;
    private int start, end;
    private long sum;

    SumThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    public void run() {
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
    }
    public long getSum() {
        return sum;
    }
}

public class SumValue {

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        SumThread st1 = new SumThread(arr, 0, 1000000);
        SumThread st2 = new SumThread(arr, 1000000, 2000000);
        SumThread st3 = new SumThread(arr, 2000000, 3000000);
        SumThread st4 = new SumThread(arr, 3000000, 4000000);
        st1.run();
        st2.run();
        st3.run();
        st4.run();
        // System.out.println(st1.getSum() + " " + st2.getSum() + " " + st3.getSum() + " " + st4.getSum());
        return st1.getSum() + st2.getSum() + st3.getSum() + st4.getSum();
    }

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}
