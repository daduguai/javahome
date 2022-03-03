package leetcode;

public class L019_DeleteKthLinkedNode {
    public static LinkedNode deleteKthNode(LinkedNode root,int k){
        if(root==null){
            return root;
        }
        LinkedNode pre=root,cur=root,p=root;
        int i=0;
        while(p!=null){
            if(i<k){
                i++;
                p=p.next;
            }else{
                i++;
                p=p.next;
                pre=cur;
                cur=cur.next;
            }
        }
        if(i==k){
            root=root.next;
        }else{
            pre.next=cur.next;
            cur=null;
        }
        return root;
    }
}
