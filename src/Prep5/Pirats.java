package Prep5;

import java.util.Scanner;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pirats {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        String input = inp.nextLine();

        String first = "(?<cities>[A-Za-z ]+)\\|\\|(?<population>[0-9]+)\\|\\|(?<gold>[0-9]+)";
        Pattern patternF = Pattern.compile(first);
        Map<String, Integer> Gold = new TreeMap<>();
        Map<String, Integer> Population = new TreeMap<>();


        String plunder = "(Plunder)=>(?<town>[A-Za-z ]+)=>(?<people>[0-9]+)=>(?<gold>[0-9]+)";
        Pattern patternPl = Pattern.compile(plunder);

        String prosper = "(Prosper)=>(?<town>[A-Za-z ]+)=>(?<gold>-*[0-9]+)";
        Pattern patternPr = Pattern.compile(prosper);

        String city;
        int pop;
        int gold;
        while(!input.equals("Sail")){
            Matcher matcher = patternF.matcher(input);
            if (matcher.find()) {
                    city=matcher.group("cities");
                    pop=Integer.parseInt(matcher.group("population"));
                    gold=Integer.parseInt(matcher.group("gold"));
                if(!Population.containsKey(city)){
                    Population.put(city , pop);
                    Gold.put(city,gold);
                }else{
                    int cntP=Population.get(city);
                    Population.put(city, cntP + pop);
                    int cntG=Gold.get(city);
                    Gold.put(city, cntG + gold);
                }
            }
            input = inp.nextLine();
        }

        input = inp.nextLine();
        while(!input.equals("End")){
            Matcher matcher1 = patternPl.matcher(input);
            Matcher matcher2 = patternPr.matcher(input);


            if(matcher1.find()) {
                city = matcher1.group("town");
                pop = Integer.parseInt(matcher1.group("people"));
                gold = Integer.parseInt(matcher1.group("gold"));

                    int cnt1 = Population.get(city);
                    Population.put(city, cnt1 - pop);
                    int cnt2 = Gold.get(city);
                    Gold.put(city, cnt2 - gold);

                    System.out.printf("%s plundered! %s gold stolen, %s citizens killed.\n",
                            city,
                            gold,
                            pop);


                    if ((Population.get(city) <= 0) || (Gold.get(city) <= 0)) {
                            Population.remove(city);
                            Gold.remove(city);
                            System.out.printf("%s has been wiped off the map!\n", matcher1.group("town"));
                    }

            }

            if( matcher2.find()){
                city = matcher2.group("town");
                gold = Integer.parseInt(matcher2.group("gold"));

                if(gold < 0){
                    System.out.print("Gold added cannot be a negative number!\n");
                    input = inp.nextLine();
                    continue;
                }else{
                    int cnt3=Gold.get(city);
                    Gold.put(city, cnt3 + gold);
                }
                System.out.printf("%s gold added to the city treasury. %s now has %s gold.\n",
                        gold,
                        city,
                        Gold.get(city));
            }
            input = inp.nextLine();
        }
        if( Population.size()>0){
            System.out.println("Ahoy, Captain! There are " + Population.size() + " wealthy settlements to go to: ");
            Gold.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                    .forEach(entry ->  System.out.printf("%s -> Population: %s citizens, Gold: %s kg \n" ,
                            entry.getKey(),
                            Population.get(entry.getKey()),
                            entry.getValue()));
        }else{
            System.out.print("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
