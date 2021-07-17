package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class TwoSum_1 {

    private int[] nums;
    private int target;

    public TwoSum_1(int[]nums,int target){
        this.nums=nums;
        this.target=target;
    }

    //用hashmap存储数组的值与下标，
    //该解法无法处理数组中含有重复元素情况
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length<=0){
            return null;
        }
        int[] res=new int[2];
        HashMap map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])&&i!=(int)map.get(nums[i])){
                res[0]=i;
                res[1]=(int)map.get(target-nums[i]);
                return res;
            }
        }
        return res;
    }
}

/*思路1：
* 空间换时间，使用hashmap存储数组值与下标，两数之和为target，则给定一个数a，另一个数即为target-a*/