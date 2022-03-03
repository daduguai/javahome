package leetcode;

public class L026_RemoveDuplicate {
    int removeDuplicate(int[] nums){
        if(nums==null||nums.length<1){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                i++;
                while(i<nums.length){
                    if(nums[i]!=nums[index]){
                        nums[++index]=nums[i];
                        break;
                    }
                    i++;
                }
            }
        }
        return index+1;
    }
}
