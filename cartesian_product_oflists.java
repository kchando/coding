import java.io.*;
import java.util.*;

/* Cartesian Product of a List of Lists
 * input a list of array [[1, 2, 3], [1], [1, 2]] return the list of array, each array is a combination of one element in each array [[1, 1, 1], [1, 1, 2], [2, 1, 1], [2, 1, 2], [3, 1, 1], [3, 1, 2]]
 * 
 */

public class Solution {
    public static void generate(int[][] sets) {
    int solutions = 1;
    for(int i = 0; i < sets.length; solutions *= sets[i].length, i++);
    for(int i = 0; i < solutions; i++) {
        int j = 1;
        for(int[] set : sets) {
            System.out.print(set[(i/j)%set.length] + " ");
            j *= set.length;
        }
        System.out.println();
    }
}

public static void main(String[] args) {
    generate(new int[][]{{1,2,3},{1},{1,2}} );
}
   
  
}

