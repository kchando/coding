/*
 * Spiral print of a matrix
    
 * Define a method, which takes a rectangular matrix, and
 * does a spiral print of its contents.
    
 * See below for example matrices and the expected output.
    
 * Note: Please make sure to handle rectangular matrices
 * with non-equal number of columns and rows.
    
 * Given:
 * 0  1  2  3
 * 4  5  6  7
 * 8  9  10 11
 * 12 13 14 15
    
 * Output:
 * 0 1 2 3 7 11 15 14 13 12 8 4 5 6 10 9
    
    
 * 0  1  2  3  4
 * 5  6  7  8  9
 * 10 11 12 13 14
 * 15 16 17 18 19
 * 20 21 22 23 24
    
 * Output:
 * 0 1 2 3 4 9 14 19 24 23 22 21 20 15 10 5 6 7 8 13 18 17 16 11 12
    
    
 * 0  1  2  3  4  5
 * 17 18 19 20 21 6
 * 16 27 28 29 22 7
 * 15 26 25 24 23 8
 * 14 13 12 11 10 9
    
 * Output:
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
 */ 

import java.io.*;
import java.util.*;


class Solution {
  
  public ArrayList<Integer> spiralMatrix( int[][] matrix) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    if (matrix == null || matrix.length ==0) 
      return result;
    
    int m = matrix.length;
    int n = matrix[0].length;
    
    int x=0;
    int y=0;
    
    while (m > 0 && n >0 ) {
      
      if (m==1) {
        for (int i=0;i<n;i++){
          result.add(matrix[x][y++]);
        }
        break;
      } else if (n==1){
        for (int i=0;i<m; i++){
          result.add(matrix[x++][y]);
        }
        break;
      }
    
      
      
      // move right , down, left, up
      for ( int i=0; i < n-1; i++){
        result.add(matrix[x][y++]);
      }
      
      for (int i=0; i<m-1; i++){
        result.add(matrix[x++][y]);
      }
      
      for (int i=0; i<n-1; i++){
        result.add(matrix[x][y--]);
      }
      
      for (int i=0;i<m-1;i++){
        result.add(matrix[x--][y]);
      }
      
      x++;
      y++;
      m=m-2;
      n=n-2;
      
    
    }
    
    return result;
    
    
    
}
  
  
  
  public static void main(String[] args) {
 
        int[][] array = new int[][]{ 
        {0,1,2,3},
        {4,5,6,7},
        {8,9,10,11},
        {12,13,14,15}
    };
    int[][] array1 = new int[][]{ 
      {0,1,2,3,4},
      {5,6,7,8,9},
      {10,11,12,13,14},
      {15,16,17,18,19},
      {20,21,22,23,24}
  };
    Solution s = new Solution();

    System.out.println(s.spiralMatrix(array));
    System.out.println(s.spiralMatrix(array1));
  

}
}

