package leetcode;

public class L026_RemoveDuplicates {
    public int removeDuplicates(int[]nums){
        if(nums==null){
            return -1;
        }
        int pre=0,cur=1;
        for(;cur<nums.length;cur++){
            if(nums[pre]!=nums[cur]){
                nums[++pre]=nums[cur];
            }
        }
        return pre+1;
    }
}
