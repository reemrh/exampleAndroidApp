package com.example.exampleapp;

public class TaskItem {
    String Title;
    String isChecked;

    public TaskItem() {
    }

    public TaskItem(String title, String isChecked) {
        Title = title;
        this.isChecked = isChecked;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }
}
