package LinkedList;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public class PrintCommonPart {
    public void printCommonLinkedList(Node head1, Node head2) {
        while (head1 != null & head2 != null) {
            if (head1.value > head2.value) {
                head2 = head2.next;
            } else if (head1.value < head2.value) {
                head1 = head1.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(0);
        Node l2 = new Node(3);
        Node head1 = l1;
        Node head2 = l2;
        for (int i = 1; i < 9; i++) {
            l1.next = new Node(i);
            l1 = l1.next;
        }
        for (int i = 4; i < 12; i++) {
            l2.next = new Node(i);
            l2 = l2.next;
        }
        PrintCommonPart p = new PrintCommonPart();
        p.printCommonLinkedList(head1, head2);
    }
}

