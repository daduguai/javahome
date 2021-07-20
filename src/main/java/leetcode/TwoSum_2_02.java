package leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class TwoSum_2_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = null, tail = null;
        int flag = 0;

        while (l1 != null || l2 != null) {
            int data = 0;
            if (head == null) {
                data = (l1.val + l2.val) % 10;
                flag = (l1.val + l2.val) / 10;
                head = new ListNode(data, null);
                tail = head;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }

            if (l1 != null && l2 == null) {
                data = (l1.val + flag) % 10;
                flag = (l1.val + flag) / 10;
                l1 = l1.next;
            } else if (l2 != null && l1 == null) {
                data = (l2.val + flag) % 10;
                flag = (l2.val + flag) / 10;
                l2 = l2.next;
            } else {
                data = (l1.val + l2.val + flag) % 10;
                flag = (l1.val + l2.val + flag) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(data, null);
            tail.next = temp;
            tail = tail.next;
        }
        //处理最后一位有进位
        if (flag == 1) {
            ListNode end = new ListNode(1, null);
            tail.next = end;
        }
        return head;
    }
}

