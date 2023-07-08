package com.ytrsoft.gui;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringBoot extends Thread {

    private String ip;

    private String port;

    private ConfigurableApplicationContext context;

    private final Class<? extends Application> primarySource;

    public SpringBoot(Class<? extends Application> primarySource) {
        setDaemon(true);
        this.primarySource = primarySource;
    }

    private String[] args() {
        return new String[] {
            "--server.address=" + ip,
            "--server.port=" + port
        };
    }

    @Override
    public void run() {
        context = SpringApplication.run(primarySource, args());
    }

    protected void close() {
        if (context != null) {
            context.close();
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public ConfigurableApplicationContext getContext() {
        return context;
    }
}
