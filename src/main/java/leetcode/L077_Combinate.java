package leetcode;

import java.util.ArrayList;
import java.util.List;

/*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合*/
public class L077_Combinate {
    static List<List<Integer>> combinate(int n, int k){
        List<List<Integer>>res =new ArrayList<>();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        dfs(res,new ArrayList<Integer>(),0,k,n,nums);
        return res;
    }
    static public void dfs(List<List<Integer>>res,List<Integer>cur,int idx,int k,int n,int[]nums){
        if(cur.size()==k){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(idx<n){
            cur.add(nums[idx]);
            dfs(res,cur,idx+1,k,n,nums);
            cur.remove(cur.size()-1);
            dfs(res,cur,idx+1,k,n,nums);
        }

    }
    public static void main(String[]args){
        int n=4,k=3;
        combinate(n,k);
    }
}
