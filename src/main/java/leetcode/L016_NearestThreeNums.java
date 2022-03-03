package leetcode;

import java.util.Arrays;

/*最近target的三数之和*/
public class L016_NearestThreeNums {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<1){
            return -1;
        }
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int res=-1;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                int gap=sum-target;
                if(gap==0){
                    return target;
                }
                if(gap>0){
                    k--;
                    if(gap<diff){
                        diff=gap;
                        res=sum;
                    }
                }else{
                    j++;
                    if(-1*gap<diff){
                        diff=-1*gap;
                        res=sum;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[]args){
        int[] nums={-1,2,1,-4};
        threeSumClosest(nums,1);
    }
}
