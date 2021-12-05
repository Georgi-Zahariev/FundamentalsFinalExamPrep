package Prep4;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        Map<String, Integer> participants = new TreeMap<>();
        Map<String, TreeMap<String,Integer>> groups = new LinkedHashMap<>();
        String nextLine = inp.nextLine();
        while (!nextLine.equals("no more time")) {
            String[] inputData = nextLine.split(" -> ");

            String name = inputData[0];
            String group = inputData[1];
            int num = Integer.parseInt(inputData[2]);

            if(!groups.containsKey(group)) {
                groups.put(group, new TreeMap<>());
                groups.get(group).put(name, num);

                if (!participants.containsKey(name)){
                        participants.put(name,num);
                } else {
                        participants.put(name,participants.get(name)+num);
                }
            }
            else{
                if(!groups.get(group).containsKey(name)) {
                    groups.get(group).put(name, num);
                    if (!participants.containsKey(name)) {
                        participants.put(name, num);
                  } else {
                       participants.put(name, participants.get(name) + num);
                    }
                }
                else{
                    int MaxNum =Math.max(num,groups.get(group).get(name));
                    int currNum=groups.get(group).get(name);
                    groups.get(group).put(name,MaxNum);
                    participants.put(name,participants.get(name) - currNum + MaxNum);
                }

                }
            nextLine = inp.nextLine();
        }

        /*
        AtomicInteger count = new AtomicInteger(0);
        System.out.println("Individual standing");
        int a =1;
        participants.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).limit(3)
                .forEach(entry -> {
                    System.out.printf("%f. %s -> %.2f%n", count.incrementAndGet() , entry.getKey(), entry.getValue());
                });
                */
        AtomicInteger count = new AtomicInteger(0);

       groups.entrySet().stream().forEach(entry -> {
           System.out.println(entry.getKey()+": "+entry.getValue().size()+" participants");
           entry.getValue().entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                   .forEach( e ->   System.out.println(count.incrementAndGet()+". "+e.getKey()+" <::> "+ e.getValue()));
           count.set(0);
       });

        System.out.println("Individual standings:");
        participants.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println( count.incrementAndGet()+ ". " + entry.getKey() +" -> "+ entry.getValue()));
    }
}
