package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class L111_MinHeight {
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int res=0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            res++;
            for(int i=0;i<len;i++){
                TreeNode t=queue.poll();
                if(t.left==null&&t.right==null){
                    return res;
                }
                if(t.left!=null){
                    queue.offer(t.left);
                }
                if(t.right!=null){
                    queue.offer(t.right);
                }
            }

        }
        return res;
    }
}
