package leetcode;
/*移除元素*/
public class L027_RemoveElement {
    public int[] removeElement(int[]nums,int val){
        if(nums==null&&nums.length<1){
            return nums;
        }
        if(nums.length==1&&nums[0]==val){
            nums[0]=0;
            return nums;
        }
        int cur=0,pre=0;
        while(cur<nums.length){
            if(nums[cur]!=val){
                nums[pre]=nums[cur];
                pre++;
            }
            cur++;
        }
        return nums;
    }
}
