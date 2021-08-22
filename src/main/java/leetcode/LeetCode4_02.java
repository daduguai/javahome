package leetcode;

/**
 * 两个正序数组的中位数
 */
public class LeetCode4_02 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid1 = nums1.length / 2;
        int mid2 = nums2.length / 2;
        int k = (nums1.length + nums2.length) / 2;
        int odd = (nums1.length + nums2.length) % 2;
        while (k > 0) {
            if (nums1[mid1] < nums2[mid2]) {

            }
            return 0;
        }
        return 0;
    }
}
/**
 * 采用类似于二分查找方法，时间复杂度O(log(m+n)),空间复杂度O(1)
 */