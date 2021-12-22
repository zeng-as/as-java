package com.as.log.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        logger.trace("this is trace log");
        logger.debug("this is debug log");
        logger.info("this is info log");
        logger.warn("this is warn log");
        logger.error("this is error log");
        logger.fatal("this is fatal log");
    }
}
