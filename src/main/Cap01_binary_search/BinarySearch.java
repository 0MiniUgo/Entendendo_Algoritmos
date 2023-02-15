package main.Cap01_binary_search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12};

        System.out.println(binarySearch(numbers, 6));
        System.out.println(binarySearch(numbers, -1));
    }

    public static Integer binarySearch(int[] numbers, int wanted){
        int left = 0;
        int right = numbers.length - 1;

        if(numbers.length == 0) return null;

        while (left <= right){
            int mid = (left + right) / 2;
            int number = numbers[mid];

            if (wanted == number){
                return mid;
            } else if (wanted > number){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return null;
    }
}
