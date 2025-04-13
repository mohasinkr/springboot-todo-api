package com.mkr.todo.service;

public class LoggerService {
    private static LoggerService instance;

    private LoggerService() {
        // marking it as empty private constructor to prevent instantiation
    }

    public static synchronized LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]::"+message);
    }

}
