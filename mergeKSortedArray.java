import java.io.*;
import java.util.*;

/*
 * Using Priority Queue as Heap to merge K Sorted arrays
 */

class Solution {
  
  class EachArray implements Comparable<EachArray> {
    int[] arr;
    int index;
    
    public EachArray(int []arr, int index){
      this.arr = arr;
      this.index = index;
      
    }
    
    @Override
    public int compareTo(EachArray e){
      return this.arr[this.index] - e.arr[e.index];
    }  
    
  }
  
  public int[] mergeKSortedArray (int[][] arr){
    
    //Priority Queue is Heap in Java
    PriorityQueue<EachArray> pq = new PriorityQueue<EachArray>();
    int total = 0;
    // Add arrays to PriorityQueue.
    for (int i=0;i<arr.length;i++){
      pq.add(new EachArray(arr[i],0));
      total += arr[i].length;
    }
    
    int c = 0;
    int[] result = new int[total];
    
    // while heap is not empty pop the elements in ascending order.
    while(!pq.isEmpty()){
        EachArray e = pq.poll();
        result[c++] = e.arr[e.index];
        
      if(e.index < e.arr.length-1){
        pq.add(new EachArray(e.arr, e.index+1));
      } 
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    
    int[] arr1 = {1,3,5,7};
    int[] arr2 = {2,4,6,8};
    int[] arr3 = {0,9,10,11};
    
    Solution sol = new Solution();
    
    int[] result = sol.mergeKSortedArray(new int[][]{arr1,arr2,arr3});
    System.out.println(Arrays.toString(result));
    
  }
}

