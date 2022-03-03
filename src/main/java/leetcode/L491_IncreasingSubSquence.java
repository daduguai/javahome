package leetcode;

import java.util.ArrayList;
import java.util.List;

/*递增子序列*/
public class L491_IncreasingSubSquence {
    static List<List<Integer>> subSequence(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<Integer>(), Integer.MIN_VALUE);
        return res;
    }

    public static void dfs(int[] nums, int idx, List<List<Integer>> list, List<Integer> cur, int last) {
        if (idx == nums.length) {
            if (cur.size() >= 2) {
                list.add(new ArrayList<Integer>(cur));
            }
            return;
        }

        if (nums[idx] >= last) {
            cur.add(nums[idx]);
            dfs(nums, idx + 1, list, cur, nums[idx]);
            cur.remove(cur.size() - 1);
        }
        if (nums[idx] != last)
            dfs(nums, idx + 1, list, cur, last);
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        subSequence(nums);
    }
}
