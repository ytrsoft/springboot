package com.ytrsoft.gui;

import com.ytrsoft.gui.config.AppSettings;
import com.ytrsoft.gui.util.Style;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.apache.commons.lang3.ObjectUtils;

public class GUIApplication extends Application implements AppSettings, LoginPage.LoginListener  {

    private SpringBoot springBoot;

    private Stage primaryStage;

    private static Class<? extends Application> global;

    public static LogPage logPage = new LogPage();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        LoginPage loginPage = new LoginPage();
        loginPage.setOnLoginListener(this);
        Scene scene = new Scene(
            loginPage,
            LOGIN_PAGE_WIDTH,
            LOGIN_PAGE_HEIGHT
        );
        Style.deploy(scene);
        primaryStage.setScene(scene);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void login(String ip, String port) {
        if (ObjectUtils.isNotEmpty(global)) {
            toLogPage();
            springBoot = new SpringBoot(global);
            springBoot.setIp(ip);
            springBoot.setPort(port);
            springBoot.start();
        }
    }

    private void toLogPage() {
        Screen screen = Screen.getPrimary();
        double width = screen.getBounds().getWidth();
        double height = screen.getBounds().getHeight();
        double w = width * 2 / 3;
        double h = height * 2 / 3;
        Scene scene = new Scene(logPage, w, h);
        Style.deploy(scene);
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.setX((width - w) / 2);
        primaryStage.setY((height - h) / 2);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (ObjectUtils.isNotEmpty(springBoot)) {
            springBoot.getContext().close();
        }
    }

    public static void launch(Class<? extends Application> clz, String... args) {
        global = clz;
        launch(args);
    }

}
