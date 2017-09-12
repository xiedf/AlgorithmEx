package LinkedList;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public class DeleteNode {
    public Node deleteNode(int k, Node head) {
        if (k < 1 || head == null) { return head; }
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            k--;
        }
        if (k == 0) {
            head = head.next;
        } else if (k < 0) {
            cur = head;
            k++;
            while (k < 0) {
                cur = cur.next;
                k++;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
    //与Node版相似，注意previous的指向即可
    public DeNode deleteNode(int k, DeNode head) {
        return null;
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        Node pointer = node;
        for (int i = 1; i < 10; i++) {
            pointer.next = new Node(i);
            pointer = pointer.next;
        }
        DeleteNode deleteNode = new DeleteNode();
        Node result = deleteNode.deleteNode(2, node);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}
