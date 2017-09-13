package LinkedList;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public class RemoveMidNode {
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        } else if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil((double) (a * n) / ((double) b));
        if (n == 1) {
            head = head.next;
        } else if (n > 1) {
            cur = head;
            for (int i = 0; i < n - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;

    }
}
