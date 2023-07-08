package com.ytrsoft.gui.config;

import javafx.scene.paint.Color;

public interface LogColor {
    String KEY_ERROR = "ERROR";
    Color ERROR = Color.valueOf("rgb(255, 107, 104)");
    String KEY_WARN = "WARN";
    Color WARN = Color.valueOf("rgb(240, 167, 50)");
    String KEY_INFO = "INFO";
    Color INFO = Color.valueOf("rgb(187, 187, 187)");
    String KEY_DEBUG = "DEBUG";
    Color DEBUG = Color.valueOf("rgb(53, 146, 196)");
    String KEY_TRACE = "TRACE";
    Color TRACE = Color.valueOf("rgb(73, 156, 86)");
}
