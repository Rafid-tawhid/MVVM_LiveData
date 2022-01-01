package com.example.mvvm_pattern.models;

public class Employee {
    private String name;
    private String designation;
    private double sallary;
    public Employee(String name, String designation, double sallary) {
        this.name = name;
        this.designation = designation;
        this.sallary = sallary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }
}
