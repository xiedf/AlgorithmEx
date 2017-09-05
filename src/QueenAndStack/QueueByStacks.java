package QueenAndStack;

import java.util.Stack;

/**
 * Created by xdf on 2017/9/5 0005.
 */
public class QueueByStacks<E> {
    private Stack<E> stackPush;
    private Stack<E> stackPop;

    public QueueByStacks(){
        stackPush = new Stack<E>();
        stackPop = new Stack<E>();
    }

    public void add(E element){
        stackPush.push(element);
    }

    public E poll(){
        E element = this.p();
        stackPop.pop();
        while(!stackPop.empty()){
            stackPush.push(stackPop.pop());
        }
        return element;
    }

    public E peek(){
        E element = this.p();
        while(!stackPop.empty()){
            stackPush.push(stackPop.pop());
        }
        return element;
    }
    private E p(){
        if(stackPush.empty()){
            throw new RuntimeException("Your queue is empty");
        }
        while(!stackPush.empty()){
            stackPop.push(stackPush.pop());
        }
        E element = stackPop.peek();
        return element;
    }

    public static void main(String[] args) {
        QueueByStacks q = new QueueByStacks<Integer>();
        for (int i = 1; i <= 12; i++) {
            q.add(i);
            System.out.println(q.peek());
            System.out.println(q.poll());
        }
    }
}
