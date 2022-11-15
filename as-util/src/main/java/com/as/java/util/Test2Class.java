package com.as.java.util;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author as
 * @date 2021/12/28
 * @desc
 */
public class Test2Class {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }


    public static void main(String[] args) throws InterruptedException {
        Map<Integer, List<Integer>> m = new HashMap<>();
        m.put(2, Arrays.asList(1,2,3));
        m.put(1, Arrays.asList(4,5,6));
        m.put(-1, Arrays.asList(7,8,9));

        for (Map.Entry<Integer, List<Integer>> e : m.entrySet()) {
            System.out.println(e.getKey());
        }

        while (true) {
            Thread.sleep(60 * 60 * 1000);
        }
    }
}
