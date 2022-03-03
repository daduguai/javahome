package leetcode;

/*删除升序链表中的重复节点*/
public class L082_DeleteDupLinkNode {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            int cur_data = cur.val;
            if (cur.next != null && cur.next.val == cur_data) {
                int next_data = cur.next.val;
                ListNode temp = null;
                while (cur != null && cur_data == next_data) {
                    temp = cur;
                    cur = cur.next;
                    if (cur != null) {
                        next_data = cur.val;
                    }
                }
                if (pre == null || pre == temp) {
                    pre = cur;
                    head = pre;
                } else {
                    pre.next = cur;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode t1 = new ListNode(2);
//        ListNode t2 = new ListNode(3);
//        ListNode t3 = new ListNode(3);
//        ListNode t4 = new ListNode(4);
//        ListNode t5 = new ListNode(4);
//        ListNode t6 = new ListNode(5);
//        head.next = t1;
//        t1.next = t2;
//        t2.next = t3;
//        t3.next = t4;
//        t4.next = t5;
//        t5.next = t6;

//        ListNode head = new ListNode(1);
//        ListNode t1 = new ListNode(2);
//        ListNode t2 = new ListNode(2);
//        head.next = t1;
//        t1.next = t2;

        ListNode head = new ListNode(1);
        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(3);
        ListNode t3 = new ListNode(3);
        head.next = t1;
        t1.next = t2;
        t2.next=t3;
        ListNode res = deleteDuplicates2(head);


    }


    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            int cur_data = cur.val;
            if(cur.next != null && cur_data == cur.next.val){
                while (cur.next!= null && cur_data == cur.next.val) {
                    cur = cur.next;
                }
                cur=cur.next;
                if(pre==null&&cur==null){
                    head=null;
                }
            }else{
                if (pre == null) {
                    pre = cur;
                    cur=cur.next;
                    pre.next=null;
                    head = pre;

                } else {
                    pre.next = cur;
                    cur = cur.next;
                    pre = pre.next;
                    pre.next=null;
                }
            }
        }
        return head;
    }
}
