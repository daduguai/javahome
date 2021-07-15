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

    public List getIndex(int[]nums,int target){
        List<Integer>res=new ArrayList<>(2);
        HashMap<Integer,Integer>data=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            data.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(data.containsKey(target-nums[i])){
                res.add(i);
                res.add(data.get(target-nums[i]));//获取key对应的value
            }
        }
        return res;
    }
}
