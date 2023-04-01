package com.car_service;

import java.io.*;
import java.time.LocalDate;

public class Methods {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ServiceStation serviceStation_obj = new ServiceStation();

    File f = new File("/home/ee213130/Documents/carservice.txt");
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    public void change(String s1,String s2){
        if(f.isFile()) {
            System.out.println("----------");

            try{
                ois = new ObjectInputStream(new FileInputStream(f));
                serviceStation_obj = (ServiceStation) ois.readObject();
                ois.close();

                serviceStation_obj.setService_station(s1);
                serviceStation_obj.setAddress(s2);

                oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(serviceStation_obj);
                oos.close();

            }catch(Exception exc){
                System.out.println(exc);
                System.out.println("no car are registered");
                System.out.println("-----------");
            }
        }
        else{
            System.out.println("file not found");
        }
    }
    public void create_car() {
        try {
            System.out.println("car company name");
            String car_company_name = br.readLine();
            System.out.println("car model");
            String car_model = br.readLine();
            System.out.println("purchased year(YYYY)");
            String purchased_year = br.readLine();
            System.out.println("number of owners");
            int no_of_owners = Integer.parseInt(br.readLine());
            System.out.println("registration number");
            String registration_number = br.readLine();
            System.out.println("odo meter reading");
            long odo_meter_reading = Long.parseLong(br.readLine());
            System.out.println("insurance number");
            long insurance_number = Long.parseLong(br.readLine());
            System.out.println("insurance expiry date(yyyy mm dd)");
            LocalDate insurance_exp_date = LocalDate.parse(br.readLine());
            System.out.println("insurance type(1/2/3)");
            int insurance_type = Integer.parseInt(br.readLine());
            System.out.println("insurance premium amount");
            double insurance_premium_amount = Double.parseDouble(br.readLine());
            System.out.println("chassis number");
            String chassis_number = br.readLine();
            System.out.println("engine number");
            String engine_number = br.readLine();

            Car obj = new Car(car_company_name, car_model, purchased_year, no_of_owners, registration_number, odo_meter_reading, insurance_number, insurance_exp_date, insurance_type, insurance_premium_amount, chassis_number, engine_number);
            serviceStation_obj.setCars_objects(registration_number, obj);

            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(serviceStation_obj);
            oos.close();
            System.out.println("car added successfully");
        } catch (Exception exc) {
            System.out.println("invalid input");
        }
    }

    public void print(){
        if(f.isFile()) {
            System.out.println("----------");
            try{
                ois = new ObjectInputStream(new FileInputStream(f));
                serviceStation_obj = (ServiceStation) ois.readObject();
                ois.close();

                System.out.println(serviceStation_obj.toString());
                System.out.println("-----------");
            } catch(Exception exc) {
                System.out.println("no car are registered");
                System.out.println("-----------");
            }
        }
        else{
            System.out.println("file not found");
        }
    }

    public void updateinsurance(){
        try {
            if(f.isFile()) {
                try {
                    ois = new ObjectInputStream(new FileInputStream(f));
                    serviceStation_obj = (ServiceStation) ois.readObject();
                    ois.close();

                    System.out.println("car registration number:");
                    String regno = br.readLine();
                    if (serviceStation_obj.getCars_objects().containsKey(regno)) {
                        System.out.println("insurance expiry date(yyyy-mm-dd):");
                        LocalDate expdate = LocalDate.parse(br.readLine());
                        if (expdate.compareTo(serviceStation_obj.getCars_objects().get(regno).getInsurance_exp_date()) > 0) {
                            System.out.println("insurance number");
                            long temp1 = Long.parseLong(br.readLine());
                            System.out.println("insurance type(1/2/3)");
                            int temp2 = Integer.parseInt(br.readLine());
                            System.out.println("insurance premium amount");
                            double temp3 = Double.parseDouble(br.readLine());
                            serviceStation_obj.getCars_objects().get(regno).setInsurance_number(temp1);
                            serviceStation_obj.getCars_objects().get(regno).setInsurance_exp_date(expdate);
                            serviceStation_obj.getCars_objects().get(regno).setInsurance_type(temp2);
                            serviceStation_obj.getCars_objects().get(regno).setInsurance_premium_amount(temp3);

                            oos = new ObjectOutputStream(new FileOutputStream(f));
                            oos.writeObject(serviceStation_obj);
                            oos.close();
                            System.out.println("insurance updated successfully");
                        }else {
                            System.out.println("insurance can't update");
                        }
                    } else {
                        System.out.println("car not found");
                    }
                }catch (Exception exc){
                    System.out.println("no car was registered");
                }
            }else {
                System.out.println("file not found");
            }
        } catch (Exception exc) {
            System.out.println("invalid input");
        }
    }

    public void drop_car_to_service() {
        try {
            if(f.isFile())
            {
                try
                {
                    ois = new ObjectInputStream(new FileInputStream(f));
                    serviceStation_obj = (ServiceStation) ois.readObject();
                    ois.close();

                    System.out.println("car registration number:");
                    String regno = br.readLine();
                    if (serviceStation_obj.getCars_objects().containsKey(regno))
                    {
                        add_car_to_service(regno);
                        System.out.println("successfully car added to service");
                    }
                    else
                    {
                        System.out.println("car not found");
                    }

                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(serviceStation_obj);
                    oos.close();
                }
                catch(Exception exc)
                {
                    System.out.println("no car was registered");
                }
            }
            else
            {
                System.out.println("file not found");
            }
        }
        catch (Exception exc)
        {
            System.out.println("invalid input");
        }
    }

    public void add_car_to_service(String regno) {
        if(f.isFile()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                serviceStation_obj = (ServiceStation) ois.readObject();
                ois.close();
            }catch (Exception exc){
                System.out.println("no car was registered");
                return;
            }
        }else {
            System.out.println("file not found");
            return;
        }
        for (int i = 0; i < serviceStation_obj.getServicing_cars_list().size(); i++) {
            if (serviceStation_obj.getServicing_cars_list().get(i).equals(regno)) {
                System.out.println("car is already in service station");
                return;
            }
        }
        serviceStation_obj.getServicing_cars_list().add(regno);
        try {
            LastServiceData obj = new LastServiceData();
            System.out.println("odo meter reading");
            long temp1 = Long.parseLong(br.readLine());
            System.out.println("enter no of issues");
            int n = Integer.parseInt(br.readLine());
            LocalDate temp2 = LocalDate.now();

//            serviceStation_obj.getCars_objects().get(regno).getServiceData_obj().add(obj);
            serviceStation_obj.getCars_objects().get(regno).setServiceData_obj(obj);
            obj.setOdo_meter_reading(temp1);
            obj.setDate(temp2);
            System.out.println("enter issues:");
            for (int j = 0; j < n; j++) {
                String temp3 = br.readLine();
                obj.getIssues().add(temp3);
            }
            obj.setAmount(n * 543.2);

            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(serviceStation_obj);
            oos.close();

        } catch (Exception exc) {
            System.out.println("invalid input");
        }
    }
    public void pick_up_car() {
        try {
            if(f.isFile()) {
                try {
                    ois = new ObjectInputStream(new FileInputStream(f));
                    serviceStation_obj = (ServiceStation) ois.readObject();
                    ois.close();

                    System.out.println("registration number:");
                    String regno = br.readLine();
                    serviceStation_obj.service_car(regno);

                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(serviceStation_obj);
                    oos.close();
                }catch (Exception exc){
                    System.out.println("no car was registered");
                }
            }else {
                System.out.println("file not found");
            }
        } catch (Exception exc){
            System.out.println("Invalid Input");
        }
    }

}
