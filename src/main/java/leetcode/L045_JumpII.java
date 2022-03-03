package leetcode;
/*跳跃游戏2*/
public class L045_JumpII {
    int jump(int[]nums){
        int res=0;
        int maxPos=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            maxPos=Math.max(nums[i]+i,maxPos);
            if(i==end){
                end=maxPos;
                res++;
            }
        }
        return res;
    }
}
