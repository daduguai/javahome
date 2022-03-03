package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
Leetcode-102:
二叉树的层级遍历
* */
public class L102_BinaryTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode p = root;
        Queue<TreeNode>queue=new ArrayDeque();
        queue.add(p);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeNode t=queue.poll();
                temp.add(t.val);
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
            }
            res.add(temp);
        }
        return res;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
