package main.Cap04_quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(quicksort(Arrays.asList(10,5,2,3,4,3,11)));
    }

    public static List<Integer> quicksort(List<Integer> numbers){

        if(numbers.size() < 2){
            return numbers;
        }

        Integer pivo = numbers.get(0);

        List<Integer> menor = numbers.stream()
                .skip(1)
                .filter(n -> n <= pivo).toList();
        List<Integer> maior = numbers.stream()
                .skip(1)
                .filter(n -> n > pivo).toList();

        return Stream.of(
                quicksort(menor).stream(),
                Stream.of(pivo),
                quicksort(maior).stream())
                .flatMap(Function.identity()).toList();
    }
}
