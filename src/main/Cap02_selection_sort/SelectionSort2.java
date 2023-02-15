package main.Cap02_selection_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort2 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5,3,6,2,10));
        System.out.println(selectionSort(numbers));
    }

    public static List<Integer> selectionSort(List<Integer> numbers){

        List<Integer> newNumbers = new ArrayList<>(numbers.size());

        int size = numbers.size();
        for(int i = 0; i < size; i++){

            int smallest = findSmallest(numbers);
            newNumbers.add(numbers.get(smallest));
            numbers.remove(smallest);
        }

        return newNumbers;
    }
    public static int findSmallest(List<Integer> numbers){

        int smallest = numbers.get(0);
        int smallestIndex = 0;

        for (int i = 1; i < numbers.size(); i++){
            if(numbers.get(i) < smallest){
                smallest = numbers.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
