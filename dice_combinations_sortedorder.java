import java.io.*;
import java.util.*;

/*
 * 1 Dice - 6 possible outcomes
 * 3 Dice - 6^3 = 216 Possible Outcomes
 * Print all the combinations in sorted order
 * 1 1 1 | 1 1 2 | 1 1 3| ...............6 1 1 | 6 1 2 | 6 1 3 | .......6 6 1 | 6 6 2....6 6 6
 */

public class Solution {
    public static void generate(int[][] sets) {
      
      int solutions=1;
      for (int i=0; i < sets.length; solutions *= sets[i].length,i++);
      
      for (int i =0 ; i<solutions; i++){
        int j=1;
        List<Integer> li = new ArrayList<Integer>();
        for (int[] set:sets){
          li.add(set[(i/j)%set.length]);
          j=j*set.length;
        }
      Collections.reverse(li);
      System.out.print(li);
      System.out.println();
    
}
    }

public static void main(String[] args) {
    generate(new int[][]{{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}});
}
   
  
}

