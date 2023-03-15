package com.ytrsoft.gui;

import javafx.application.Application;
import javafx.scene.Scene;
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
        Scene scene = new Scene(logContainer, 600, 200);
        primaryStage.setScene(scene);
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
