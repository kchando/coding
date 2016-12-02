# Reference:- https://www.interviewbit.com/problems/square-root-of-integer/
import java.io.*;
import java.util.*;

public class Solution {
	public int sqrt(int a) {
	    
	    if (a==0){
	        return 0;
	    }
	 int start = 1;
	 int end=a;
	 int ans=0;
	 
	# Using binary search approach to reduce run time to O(log n) 
	while (start <= end){
	 
	     int mid = (start+end)/2;
	     
	     if (mid <= a/mid){
	         start = mid+1;
	         ans = mid;
	     }else {
	         end = mid-1;
	     }
	 
	 }
	 
	 return ans;
	 
	    
	}
}

