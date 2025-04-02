package com.program.restapi.dto;

public class StudentDTO {
    private String name;
    private float percentage;
    private String branch;

    public StudentDTO() {
    }

    public StudentDTO(String name, float percentage, String branch) {
        this.name = name;
        this.percentage = percentage;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}