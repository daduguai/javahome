package leetcode;
/*打家劫舍II*/
public class L213_Rob {
    public int rob(int[] nums) {
        int res=0;
        if(nums==null){
            return res;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length==3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }
        res=Math.max(getWealth(nums,0,nums.length-2),getWealth(nums,1,nums.length-1));
        return res;
    }
    int getWealth(int[]nums,int start,int end){
        int[]res=new int[end-start+1];

        for(int i=start;i<=end;i++){
            if(i==start){
                res[i-start]=nums[i];
            }else if(i==start+1){
                res[i-start]=Math.max(nums[start],nums[i]);
            }else{
                res[i-start]=Math.max(res[i-start-1],res[i-start-2]+nums[i]);
            }
        }
        return res[end-start];
    }
}
