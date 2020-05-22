package com.marinho.kafkawithjava.model;

import javax.validation.constraints.NotNull;

public class SimpleMessage {
    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Message cannot be null")
    private String message;

    public String getMessage() { return message; }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public SimpleMessage(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public SimpleMessage(){
    }
}
