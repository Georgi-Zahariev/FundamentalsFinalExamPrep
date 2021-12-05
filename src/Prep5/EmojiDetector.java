package Prep5;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String data = inp.nextLine();

        BigInteger sum =Multiply(data);
        String first = "(?<symbols>[:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(first);
        Matcher matcher = pattern.matcher(data);

        List<String> coolEmojis = new ArrayList<>();
        int count = 0;
        while (matcher.find()) {
            count++;
            int coolness = getCool(matcher.group("emoji"));
            if (sum.compareTo(BigInteger.valueOf(coolness)) < 0) {
                coolEmojis.add(matcher.group());
            }
        }

        System.out.printf("Cool threshold: %s%n", sum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", count);
        //coolEmojis.forEach(System.out::println);
        for(String s: coolEmojis){
            System.out.println(s);
        }

        }

        private static int getCool(String group) {
         int cool = 0;
            for (char c : group.toCharArray()) {
                cool += c;
            }
            return cool;
        }

        public static BigInteger Multiply(String s){
            BigInteger res = new BigInteger("1");
            int count = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    count++;
                    res = res.multiply(BigInteger.valueOf(Integer.parseInt(String.valueOf(c))));
                }
            }
            if(count!=0){
                return res;
            }else{
                return new BigInteger("0");
            }

        }
    }

