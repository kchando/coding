import java.io.*;
import java.util.*;

/*
 * Given an array of random numbers, Push all the zeroâs of a given array to the end of the array. For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  // Quick Sort Pivot Method but the order of the input might be lost
  public void method1(int[] arr) {
    
    int left = 0;
    int right = arr.length-1;
    
    while (left < right ){
      
      while (arr[left] != 0 ) {
        left++;
      }
      
      if(left < right ) {
          int temp = arr[right];
          arr[right] = arr[left];
          arr[left] = temp;
          right--;
      }
      
    }
    
    System.out.println("After moving O's to end");
    System.out.println(Arrays.toString(arr));
  
  }
  
    // Traverse the array. If element encountered is
    // non-zero, then replace the element at index 'count'
    // with this element
  public void method2(int[] arr){
    
    int counter  = 0;
    int n = arr.length;
    for (int i=0; i< n; i++){
      if (arr[i] != 0){
        arr[counter++] = arr[i];
      }
      
    }
    
    while (counter < n) {
      arr[counter++] = 0;
    }
    
     
    System.out.println("After moving O's to end with original order maintained");
    System.out.println(Arrays.toString(arr));
    
  
  }
  
  public static void main(String[] args) {
   
    int[] inp = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
    
   Solution sol = new Solution();
   //sol.method1(inp);
    
    // Testing Java Pass By Value
    //System.out.println(Arrays.toString(inp));
    
    sol.method2(inp);
    
    
  }
}

