package QueenAndStack;
import java.util.Stack;

/**
 * Created by xdf on 2017/9/5 0005.
 */
public class GetMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(Integer ele){
        stackData.push(ele);
        if(stackMin.empty()){
            stackMin.push(ele);
        }else if(ele <= stackMin.peek()){
            stackMin.push(ele);
        }
    }

    public Integer pop(){
        if(stackData.empty()){
            throw new RuntimeException("Your stack is empty");
        }
        Integer integer = stackData.pop();
        if(integer == stackMin.peek()){
            stackMin.pop();
        }
        return integer;
    }

    public Integer getMin(){
        if(stackMin.empty()){
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        GetMinStack g = new GetMinStack();
        for (int i = 0; i < 10; i++) {
            g.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(g.pop());
        }
    }
}
