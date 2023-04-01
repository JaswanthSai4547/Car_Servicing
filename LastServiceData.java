package com.car_service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class LastServiceData implements Serializable
{
    private long odo_meter_reading;
    private ArrayList<String> issues = new ArrayList<>();
    private LocalDate date;
    private double amount;

    public long getOdo_meter_reading() {
        return odo_meter_reading;
    }

    public void setOdo_meter_reading(long odo_meter_reading) {
        this.odo_meter_reading = odo_meter_reading;
    }

    public ArrayList<String> getIssues() {
        return issues;
    }

    public void setIssues(ArrayList<String> issues) {
        this.issues = issues;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "LastServiceData{" +
                "odo_meter_reading=" + odo_meter_reading +
                ", issues=" + issues +
                ", date=" + date +
                ", amount=" + amount +"\n"+
                '}';
    }
}
