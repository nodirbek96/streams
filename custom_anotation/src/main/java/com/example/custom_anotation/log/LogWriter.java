package com.example.custom_anotation.log;

public class LogWriter implements LogsCallback{
    @Override
    public String printHello(String text) {
        return text;
    }
}
