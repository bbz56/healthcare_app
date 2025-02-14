package com.example.healthcare_app;
public class HealthReport {
    private String id, title, date;

    public HealthReport(String id, String title, String date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
