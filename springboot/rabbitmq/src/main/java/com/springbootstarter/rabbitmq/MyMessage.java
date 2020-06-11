package com.springbootstarter.rabbitmq;

public class MyMessage {
    String message;
    int messageCode;

    public MyMessage(String message, int messageCode) {
        this.message = message;
        this.messageCode = messageCode;
    }

    public MyMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }
}
