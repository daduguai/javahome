package leetcode;
/*连续子数组成绩小于k的子数组个数*/
public class L713_SubArrayProduct {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums==null){
            return 0;
        }
        int res=0,mul=1;
        int i=0,j=0;
        while(i<nums.length&&j<nums.length){
            if(nums[j]>=k){
                j++;
                i=j;
                mul=1;
            }else{
                if(mul*nums[j]>=k){
                    mul=mul/nums[i];
                    i++;
                }else{
                    res=res+j-i+1;
                    mul=mul*nums[j];
                    j++;
                }
            }
        }
        return res;
    }
}
