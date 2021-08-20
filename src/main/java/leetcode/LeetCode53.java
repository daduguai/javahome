package leetcode;

import utils.Print;

/**
 * 最大子序和
 */
public class LeetCode53 {
    public static int maxSubArray(int[] nums) {
        int maxSum;
        maxSum = nums[0];
        int[] s = new int[nums.length];
        s[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (s[i - 1] >= 0) {
                s[i] = s[i - 1] + nums[i];
            } else {
                s[i] = nums[i];
            }
            if (s[i] >= maxSum) {
                maxSum = s[i];
            }
        }
        Print.println(maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        //int[] data=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //int[] data=new int[]{-2};
        int[] data=new int[]{5,4,-1,7,8};
        maxSubArray(data);
    }
}
