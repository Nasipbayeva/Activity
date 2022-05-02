package Activity;

import java.util.ArrayList;

public class Activity_19_10 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(233);
        list.add(345);
        list.add(95);
        System.out.println(max(list));
    }
    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }
}

