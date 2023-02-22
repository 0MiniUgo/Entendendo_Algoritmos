package main.Cap09_dynamic_programming;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {

        int[][] hish_fish = longestCommonSubstring("hish", "fish");
        int[][] hish_vista = longestCommonSubstring("hish", "vista");
        int[][] fosh_fort = longestCommonSubstring("fosh", "fort");
        int[][] fosh_fish = longestCommonSubstring("fosh", "fish");

        printTable(hish_fish);
        printTable(hish_vista);
        printTable(fosh_fort);
        printTable(fosh_fish);
    }

    private static int[][] longestCommonSubstring(String word1, String word2){

        int[][] table = new int[word1.length()][word2.length()];

        for(int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {

                if(word1.charAt(i) == word2.charAt(j)){
                    if(i > 0 && j > 0){
                        table[i][j] = table[i - 1][j - 1] + 1;
                    }else{
                        table[i][j] = 1;
                    }
                }else{
                    table[i][j] = 0;
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
