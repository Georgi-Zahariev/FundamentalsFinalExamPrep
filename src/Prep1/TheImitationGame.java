package Prep1;

import java.util.Scanner;
public class TheImitationGame {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        StringBuilder data = new StringBuilder(inp.nextLine());

        String input = inp.nextLine();
        while (!input.equals("Decode")) {
            String[] argumet = input.split("\\|");
            String command = argumet[0];

            switch (command) {
                case "Move":
                    int let = Integer.parseInt(argumet[1]);
                    data.append(data,0, let) ;
                    data.delete(0,let);
                    break;
                case "Insert":
                    int index=Integer.parseInt(argumet[1]);
                    String value = argumet[2];
                    data.insert(index,value);
                    break;
                case "ChangeAll":
                    String oldVal = argumet[1];
                    String newVal = argumet[2];
                    if(data.toString().contains(oldVal)) {
                        data = new StringBuilder(data.toString().replace(oldVal, newVal));
                    }
                    break;
            }
            input = inp.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", data);
    }
}
