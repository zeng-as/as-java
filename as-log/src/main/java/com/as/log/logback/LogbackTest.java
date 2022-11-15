package com.as.log.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author as
 * @date 2022/5/30
 * @desc
 */
public class LogbackTest {
    private static final Logger log = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("org.slf4j.impl.StaticLoggerBinder");
            String path = c.getResource("").getPath();
            System.out.println(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        StatusPrinter.print(lc);
    }
}
