package com.example.grzesiek.projektinzynierka.domain;


public class Circuit {
    private int id;
    private int year;
    private int month;
    private int day;
    private double chest;
    private double waist;


    public Circuit() {
    }

    public Circuit (int id){
        this.id = id;
    }

    public Circuit(int id, int year, int month, int day, double chest, double waist){
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.chest = chest;
        this.waist = waist;
    }
    public Circuit(int year, int month, int day, double chest, double waist){
        this.year = year;
        this.month = month;
        this.day = day;
        this.chest = chest;
        this.waist = waist;
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

    public double getChest() {
        return this.chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getWaist() {
        return this.waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }
}
