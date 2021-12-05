package Prep4;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        StringBuilder data = new StringBuilder(inp.nextLine());
        String input = inp.nextLine();
        while (!input.equals("Done")) {
            String[] inputData = input.split(" ");
            String command = inputData[0];
            switch (command){
                case "TakeOdd":
                    String s = "";
                    for(int i=1; i<data.toString().length(); i++){
                        if(i%2==1){
                            s=s.concat(String.valueOf(data.toString().charAt(i)));
                        }
                    }
                    data = new StringBuilder(s);
                    System.out.println(data);
                    break;
                case "Cut":
                    int index = Integer.parseInt(inputData[1]);
                    int len = Integer.parseInt(inputData[2]);
                    data.replace(index,index+len,"");
                    System.out.println(data);
                    break;
                case "Substitute":
                    String oldVal = inputData[1];
                    String newVal = inputData[2];
                    if(data.toString().contains(oldVal)) {
                        data = new StringBuilder(data.toString().replace(oldVal, newVal));
                        System.out.println(data);
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = inp.nextLine();
        }
        System.out.printf("Your password is: %s%n",data);
    }
}
