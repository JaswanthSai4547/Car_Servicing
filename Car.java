package com.car_service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Car implements Serializable
{
    private String car_company_name;
    private String car_model;
    private String purchased_year;
    private int no_of_owners;
    private String registration_number;
    private ArrayList<LastServiceData> serviceData_obj = new ArrayList<>();
    private long odo_meter_reading;
    private long insurance_number;
    private LocalDate insurance_exp_date;
    private int insurance_type;
    private double insurance_premium_amount;
    private String chassis_number;
    private String engine_number;

    public Car(String car_company_name, String car_model, String purchased_year, int no_of_owners, String registration_number, long odo_meter_reading, long insurance_number, LocalDate insurance_exp_date, int insurance_type, double insurance_premium_amount, String chassis_number, String engine_number) {
        this.car_company_name = car_company_name;
        this.car_model = car_model;
        this.purchased_year = purchased_year;
        this.no_of_owners = no_of_owners;
        this.registration_number = registration_number;
        this.odo_meter_reading = odo_meter_reading;
        this.insurance_number = insurance_number;
        this.insurance_exp_date = insurance_exp_date;
        this.insurance_type = insurance_type;
        this.insurance_premium_amount = insurance_premium_amount;
        this.chassis_number = chassis_number;
//        this.engine_number = engine_number;
        setEngine_number(engine_number);
    }

    public String getCar_company_name() {
        return car_company_name;
    }

    public void setCar_company_name(String car_company_name) {
        this.car_company_name = car_company_name;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getPurchased_year() {
        return purchased_year;
    }

    public void setPurchased_year(String purchased_year) {
        this.purchased_year = purchased_year;
    }

    public int getNo_of_owners() {
        return no_of_owners;
    }

    public void setNo_of_owners(int no_of_owners) {
        this.no_of_owners = no_of_owners;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public ArrayList<LastServiceData> getServiceData_obj() {
        return serviceData_obj;
    }

    public void setServiceData_obj(LastServiceData serviceData_obj) {
        this.serviceData_obj.add( serviceData_obj);
    }

    public long getOdo_meter_reading() {
        return odo_meter_reading;
    }

    public void setOdo_meter_reading(long odo_meter_reading) {
        this.odo_meter_reading = odo_meter_reading;
    }

    public long getInsurance_number() {
        return insurance_number;
    }

    public void setInsurance_number(long insurance_number) {
        this.insurance_number = insurance_number;
    }

    public LocalDate getInsurance_exp_date() {
        return insurance_exp_date;
    }

    public void setInsurance_exp_date(LocalDate insurance_exp_date) {
        this.insurance_exp_date = insurance_exp_date;
    }

    public int getInsurance_type() {
        return insurance_type;
    }

    public void setInsurance_type(int insurance_type) {
        this.insurance_type = insurance_type;
    }

    public double getInsurance_premium_amount() {
        return insurance_premium_amount;
    }

    public void setInsurance_premium_amount(double insurance_premium_amount) {
        this.insurance_premium_amount = insurance_premium_amount;
    }

    public String getChassis_number() {
        return chassis_number;
    }

    public void setChassis_number(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    public String getEngine_number() {
        return engine_number;
    }

    public void setEngine_number(String engine_number) {
        this.engine_number = engine_number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_company_name='" + car_company_name + '\'' +
                ", car_model='" + car_model + '\'' +
                ", purchased_year='" + purchased_year + '\'' +
                ", no_of_owners=" + no_of_owners +
                ", registration_number='" + registration_number + '\'' +
                ", serviceData_obj=" + serviceData_obj +
                ", odo_meter_reading=" + odo_meter_reading +
                ", insurance_number=" + insurance_number +
                ", insurance_exp_date=" + insurance_exp_date +
                ", insurance_type=" + insurance_type +
                ", insurance_premium_amount=" + insurance_premium_amount +
                ", chassis_number='" + chassis_number + '\'' +
                ", engine_number='" + engine_number + '\'' +"\n"+
                '}';
    }
}
