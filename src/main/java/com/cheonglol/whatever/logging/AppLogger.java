package com.cheonglol.whatever.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {
    private static final Logger logger = LoggerFactory.getLogger(AppLogger.class);

    private AppLogger() {
    }

    public static Logger getLogger() {
        return logger;
    }
}
