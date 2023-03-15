package com.ytrsoft.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class GUIApplication extends Application implements LoginView.LoginListener {

    private Stage primaryStage;

    private ConfigurableApplicationContext context;

    private static Class<? extends Application> global;

    public static LogView logContainer = new LogView();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        LoginView loginView = new LoginView();
        loginView.setOnLoginListener(this);
        Scene scene = new Scene(loginView, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("服务器");
        primaryStage.show();
    }

    @Override
    public void login(String ip, String port) {
        String[] args = new String[] {
            "--server.address=" + ip,
            "--server.port=" + port
        };
        Screen screen = Screen.getPrimary();
        double width = screen.getBounds().getWidth();
        double height = screen.getBounds().getHeight();
        double w = width * 2 / 3;
        double h = height * 2 / 3;
        Scene scene = new Scene(logContainer, w, h);
        primaryStage.setScene(scene);
        primaryStage.setX((width - w) / 2);
        primaryStage.setY((height - h) / 2);
        Thread thread = new Thread(() -> {
            context = SpringApplication.run(global, args);
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (context != null) {
            context.close();
        }
    }

    public static void launch(Class<? extends Application> clz, String[] args) {
        global = clz;
        launch(args);
    }

}
