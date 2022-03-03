package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*三数之和*/
/*
* 方法：双指针，防重*/
public class L015_ThreeDataSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        if(nums==null||nums.length<3){
            return res;
        }
        Arrays.sort(nums);//排序
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }
            if(nums[i]>0){
                break;
            }
            int L=i+1,R=nums.length-1;
            while(L<R){
                int sum=nums[i]+nums[L]+nums[R];
                if(sum==0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[L]);
                    temp.add(nums[R]);
                    res.add(temp);
                    while(L<R&&nums[L+1]==nums[L]){
                        L++;
                    }
                    while(L<R&&nums[R]==nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }else if(sum<0){
                    L++;
                }else {
                    R--;
                }
            }
        }
        return res;
    }
}
