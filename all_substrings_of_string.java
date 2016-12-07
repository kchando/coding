import java.io.*;
import java.util.*;

/*
 * For a string of length n there will be (n(n+1))/2 non empty substrings and one more which is empty string. Empty string is considered to be substring of every string also known as NULL string
 */

class Solution {
  public static void main(String[] args) {
    
    String s = "read";
    
    int n=s.length();
    
    for (int i=0; i<=s.length(); i++){
      
      for (int j=i+1; j <= s.length(); j++){
        
        System.out.println(s.substring(i,j));
        
      }
      
    }
    
  }
}

