package com.as.java.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author as
 * @since 2018/12/3 13:54
 */
public class FunInterfaceTest {

    @Data
    @AllArgsConstructor
    static class Person{
        private Integer age;
        private String name;
        private Date birthday;
    }

    public static Person test(Person oldPerson, Consumer<Person> fill) {
        fill.accept(oldPerson);
        return oldPerson;
    }

    public static void main(String[] args) {
//        CompletableFuture[] a = new CompletableFuture[10];
//        for (int i = 0; i < 10; i++) {
//            a[0] = CompletableFuture.runAsync(() -> {
//                int b = 1/0;
//            });
//        }
//        CompletableFuture.allOf(a);
        StringBuilder sb = new StringBuilder("aa");
        sb.append("bbb,");
        sb.deleteCharAt(sb.length());
        System.out.println(sb.toString());
    }
}
