package com.as.java.util;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author as.
 * @since 2020/11/16
 */
public class CommonTest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Test {
        @Serialization
        private String name;
        public int age;
    }

    public static void main(String[] args) throws Exception {
        Byte a = null;
        String b = "asd" + a;
        System.out.println(b);
    }
}
