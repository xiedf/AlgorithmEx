package LinkedList;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public class Node {
    public int value;
    public Node next;
    public Node(int data) {
        this.value = data;
    }
}

class DeNode {
    public int value;
    public Node next;
    public Node previous;
    public DeNode(int data) { this.value = data; }
}