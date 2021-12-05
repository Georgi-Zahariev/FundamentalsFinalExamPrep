package Prep5;

import java.util.Scanner;
import java.util.*;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String data = inp.nextLine();
        String input = inp.nextLine();

        while(!input.equals("Generate")){
            String[] inputData = input.split(">>>");
            String comand=inputData[0];
            switch (comand){
                case "Contains":
                    if(data.contains(inputData[1])){
                        System.out.printf("%s contains %s\n",data,inputData[1] );
                    }else{
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String s1=data.substring(Integer.parseInt(inputData[2]),Integer.parseInt(inputData[3]));
                    String s2=data.substring(Integer.parseInt(inputData[3]));
                    String s0=data.substring(0,Integer.parseInt(inputData[2]));
                    if(inputData[1].equals("Upper")){
                        s1=s1.toUpperCase();
                    }else{
                        s1=s1.toLowerCase();
                    }
                    data=s0+s1+s2;
                    System.out.println(data);
                    break;
                case "Slice":

                    String S1=data.substring(Integer.parseInt(inputData[2]));
                    String S2=data.substring(0,Integer.parseInt(inputData[1]));
                    data=S2+S1;
                    System.out.println(data);
                    break;
            }
            input=inp.nextLine();
        }
        System.out.printf("Your activation key is: %s\n",data);
    }
}
