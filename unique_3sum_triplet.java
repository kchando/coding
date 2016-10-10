import java.io.*;
import java.util.*;

/*
 * Find all unique triplets in the array which gives the sum of zero.
 * Using HashSet for collecting unique triplets in ArrayList. Also Called as 3SUM Problem 
 */

class Solution {
  
  
  public ArrayList<ArrayList<Integer>> findTriplet(int[] arr) {
    
    Arrays.sort(arr);
    
    // Handle Duplicates by using HAshset for collecting the triplets in ArrayList
    HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
    
    for(int i =0 ; i< arr.length-2; i++){
    
      int j = i+1;
      int k = arr.length-1;
      
      while (j < k){
        int sum = arr[i]+arr[j]+arr[k];
        
        if (sum == 0) {
          
          ArrayList<Integer> inner = new ArrayList<Integer>();
          
          //System.out.println("Found : " + arr[i] +","+arr[j]+","+arr[k]);
          inner.add(arr[i]);
          inner.add(arr[j]);
          inner.add(arr[k]);
          hs.add(inner);
          j++;
          k--;
          
        }else if (sum > 0) {
          k--;
        } else if (sum < 0 ){
          j++;
        }
      }
    
    }
    return new ArrayList<ArrayList<Integer>>(hs);
  
  }
  
  
  
  
  public static void main(String[] args) {
    
    Solution sol = new Solution();
  
    int[] inp = new int[]{-1, 0, 1, 2, -1, -4};
    
    System.out.println(sol.findTriplet(inp));
    
    
    
  }
}

