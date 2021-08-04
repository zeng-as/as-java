package com.as.base;

/**
 * @desc 位运算
 * @author as.
 * @since 2021/1/8
 */
public class BitArithmetic {
    public static void main(String[] args) {
        int a = 1;
        int b = a + 1;
        System.out.println(b);
        // 2147483647
        int c = (a << 31) ^ -2147483648;
        System.out.println(c);
        int d = -2147483648 >>> 31;
        System.out.println(d);
        System.out.println(Integer.toBinaryString(-2147483648));
    }
}
