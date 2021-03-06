package QueenAndStack;

import java.util.Stack;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class ReverseStack {
    private Stack<Integer> stack;
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.empty()) {
            return result;
        } else {
            //last实际不返回
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }

    }

    public static void reverse(Stack<Integer> stack){
        if (stack.empty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        reverse(stack);
        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
    }
}
