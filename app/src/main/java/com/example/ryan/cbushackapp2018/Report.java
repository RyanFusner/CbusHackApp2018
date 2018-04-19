package com.example.ryan.cbushackapp2018;


import java.util.Date;

public class Report
{
    private int id;
    private String submitter;
    private String victim;
    private String bully;
    private Date dateAndTime;
    private String location;
    private String description;

    public Report(String submitter, String victim, String bully, Date dateAndTime, String location, String description) {
        this.id = 0;
        this.submitter = submitter;
        this.victim = victim;
        this.bully = bully;
        this.dateAndTime = dateAndTime;
        this.location = location;
        this.description = description;
    }

    public Report() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getVictim() {
        return victim;
    }

    public void setVictim(String victim) {
        this.victim = victim;
    }

    public String getBully() {
        return bully;
    }

    public void setBully(String bully) {
        this.bully = bully;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", submitter='" + submitter + '\'' +
                ", victim='" + victim + '\'' +
                ", bully='" + bully + '\'' +
                ", dateAndTime=" + dateAndTime +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
