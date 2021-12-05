package Prep3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedforSpeedIII {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num = Integer.parseInt(inp.nextLine());
        Map<String, Integer> fuel = new HashMap<>();
        Map<String, Integer> mileage = new HashMap<>();

        String input;
        for (int i = 0; i < num; i++) {
            input = inp.nextLine();
            String[] inputData = input.split("\\|");
            fuel.put(inputData[0],Integer.parseInt(inputData[2]));
            mileage.put(inputData[0],Integer.parseInt(inputData[1]));
        }
        input = inp.nextLine();
        while (!input.equals("Stop")) {
            String[] commands = input.split(" : ");
            String action = commands[0];
            switch (action){
                case "Drive":
                    String name = commands[1];
                        if(fuel.get(name) < Integer.parseInt(commands[3]) ){
                            System.out.println("Not enough fuel to make that ride");
                        }else{
                            fuel.put(name, fuel.get(name)-Integer.parseInt(commands[3]));
                            mileage.put(name, mileage.get(name)+Integer.parseInt(commands[2]));
                            System.out.printf("%s driven for %s kilometers. %s liters of fuel consumed.%n",
                                    name,commands[2],commands[3]);
                        }
                        if(mileage.get(name) > 100000){
                            fuel.remove(name);
                            mileage.remove(name);
                            System.out.printf("Time to sell the %s!%n", name);
                        }
                    break;
                case "Refuel":
                    name = commands[1];
                    int f = Integer.parseInt(commands[2]);
                    if((f+fuel.get(name))>75){
                        f=75-fuel.get(name);
                        fuel.put(name,75);
                    }else{
                        fuel.put(name,fuel.get(name)+f);
                    }
                    System.out.printf("%s refueled with %s liters%n",name,f);
                    break;
                case "Revert":
                    name = commands[1];
                    mileage.put(name,mileage.get(name) - Integer.parseInt(commands[2]));
                    if(mileage.get(name)<10000){
                        mileage.put(name,10000);
                    }else{
                        System.out.printf("%s mileage decreased by %s kilometers%n",name,commands[2]);
                    }
                    break;
            }
            input = inp.nextLine();
        }
        mileage.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry ->  System.out.printf("%s -> Mileage: %s kms, Fuel in the tank: %s lt.%n" ,
                        entry.getKey(),
                        entry.getValue(),
                        fuel.get(entry.getKey())));
    }
}
