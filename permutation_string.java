import java.io.*;
import java.util.*;

#Runtime :- O(n!)
class Solution {
  
  
  public static void permutation(String str) { 
    permutation("", str); 
  }
  
  private static void permutation(String pre, String str){
  
    int n = str.length();
    if ( n == 0){
      System.out.println(pre);
    }
    else{
    for (int i=0;i<n;i++){
     
      permutation(pre+str.charAt(i), str.substring(0,i)+str.substring(i+1,n));
    }
    }
  
  
  }
  
  
  public static void main(String[] args) {
    
    
    int i=3;
    StringBuilder sb=new StringBuilder();
    
    for (int j=1;j<=i;j++){
    
      sb.append("(");
      sb.append(")");
    
    }
    
    System.out.println(sb.toString());
    System.out.println("All Possible Permutations");
    String s = sb.toString();
    Solution.permutation(s);
    
    
    
  }
}

