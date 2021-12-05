package Prep3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        Pattern pattern = Pattern.compile("(?<symbol>[@#])(?<name1>[A-Za-z]{3,})\\1\\1(?<name2>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> mirror = new ArrayList<>();
        int cnt=0;
        while( matcher.find()){
            cnt++;
           StringBuilder n1 = new StringBuilder(matcher.group("name1"));
            StringBuilder n2 = new StringBuilder(matcher.group("name2"));
            if(n1.toString().equals(n2.reverse().toString())){
                mirror.add(String.format("%s <=> %s", n1,n2.reverse()));
            }

        }
        if(cnt==0){
            System.out.println("No word pairs found!");
        }else{
            System.out.printf("%s word pairs found!%n",cnt);
        }

        if(mirror.size()<1){
            System.out.println("No mirror words!");
        }else{
            System.out.printf("The mirror words are:%n%s", String.join(", ", mirror) );
        }

    }
}
