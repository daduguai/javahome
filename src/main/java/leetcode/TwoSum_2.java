package leetcode;

import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class TwoSum_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode tail = null;
        int flag = 0;
        while (l1 != null && l2 != null) {
            if (tail == null) {
                int data = l1.val + l2.val;
                ListNode t = new ListNode();
                if (flag >= 10) {
                    t.val = data - 10;
                    flag = 1;
                } else {
                    t.val = data;
                }
                t.next = null;
                tail = t;
                head.next = tail;
            }else{
                ListNode t = new ListNode();
                t.next=null;
                int data=l1.val+l2.val+flag;
                if(data>=10){
                    t.val=data-10;
                    flag=1;
                }else{
                    t.val=data;
                    flag=0;
                }
                tail.next=t;
                tail=tail.next;

            }
            l1=l1.next;
            l2=l2.next;

        }
        ListNode f=new ListNode();
        if(l1==null&&l2!=null){
            while(l2!=null){
                int t=l2.val+flag;
                if(t>=10){
                    flag=1;
                    ListNode temp=new ListNode();
                    temp.val=t-10;
                    temp.next=null;
                    tail.next=temp;
                    tail=tail.next;
                }else{
                    tail.next=l2;
                }
            }

        }else if(l2==null&&l1!=null){
            while(l1!=null){
                int t=l1.val+flag;
                if(t>=10){
                    flag=1;
                    ListNode temp=new ListNode();
                    temp.val=t-10;
                    temp.next=null;
                    tail.next=temp;
                    tail=tail.next;
                }else{
                    tail.next=l1;
                }
            }
        }else{
            if(flag==1){
                ListNode t=new ListNode(1);
                t.next=null;
                tail.next=t;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}