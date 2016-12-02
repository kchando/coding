import java.io.*;
import java.util.*;
public class Solution {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	
	    int j=0;
	    int sum=0;
	    int max = Integer.MIN_VALUE;
	    for (int i=0;i< a.size();i++){
	        sum+=a.get(i);
	        
	        max = Math.max(sum, max);
	      
	        if (sum < 0 ){
	           sum=0;
	           j=i+1;
	        }
	    }
	    
	    return max;
	    
	}
}

