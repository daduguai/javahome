package leetcode;
/*给定两棵树A,B,判断B是否为A的子树*/
public class L572_SubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null){
            return true;
        }
        if(root!=null&&subRoot!=null&&root.val==subRoot.val){
            return isSubtree(root.left,subRoot.left)&&isSubtree(root.right,subRoot.right);
        }else{

        }
        return false;
    }
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null){
            return true;
        }

        return dfs(root,subRoot);
    }

    boolean dfs(TreeNode root, TreeNode subRoot){
        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        return isSameTree(root,subRoot)||dfs(root.left,subRoot)||dfs(root.right,subRoot);
    }

    boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root==null&&subRoot==null){
            return true;
        }
        if(root==null||subRoot==null||root.val!=subRoot.val){
            return false;
        }else{
            return isSameTree(root.left,subRoot.left)&&isSameTree(root.right,subRoot.right);
        }
    }
}
