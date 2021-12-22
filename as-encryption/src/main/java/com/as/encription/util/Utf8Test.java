package com.as.encription.util;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Utf8Test {
    public static void main(String[] args) {
        try {
            URL test = ClassLoader.getSystemResource("test");
            FileInputStream fis = new FileInputStream(test.getPath());
            List<TreeSet<Integer>> listTreeSet =new ArrayList<>();
            for(int i=0;i<10;i++)
                listTreeSet.add(new TreeSet<Integer>());

            byte[] buff = new byte[10];
            int hasRead = 0;
            while ((hasRead = fis.read(buff)) > 0) {
                System.out.println(hasRead);
                for (int i = 0; i < buff.length; i++) {
//                    if (buff[i] < 0) {
                        System.out.println(buff[i]);
                        listTreeSet.get(i).add((int) buff[i]);
//                    }
                }
            }
            for(int i=0;i<10;i++)
                System.out.println("第"+(i+1)+"个字节："+listTreeSet.get(i));
            fis.close();

            System.out.println(new String(buff, StandardCharsets.UTF_16));
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
}
