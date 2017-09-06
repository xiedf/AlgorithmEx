package QueenAndStack;

import java.util.Stack;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public class StackOrderByStack {
    public static Stack<Integer> stack;
    public static void main(String[] args) {
        stack = new Stack<>();
        StackOrderByStack stackOrderByStack = new StackOrderByStack();
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(7);
        stack.push(1);
        stack.push(3);
        stack.push(6);
        System.out.println(stack);
        stackOrderByStack.orderByStack();
        System.out.println(stack);
    }
    public void orderByStack(){
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            int tmp = stack.pop();
            while (!help.empty() && help.peek() > tmp) {
                stack.push(help.pop());
            }
            help.push(tmp);
        }
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }


}
