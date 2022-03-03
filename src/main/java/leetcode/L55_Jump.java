package leetcode;
/*跳跃游戏*/
public class L55_Jump {
    public static boolean canJump(int[] nums) {
        if(nums==null){
            return false;
        }
        if(nums.length==1){
            return true;
        }
        boolean[] jump=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                jump[i]=true;
            }else{
                int j=i-1;
                while(j>=0){
                    if(jump[j]&&nums[j]+j>=i){
                        jump[i]=true;
                        break;
                    }else{
                        j--;
                    }
                }
            }
        }
        return jump[nums.length-1];
    }
    public static void main(String[]args){
        int[] nums={2,3,1,1,4};

        canJump(nums);
    }
}
