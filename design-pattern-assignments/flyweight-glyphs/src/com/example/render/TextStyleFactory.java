package com.example.render;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
    private static final Map<String, TextStyle> cache = new HashMap<>();

    public static TextStyle getStyle(String font, int size, boolean bold) {
        String key = font + "|" + size + "|" + (bold ? "B" : "R");
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }
}
