package leetcode;

import java.util.HashMap;
import java.util.Map;

/*给定先序和中序，构建二叉树*/
public class L105_PreMidOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null && inorder == null) {
            return new TreeNode();
        }
        if (preorder.length == 1 || inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        Map<Integer, Integer> map = new HashMap();//记录中序遍历数组的值与索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    TreeNode create(int[] pre, int p_l, int p_r, int[] mid, int m_l, int m_r, Map map) {
        if ((p_l == p_r) && p_l < pre.length) {
            return new TreeNode(pre[p_l]);
        }
        TreeNode root = new TreeNode(pre[p_l]);
        int index = (int) map.get(pre[p_l]);
        int len = index - p_l;
        TreeNode left = create(pre, p_l + 1, index - 1, mid, m_l, m_r, map);
        TreeNode right = create(pre, index + 1, index - 1, mid, m_l, m_r, map);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode tree = create2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,map);
        return tree;
    }

    TreeNode create2(int[] pre, int p_l, int p_r, int[] mid, int m_l, int m_r,Map map) {
        int len = p_r - p_l + 1;
        TreeNode root = new TreeNode();
        if (len == 1) {
            root.val = pre[p_l];
            return root;
        }
        if (len == 2) {
            TreeNode temp = new TreeNode();
            if (pre[p_l] == mid[m_l]) {
                temp.val = pre[p_r];
                root.val = pre[p_l];
                root.right = temp;
            } else {
                root.val = pre[p_l];
                temp.val = mid[p_r];
                root.left = temp;
            }
            return root;
        }

        int index=(int)map.get(pre[p_l]);//获取头节点在中序数组中的坐标
        int t=index-m_l;
        root.left=create2(pre,p_l+1,p_l+t,mid,m_l,index-1,map);
        root.right=create2(pre,p_l+t+1,p_r,mid,index+1,m_r,map);
        return root;
    }


}