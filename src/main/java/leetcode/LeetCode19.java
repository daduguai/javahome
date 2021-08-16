package leetcode;

import utils.Print;

import java.util.List;

/**给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

 进阶：你能尝试使用一趟扫描实现吗*/
public class LeetCode19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        if(head.next==null&&n==1){
            return null;
        }
        if(n<=0){
            return null;
        }
        int i=1;
        ListNode p=head;
        ListNode post=head;
        ListNode pre=head;
        while(p!=null){
            if(i<=n){
                p=p.next;
            }else{
                p=p.next;
                pre=post;
                post=post.next;
            }
            i++;
        }
        if(post==head){
            head=head.next;
        }else{
            pre.next=post.next;
            post=null;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode head=new ListNode(1);
        ListNode p=new ListNode(2);
//        ListNode p1=new ListNode(3);
//        ListNode p2=new ListNode(4);
//        ListNode p3=new ListNode(5);
//        p3.next=null;
//        p2.next=p3;
//        p1.next=p2;
//        p.next=p1;
        head.next=p;
        ListNode t=head;
        while(t!=null){
            Print.println(t.val);
            t=t.next;
        }
        removeNthFromEnd(head,2);

        t=head;
        while(t!=null){
            Print.println(t.val);
            t=t.next;
        }


    }
}
