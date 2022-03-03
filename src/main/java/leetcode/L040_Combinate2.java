package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给定一个候选人编号的集合 candidates 和一个目标数 target ，
找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次 
*/
public class L040_Combinate2 {
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), 0, target, nums);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> cur, int idx, int target, int[] nums) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(target-nums[i]<0){
                return;
            }
            if(i>idx&&nums[i]==nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            dfs(res,cur,i+1,target-nums[i],nums);
            cur.remove(cur.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        combinationSum2(nums, 8);
    }
}
