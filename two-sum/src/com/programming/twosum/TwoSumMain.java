package com.programming.twosum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSumMain {
    public static int[] newAddingTwoNumbers(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            Integer indexFound = map.get(target - currentNum);
            if (indexFound != null) {
                result[0] = indexFound;
                result[1] = i;
                return result;
            } else {
                map.put(currentNum, i);
            }
        }
        return result;
    }
    public static int[] addingTwoNumbers(int[] nums,int target){
        int k = 0;
        int[] result_arr = new int[2];
        for(int i=1;i<nums.length;i++){
            int x = (k==i)?0:nums[k]+nums[i];
            if(x == target){
                result_arr[0] = k;
                result_arr[1] = i;
                return result_arr;
            }else if(i==nums.length-1){
                k=k+1;
                i=0;
            }
        }
        return result_arr;
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Input target element");
        int target = Integer.parseInt(br.readLine());
        System.out.println("Enter elements");
        int[] nums = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] result = addingTwoNumbers(nums,target);
        System.out.println("result");
        Arrays.stream(result).forEach(System.out::println);
    }
}
