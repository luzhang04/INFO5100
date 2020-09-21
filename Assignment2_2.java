/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

public class Assignment2_2 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     * <p>
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * <p>
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    public int maxSubArray(int[] nums) {
        int maxNow = Integer.MIN_VALUE, maxEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            maxEnd = maxEnd + nums[i];
            if (maxNow < maxEnd) {
                maxNow = maxEnd;
            }
            if (maxEnd < 0) {
                maxEnd = 0;
            }
        }
        return maxNow;

    }

    public static void main(String[] args) {
        Assignment2_2 assignment2_2 = new Assignment2_2();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(assignment2_2.maxSubArray(nums));
    }
}
