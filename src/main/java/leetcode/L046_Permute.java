package leetcode;

import java.util.ArrayList;
import java.util.List;

/*全排列*/
public class L046_Permute {
    List<List<Integer>> permute(int[]nums){
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length<=0){
            return res;
        }
        boolean[]used=new boolean[nums.length];
        dfs(res,used,0,new ArrayList<>(),nums);
        return res;
    }
    public void dfs(List<List<Integer>>res,boolean[]used,int idx,List<Integer>cur,int[]nums){
        if(idx==used.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0;i<used.length;i++){
            if(!used[i]){
                cur.add(nums[i]);
                used[i]=true;
                dfs(res,used,idx+1,cur,nums);
                used[i]=false;
                cur.remove(cur.size()-1);
            }
        }
    }
}
