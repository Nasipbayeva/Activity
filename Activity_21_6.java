package Activity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Activity_21_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter random integers.\nEnter 0 when finished: ");

        HashMap<Integer, Integer> num = new HashMap<>();
        int a;
        while ((a = scan.nextInt()) != 0) {
            if (!num.containsKey(a))
                num.put(a, 1);
            else
                num.put(a, num.get(a) + 1);
        }
        int max = Collections.max(num.values());

        System.out.print("The most occurrences integers are: ");
        for (Map.Entry<Integer, Integer> entry : num.entrySet()) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}

