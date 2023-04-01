package com.car_service;

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        Methods m = new Methods();
        System.out.println("enter service station name:");
        String t1 = sc.nextLine();
        System.out.println("Address:");
        String t2 = sc.nextLine();
        m.change(t1,t2);

        while (true) {
            try {
                System.out.println("1.create car");
                System.out.println("2.print all car details");
                System.out.println("3.update insurance");
                System.out.println("4.drop car to service");
                System.out.println("5.pick up car");
                System.out.println("6.exit");
                System.out.println("enter your choice:");
                int choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1:
                        m.create_car();
                        break;
                    case 2:
                        m.print();
                        break;
                    case 3:
                        m.updateinsurance();
                        break;
                    case 4:
                        m.drop_car_to_service();
                        break;
                    case 5:
                        m.pick_up_car();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("invalid input case");
                }
            } catch (Exception exc) {
                System.out.println("invalid input---");
            }
        }
    }
}