import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
UBR:- 
https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
*/
public class Solution {
    
    public static boolean isBST(Integer pre[], int n) {
        Stack<Integer> s = new Stack<Integer>();
        
        int root = Integer.MIN_VALUE;
        
        for (int i=0; i < n ; i++) {
            if (pre[i] < root) {
                return false;
            }
            
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
                
            }
            
            s.push(pre[i]);
        }
        
        return true;
        
    }
        
    

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        //Int[] arr = new Int[]{1,3,2};
        Solution sol = new Solution();
        //Integer[] arr = new Integer[5];
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine();
        
        for(int i=0; i <n ; i++) {
        
         int len = scanner.nextInt();
         Integer[] arr = new Integer[len];
         scanner.nextLine();
         //System.out.println(len);
        int j=0;
         for (int k=0; k <len ; k++) {
             
                 arr[k] = scanner.nextInt();

         }
    
         if (Solution.isBST(arr, len) == true) {
            System.out.println("YES");
         } else {
             System.out.println("NO");
         }
         
         if (scanner.hasNext()){
            scanner.nextLine();
         }
    } 
        
    }
    
}
