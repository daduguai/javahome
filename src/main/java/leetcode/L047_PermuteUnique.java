package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*全排列II--有重复元素*/
public class L047_PermuteUnique {
    public static List<List<Integer>> permuteUnique(int[]nums){
        List<List<Integer>> res=new ArrayList<>();
        boolean[]flag=new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res,new ArrayList<>(),0,flag,nums);
        return res;
    }
    public static void dfs(List<List<Integer>> res,List<Integer>cur,int idx,boolean[]flag,int[]nums ){
        if(idx==flag.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<flag.length;i++){
            if(i-1>=0&&nums[i]==nums[i-1]&&!flag[i-1]||flag[i]){
                continue;
            }
            if(!flag[i]){
                cur.add(nums[i]);
                flag[i]=true;
                dfs(res,cur,idx+1,flag,nums);
                flag[i]=false;
                cur.remove(cur.size()-1);
            }
        }
    }
    public static void main(String[]args){
        int[]nums={1,1,2};
        List<List<Integer>> res=permuteUnique(nums);
    }
}
