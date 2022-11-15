package com.as.base.concurrent;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author as
 * @date 2022/9/9
 * @desc
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(1);

        Runnable runnable = () -> {
            String tname = Thread.currentThread().getName();

            // 获取锁
            System.out.println(LocalDateTime.now() + ":" + tname + " 成功进入，等待开关开启...");
            try {
                cdl.await();
            } catch (InterruptedException e) {
                System.out.println(LocalDateTime.now() + ":" + tname + " 比赛取消了...");
                e.printStackTrace();
                return;
            }
            System.out.println(LocalDateTime.now() + ":" + tname + " 结束;");
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请裁判确定是否开始？");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equals("开始")) {
                cdl.countDown();
                System.out.println("比赛开始");
                break;
            } else if (next.equals("结束")) {
                System.out.println("比赛结束");
                for (Thread t : threads) {
                    t.interrupt();
                }
                break;
            } else {
                System.out.println("错误指令！");
            }
        }

        scanner.close();
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("整体结束");
    }
}
