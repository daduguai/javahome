package leetcode;

public class TwoSum_2_03 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        int flag = 0;//记录是否有进位
        ListNode rec = new ListNode();
        while (l1 != null && l2 != null) {
            int temp = (l1.val + l2.val + flag) % 10;//求当前位的值
            flag = (l1.val + l2.val + flag) / 10;//是否有进位
            l1.val = temp;
            if (l1.next == null) {
                rec = l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            rec.next = l2;
            while (l2 != null) {
                int temp = (l2.val + flag) % 10;
                flag = (l2.val + flag) / 10;
                l2.val = temp;
                if (l2.next == null && flag == 1) {
                    ListNode tail = new ListNode();
                    tail.val = flag;
                    l2.next = tail;
                    break;
                }
                l2 = l2.next;
            }
        } else if (l2 == null && l1 != null) {
            while (l1 != null) {
                int temp = (l1.val + flag) % 10;
                flag = (l1.val + flag) / 10;
                l1.val = temp;
                if (l1.next == null && flag == 1) {
                    ListNode tail = new ListNode();
                    tail.val = flag;
                    l1.next = tail;
                    break;
                }
                l1 = l1.next;
            }
        } else if (l1 == null && l2 == null && flag == 1) {
            ListNode tail = new ListNode();
            tail.val = flag;
            rec.next = tail;
        }
        return p1;
    }

    /*
    * [2,4,3]
      [5,6,4]*/
    public static void main(String[] args) {
        ListNode t = new ListNode();
        t.val =2;
        ListNode t1 = new ListNode();
        t1.val =4;
        ListNode t2 = new ListNode();
        t2.val =3;
        t1.next=t2;
        t.next=t1;

        ListNode tt = new ListNode();
        tt.val =5;
        ListNode tt1 = new ListNode();
        tt1.val =6;
        ListNode tt2 = new ListNode();
        tt2.val =4;
        tt1.next=tt2;
        tt.next=tt1;

        ListNode res=addTwoNumbers(t,tt);

    }
}
