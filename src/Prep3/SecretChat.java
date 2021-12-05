package Prep3;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        StringBuilder data = new StringBuilder(inp.nextLine());
        String input = inp.nextLine();
        while (!input.equals("Reveal")) {
            String[] inputData = input.split(":\\|:");
            String command = inputData[0];
            switch (command){
                case "InsertSpace":
                    int index=Integer.parseInt(inputData[1]);
                    data.insert(index," ");
                    System.out.println(data);
                    break;
                case "Reverse":
                    StringBuilder val= new StringBuilder(inputData[1]);
                    if (data.toString().contains(val)){
                        int n = val.length();
                        int firstOccur = data.indexOf(val.toString());
                        data.append(val.reverse());
                        data.delete(firstOccur,firstOccur+n);
                        System.out.println(data);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String oldVal = inputData[1];
                    String newVal = inputData[2];
                    if(data.toString().contains(oldVal)) {
                        data = new StringBuilder(data.toString().replace(oldVal, newVal));
                    }
                    System.out.println(data);
                    break;
            }
            input = inp.nextLine();
        }
        System.out.printf("You have a new text message: %s",data);
    }
}
