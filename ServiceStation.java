package com.car_service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceStation implements Serializable
{
    private String service_station;
    private String Address;
    private ArrayList<String> servicing_cars_list = new ArrayList<>();
    private Map<String,Car> cars_objects = new HashMap<>();


    public void service_car(String regno)
    {
        if(servicing_cars_list.size()>0) {
            for (int i = 0; i < servicing_cars_list.size(); i++) {
                if (servicing_cars_list.get(i).equals(regno)) {
                    servicing_cars_list.remove(i);
                    System.out.println(cars_objects.get(regno).getServiceData_obj().get(cars_objects.get(regno).getServiceData_obj().size() - 1));
                    break;
                }
            }
        }else {
            System.out.println("car is not in servicing list");
        }
    }
    public String getService_station() {
        return service_station;
    }

    public void setService_station(String service_station) {
        this.service_station = service_station;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public ArrayList<String> getServicing_cars_list() {
        return servicing_cars_list;
    }

    public void setServicing_cars_list(ArrayList<String> servicing_cars_list) {
        this.servicing_cars_list = servicing_cars_list;
    }

    public Map<String, Car> getCars_objects() {
        return cars_objects;
    }

    public void setCars_objects(String str, Car obj) {
        this.cars_objects.put(str, obj);
    }

    @Override
    public String toString() {
        return "ServiceStation{" +
                "service_station='" + service_station + '\'' +
                ", Address='" + Address + '\'' +"\n"+
                ", servicing_cars_list=" + servicing_cars_list +"\n"+
                ", cars_objects=" + cars_objects +"\n"+
                '}';
    }
}
