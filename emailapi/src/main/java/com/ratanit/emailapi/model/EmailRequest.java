package com.ratanit.emailapi.model;

public class EmailRequest {
    private String name;
    private String age;
    private  String jobType;
    private String message;

    public EmailRequest() {
    }

    public EmailRequest(String name, String age, String jobType, String message) {
        this.name = name;
        this.age = age;
        this.jobType=jobType;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", jobType='" + jobType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
