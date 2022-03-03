package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*填充右节点*/
public class L117_FillRightNode {
    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node last = new Node();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (i == 0) {
                    last = cur;
                } else {
                    last.next = cur;
                    last = last.next;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
        }
        return root;
    }
    public static Node connect2(Node root) {

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node _left1 = new Node(2);
        Node _right1 = new Node(3);
        Node _left2 = new Node(4);
        Node _right2 = new Node(5);
        Node _right3 = new Node(7);
        root.left = _left1;
        root.right = _right1;

        _left1.left = _left2;
        _left1.right = _right2;
        _left2.right = _right3;

        connect(root);
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};