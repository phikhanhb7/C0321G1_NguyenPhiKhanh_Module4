package com.example.model;

public class Email {
    private String languages;
    private int size;
    private boolean spam;
    private String signature;

    public Email() {
    }

    public Email(String languages, int size, boolean spam, String signature) {
        this.languages = languages;
        this.size = size;
        this.spam = spam;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
