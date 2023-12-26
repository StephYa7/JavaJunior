package Prac_1.Task_2;

import java.util.Arrays;

public class HW {

    static void printAverageEvenNumber(int... numbers) {
        if (numbers.length < 2) {
            System.out.println("The number of digits must be more than one");
            return;
        }
        System.out.println(Arrays.stream(numbers)
                .filter(i -> i % 2 == 0)
                .average()
                .orElse(0));
    }
}