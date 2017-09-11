package QueenAndStack;

import java.util.*;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class MaxArr {
    private List<Integer> selectMax(int[] arr,int width){
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (deque.isEmpty()) {
                deque.add(i);
            } else {
                if (arr[deque.getLast()] >= arr[i]) {
                    deque.addLast(i);
                } else {
                    while (arr[deque.getLast()] < arr[i]) {
                        deque.pollLast();
                        if (deque.isEmpty()) {
                            break;
                        }
                    }
                    deque.addLast(i);
                }
            }
            if (i - start == width - 1) {
                start++;
                result.add(maxInWin(deque, arr));
            }
            if (deque.getLast() -  deque.getFirst() == width) {
                deque.pollFirst();
            }

        }
        return result;
    }

    private int maxInWin(Deque<Integer> deque, int[] arr) {
        int temp = Integer.MIN_VALUE;
        int result = -1;
        for (Integer x: deque) {
            if (temp < arr[x]) {
                temp = arr[x];
                result = x;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        MaxArr maxArr = new MaxArr();
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.println(maxArr.selectMax(arr, 3));
    }
}
