package Assignment8;

// Give a very large array of integers, find the maximum value within the array using multithreading.

public class MaxValue {

    static int[] generateRandomArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    static int max(int[] arr) {
        MaxThread st1 = new MaxThread(arr, 0, 1000000);
        MaxThread st2 = new MaxThread(arr, 1000000, 2000000);
        MaxThread st3 = new MaxThread(arr, 2000000, 3000000);
        MaxThread st4 = new MaxThread(arr, 3000000, 4000000);
        st1.run();
        st2.run();
        st3.run();
        st4.run();
        return Math.max(Math.max(st1.getMax(), st2.getMax()), Math.max(st3.getMax(), st4.getMax()));
    }

    public static void main(String[] args) {
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        int max = max(arr);
        System.out.println("maximum value " + max);
    }
}

    class MaxThread extends Thread {
        private int[] arr;
        private int start, end;
        public int max;

        MaxThread(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }

        public int getMax() {
            return max;
        }

    }

