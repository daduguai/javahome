package leetcode;

import java.util.ArrayList;
import java.util.List;

/*获取所有子集*/
public class L078_Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        if(nums==null){
            return res;
        }
        getSub(nums,nums.length,res);
        return res;
    }

    void getSub(int[]nums,int length,List<List<Integer>>res){
        if(length==0){
            List<Integer>t=new ArrayList<>();
            res.add(t);
            return;
        }
        for(int i=0;i<length;i++){
            List<Integer>temp=new ArrayList<>();
            //.add(res.get(i));
            res.get(i).add(nums[length-1]);
        }
        getSub(nums,length-1,res);

    }

    static List<List<Integer>> getSubSet(int[]nums){
        if(nums==null||nums.length<1){
            return new ArrayList<>();
        }
        int len=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        for(int mask=0;mask<(1<<len);mask++){
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<len;i++){
                if((mask&(1<<i))!=0){
                    temp.add(nums[i]);
                }
            }
            res.add(temp);
        }
        return res;
    }
    public static void main(String[]args){
        int[]nums={1,2,3};
        getSubSet(nums);
    }
}
