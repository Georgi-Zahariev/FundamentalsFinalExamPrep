package Prep2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        Pattern pattern = Pattern.compile("(?<separator>[\\/=])(?<name>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();
        int size=0;
        while( matcher.find()){
            destinations.add(matcher.group("name"));
            size+=matcher.group("name").length();
        }
        System.out.printf("Destinations: %s%n", String.join(", ", destinations) );
        System.out.printf("Travel Points: %s", size);
    }
}
