import java.io.*;
import java.util.*;

/*
 * Using Priority Queue as Heap to merge K Sorted arrays
 */

/*Complexity Analysis

Time complexity : O(Nlogk) where k is the number of linked lists.

The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
There are N nodes in the final linked list.
Space complexity :

O(n) Creating a new linked list costs O(n) space.
O(k) The code above present applies in-place method which cost O(1) space. And the priority queue (often implemented with heaps) costs O(k) space (it's far less than NN in most situations)
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

