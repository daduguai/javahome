package leetcode;
/*和大于k的最短的数组*/
public class L209_MinSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums==null){
            return 0;
        }
        int sum=0,res=0;
        int i=0,j=0;
        while(i<nums.length&&j<nums.length){
            if(nums[j]>=target){
                return 1;
            }
            if(sum+nums[j]>=target){
                if(res==0){
                    res=j-i+1;
                }else{
                    res=res>j-i+1?j-i+1:res;
                }
                sum=sum-nums[i];
                i++;
            }else{
                sum=sum+nums[j];
                j++;
            }
        }
        return res;
    }
}
