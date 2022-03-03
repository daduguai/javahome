package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*之字形遍历二叉树*/
public class L103_ZigzagLevelTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int direct = 1;
        int len = 1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (direct == 1) {
                TreeNode temp = queue.pollFirst();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }
            } else {
                TreeNode temp = queue.pollLast();
                list.add(temp.val);
                if (temp.right != null) {
                    queue.addFirst(temp.right);
                }
                if (temp.left != null) {
                    queue.addFirst(temp.left);
                }
            }
            len--;
            if (len == 0) {
                len = queue.size();
                direct = -1 * direct;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }
    public static void main(String[]args){
        TreeNode root=new TreeNode(3);
        TreeNode node1=new TreeNode(9);
        TreeNode node2=new TreeNode(20);
        TreeNode node3=new TreeNode(15);
        TreeNode node4=new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        zigzagLevelOrder(root);
    }
}
