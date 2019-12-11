package com.example.grzesiek.projektinzynierka.domain;



public class Weight {
    private int id;
    private int year;
    private int month;
    private int day;
    private double weight;


    public Weight() {
    }

    public Weight(int id) {
        this.id = id;
    }

    public Weight(int id, int year, int month, int day, double weight){
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.weight = weight;
    }
    public Weight(int year, int month, int day, double weight){
        this.year = year;
        this.month = month;
        this.day = day;
        this.weight = weight;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}