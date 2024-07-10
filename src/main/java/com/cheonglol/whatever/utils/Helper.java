package com.cheonglol.whatever.utils;

public class Helper {

    public static String sanitizeFilename(String filename) {
        // Implement your filename sanitization logic here
        return filename.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");
    }

    public static String getFuckingFilenameExtention(String filename) {
        if (!filename.contains("."))
            return "";
        String[] parts = filename.split("\\.", 2);
        return parts.length > 1 ? parts[1] : "";
    }
}
