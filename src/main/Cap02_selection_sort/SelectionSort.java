package main.Cap02_selection_sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {5,3,6,2,10};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void selectionSort(int[] numbers){

        for(int i = 0; i < numbers.length; i++){
            int left = numbers[i];

            for(int j = i + 1; j < numbers.length; j++){
                int right = numbers[j];

                if(left > right){
                    numbers[i] = right;
                    numbers[j] = left;
                    left = right;
                }
            }
        }
    }


}
