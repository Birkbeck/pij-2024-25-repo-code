package pij.day10;

import java.util.ArrayList;
import java.util.List;

public class Day10Exercise3 {
    public void launch(int userInput) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        try {
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Day10Exercise3 launcher = new Day10Exercise3();
        //launcher.launch(0);
        //launcher.launch(2);
        //launcher.launch(4);
        //launcher.launch(6);
    }
}
