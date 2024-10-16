package com.example;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class MyApp {
    static Logger logger = Logger.getLogger(getApp().getName());

    public static void main(String[] args) {
        logger.info("Hello World!"); // Compliant, output via logger

    }

    private static Logger getApp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'App'");
    }
}
