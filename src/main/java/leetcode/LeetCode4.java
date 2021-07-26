package leetcode;

import utils.Print;

import java.util.ArrayList;
import java.util.List;

public class LeetCode4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res;
        List<Integer> merge=new ArrayList();
        int i=0,j=0;
        while(i<nums1.length||j<nums2.length){
            if(i>=nums1.length){
                merge.add(nums2[j++]);
            }else if(j>=nums2.length){
                merge.add(nums1[i++]);
            }else if(nums1[i]<=nums2[j]){
                merge.add(nums1[i++]);
            }else if(nums1[i]>nums2[j]){
                merge.add(nums2[j++]);
            }
        }
        if((nums1.length+nums2.length)%2==0){
            return (merge.get((nums1.length+nums2.length)/2)+merge.get((nums1.length+nums2.length)/2-1))/2.0;
        }else{
            return merge.get((nums1.length+nums2.length)/2);
        }
    }

    public static void main(String[] args){
        int[] data1={1,2};
        int[] data2={3,4};
        double res=findMedianSortedArrays(data1,data2);
        Print.println(res);
    }
}

/**
 * 时间复杂度O(m+n)，空间复杂度O(1)*/
