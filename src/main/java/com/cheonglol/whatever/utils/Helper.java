package com.cheonglol.whatever.utils;

public class Helper {

    public static String sanitizeFilename(String filename) {
        // Implement your filename sanitization logic here
        return filename.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");
    }

}
