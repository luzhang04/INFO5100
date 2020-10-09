package Assignment4;


import java.util.Arrays;


public class KthLargestElement {
    public int kthLargestElement(int[] num, int k) {
        int res = 0;
        if (k >= 1 && k <= num.length) {
            Arrays.sort(num);
            res = num[num.length - k];
        } else {
            res = -1;
        }
        return res;
    }
}
