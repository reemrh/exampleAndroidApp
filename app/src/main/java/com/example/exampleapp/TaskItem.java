package com.example.exampleapp;

public class TaskItem {
    String Title;
    Boolean isChecked;

    public TaskItem() {
    }

    public TaskItem(String title, Boolean isChecked) {
        Title = title;
        this.isChecked = isChecked;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }
}
