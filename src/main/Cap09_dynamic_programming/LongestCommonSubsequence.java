package main.Cap09_dynamic_programming;

import java.util.Arrays;
import java.util.stream.Stream;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

        int[][] hish_fish = longestCommonSubsequence("hish", "fish");
        int[][] fosh_fort = longestCommonSubsequence("fosh", "fort");
        int[][] fosh_fish = longestCommonSubsequence("fosh", "fish");

        printTable(hish_fish);
        printTable(fosh_fort);
        printTable(fosh_fish);

    }

    private static int[][] longestCommonSubsequence(String word1, String word2){

        int[][] table = new int[word1.length()][word2.length()];

        for(int i = 0; i < word1.length(); i++){
            for(int j = 0; j < word2.length(); j++){

                if(word1.charAt(i) == word2.charAt(j)){
                    if(i > 0 && j > 0){
                        table[i][j] = table[i - 1][j - 1] + 1;
                    }else{
                        table[i][j] = 1;
                    }
                }else{
                    if(i == 0 && j > 0){
                        table[i][j] = table[i][j - 1];

                    }else if(i > 0 && j == 0){
                        table[i][j] = table[i - 1][j];

                    }else if(i > 0 && j > 0){
                        table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);

                    }else{
                        table[i][j] = 0;
                    }
                }
            }
        }
        return table;
    }

    private static void printTable(int[][] table){

        for(int[] row : table){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
