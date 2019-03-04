package com.as.java.util;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author as
 * @since 2018/12/27 9:50
 */
public class ThreadLocalUtils {
    private static ThreadLocal<String> mainThread = new ThreadLocal<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        mainThread.set("aaa");
        System.out.println(mainThread.get());
        String aaa = mainThread.get();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        CompletableFuture[] cfs = new CompletableFuture[list.size()];
        list.forEach(i -> {
            CompletableFuture cf = CompletableFuture.runAsync(() -> {
                System.out.println(ThreadLocalUtils.mainThread.get());
                System.out.println(aaa);
            });
            cfs[i - 1] = cf;
        });
        CompletableFuture.allOf(cfs).get();

    }
}
