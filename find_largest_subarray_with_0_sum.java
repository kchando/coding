import java.io.*;
import java.util.*;

# Given an array of integers, find length of the largest subarray with sum equals to 0.
# Question asked in Juniper Interview
# Reference:- http://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
#input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
#Output: 5
#The largest subarray with 0 sum is -2, 2, -8, 1, 7

#Input: arr[] = {1, 2, 3}
#Output: 0
#There is no subarray with 0 sum

#Input: arr[] = {1, 0, 3}
#Output: 1


class MaxLenZeroSumSub {
 
   //((O)n^2) Solution traditional.  Returns length of the largest subarray with 0 sum
   int maxLen(int arr[], int n)
   {
    int max_len = 0; // Initialize result
 
    // Pick a starting point
    for (int i = 0; i < n; i++)
    {
        // Initialize currr_sum for every starting point
        int curr_sum = 0;
 
        // try all subarrays starting with 'i'
        for (int j = i; j < n; j++)
        {
            curr_sum += arr[j];
 
            // If curr_sum becomes 0, then update max_len
            // if required
            if (curr_sum == 0)
               max_len = max(max_len, j-i+1);
        }
    }
    return max_len;
    
    }
    
    // (O(n)) Solution using Hashing.  Returns length of the maximum length subarray with 0 sum
    static int maxLen(int arr[])
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
 
        int sum = 0;      // Initialize sum of elements
        int max_len = 0;  // Initialize result
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // Add current element to sum
            sum += arr[i];
 
            if (arr[i] == 0 && max_len == 0)
                max_len = 1;
 
            if (sum == 0)
                max_len = i+1;
 
            // Look this sum in hash table
            Integer prev_i = hM.get(sum);
 
            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
               max_len = Math.max(max_len, i-prev_i);
            else  // Else put this sum in hash table
               hM.put(sum, i);
        }
 
        return max_len;
    }
 
    // Drive method
    public static void main(String arg[])
    {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is "
                           + maxLen(arr));
    }
}
