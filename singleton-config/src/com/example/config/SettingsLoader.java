package com.example.config;

import java.nio.file.Path;

public class SettingsLoader {
    public AppSettings load(Path file) {
        AppSettings.INSTANCE.loadFromFile(file);
        return AppSettings.INSTANCE;
    }
}
