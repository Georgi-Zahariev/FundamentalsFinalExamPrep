package Prep4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = Integer.parseInt(inp.nextLine());
        Pattern pattern = Pattern.compile("[@][#]+(?<name>[A-Z][A-Za-z0-9]{4,}[A-Z])[@][#]+");
        for(int i=0 ;i<n;i++){
            String select = inp.nextLine();
            Matcher matcher = pattern.matcher(select);
            if(matcher.find()){
                StringBuilder s=new StringBuilder();
                for(char c: matcher.group().toCharArray()){
                    if(Character.isDigit(c)){
                        s.append(c);
                    }
                }
                if(s.toString().equals("")){
                    s.append("00");
                }
                System.out.printf("Product group: %s%n",s.toString());
            }else{
                System.out.println("Invalid barcode");
            }
        }
    }
}