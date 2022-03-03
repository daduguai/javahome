package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L039_Combination {
    public List<List<Integer>> combination(int[]candidates,int target) {
        List<List<Integer>>res=new ArrayList<>();
        dfs(res,new ArrayList<Integer>(),candidates,0,target);
        return res;
    }

    public void dfs(List<List<Integer>>res,List<Integer>combinates,int[]candidates,int idx,int target){
        if(idx>=candidates.length){
            return;
        }
        if(target==0){
            res.add(new ArrayList<Integer>(combinates));
            return;
        }
        dfs(res,combinates,candidates,idx+1,target);
        if(target-candidates[idx]>=0){
            combinates.add(candidates[idx]);
            dfs(res,combinates,candidates,idx,target-candidates[idx]);
            combinates.remove(combinates.size()-1);
        }
    }
}
