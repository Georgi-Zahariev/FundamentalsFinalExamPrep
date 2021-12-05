package Prep1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    static class Astra{
        String name;
        String data;
        int calories;
        public Astra(String n, String d, int c){
            name=n;
            data=d;
            calories=c;
        }
        public String toString(){
            return String.format("Item: %s, Best before: %s, Nutrition: %s%n", name, data, calories);
        }
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String info = inp.nextLine();
        Pattern pattern = Pattern.compile("(?<separator>[\\|#])(?<name>[A-Za-z ]+)\\1(?<data>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<cal>\\d+)\\1");
        Matcher matcher = pattern.matcher(info);
        List<Astra> all = new ArrayList<>();
        int sum=0;
        while (matcher.find()) {
            String name = matcher.group("name");
            String date = matcher.group("data");
            int n=Integer.parseInt(matcher.group("cal"));
            if(n>0 && n<10000) {
            Astra newObject= new Astra(name, date,n);
               all.add(newObject);
               sum += n;
            }
        }
        int days = sum/2000;
        System.out.printf("You have food to last you for: %s days!%n",days);
        if(all.size()>0) {
            for (Astra n : all) {
                System.out.print(n.toString());
            }
        }
    }
}
