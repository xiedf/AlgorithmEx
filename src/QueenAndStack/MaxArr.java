package QueenAndStack;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class MaxArr {
    public int[] maxArr(int[] arr, int w){
        int len = arr.length - w + 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int[] threeNum = {arr[i], arr[i + 1], arr[i + 2]};
            result[i] = selectMax(threeNum);
        }
        return result;
    }
    private int selectMax(int[] threeNum){
        int a = threeNum[0];
        int b = threeNum[1];
        int c = threeNum[2];
        if(a > b){
            if(a > c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b > c){
                return b;
            }else{
                return c;
            }
        }
    }

    public static void main(String[] args) {
        MaxArr maxArr = new MaxArr();
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(maxArr.maxArr(arr, 3)));
    }
}
