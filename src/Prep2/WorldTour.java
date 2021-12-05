package Prep2;

import java.util.Scanner;
import java.util.*;
public class WorldTour {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        StringBuilder data = new StringBuilder(inp.nextLine());
        String input = inp.nextLine();
        while(!input.equals("Travel")){
            String[] inputData = input.split(":");
            String command=inputData[0];
            int index;
            switch (command){
                case "Add Stop":
                    index=Integer.parseInt(inputData[1]);
                        if(index>=0 && index<data.toString().length()) {
                            data.insert(index , inputData[2]);
                        }
                    System.out.println(data);
                    break;
                case "Remove Stop":
                    index=Integer.parseInt(inputData[1]);
                    int index2=Integer.parseInt(inputData[2]);
                         if(index>=0 &&
                            index2<data.toString().length()) {
                                 data.replace(index, index2+1, "");
                         }
                    System.out.println(data);
                    break;
                case "Switch":
                    String old= inputData[1];
                    String newOne =inputData[2];
                        if (data.toString().contains(inputData[1])) {
                            data = new StringBuilder(data.toString().replaceAll(old, newOne));
                        }
                    System.out.println(data);
                    break;
            }

            input=inp.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s",data);
    }
}
