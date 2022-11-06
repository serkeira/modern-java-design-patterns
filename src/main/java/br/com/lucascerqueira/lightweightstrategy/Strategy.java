package br.com.lucascerqueira.lightweightstrategy;

import java.util.List;
import java.util.function.IntPredicate;

public class Strategy {
    public static int totalValues(List<Integer> numbers, IntPredicate selector) {
        int total = 0;

        for (var number : numbers) {
            if (selector.test(number)) {
                total += number;
            }
        }

        return total;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValues(numbers, ignore -> true));
        System.out.println(totalValues(numbers, number -> number % 2 == 0));
        System.out.println(totalValues(numbers, Strategy::isOdd));
        System.out.println(totalValues(numbers, Strategy::isEven));
    }
}