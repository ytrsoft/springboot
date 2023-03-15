package com.ytrsoft;

import com.ytrsoft.gui.GUIApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStarter extends GUIApplication {
    public static void main(String[] args) {
        launch(AppStarter.class, args);
    }
}
