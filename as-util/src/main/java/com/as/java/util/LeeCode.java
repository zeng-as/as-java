package com.as.java.util;

/**
 * @author as
 * @date 2021/10/28
 * @desc
 */
public class LeeCode {
    public static boolean test(int i) {
        int min = 1;
        int max = 1000000000;
        if (i < min || i > max) {
            return false;
        }

        int[] array = new int[9];
        int idx = 0;
        int temp = i;
        do {
            array[idx] = temp % 10;
            temp = temp / 10;
            idx++;
        } while (temp != 0);
        if (idx == 1) {
            return isTwoMin(array[0]);
        }

        // 重排数字
        for (int a = 1; a <= idx; a++) {
            for (int b = 0; b < idx - 1; b++) {
                int t = array[b];
                array[b] = array[b+1];
                array[b+1] = t;

                if (assemble(array, idx)) {
                    return true;
                }
            }
        }

        return false;
    }



    public static boolean assemble(int[] array, int idx) {
        if (array[0] == 0) {
            return false;
        }

        int rs = 0;
        for (int i = 0; i < idx; i++) {
            rs += array[i];
            if (i != idx - 1) {
                rs *= 10;
            }
        }
        return isTwoMin(rs);
    }

    public static boolean isTwoMin(int i) {
        System.out.println(i);
        while (true) {
            int t = i >> 1;
            if (t == 0) {
                return true;
            } else if (t == i / 2 && 0 == i % 2) {
                i = t;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {8219};
        for (int i : a) {
            System.out.println(test(i));
        }
//        isTwoMin(9128);
    }
}
