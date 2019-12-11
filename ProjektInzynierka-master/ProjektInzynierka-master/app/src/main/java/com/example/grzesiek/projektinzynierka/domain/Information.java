package com.example.grzesiek.projektinzynierka.domain;


public class Information {
    private int id;
    private String name;
    private int height;
    private double weight;
    private double targetWeight;
    private int age;


    public Information() {
    }

    public Information(int id, String name, int height, double weight, double targetWeight, int age) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.targetWeight = targetWeight;
        this.age = age;
    }

    public Information(String name, int height, double weight, double targetWeight, int age) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.targetWeight = targetWeight;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTargetWeight() {
        return this.targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

