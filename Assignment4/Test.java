package Assignment4;

public class Test {
    public static void main(String args[]) {
        KthLargestElement kle = new KthLargestElement();
        int[] num1 = new int[] {1, 5, 3, 7, 9, 2, 0};
        int[] num2 = new int[] {1};

        System.out.println(kle.kthLargestElement(num1,3));
        System.out.println(kle.kthLargestElement(num2,1));


    }
}
