import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
// Ref:- http://www.sanfoundry.com/java-program-implement-evaluate-expression-using-stacks/
// Ref:- http://www2.lawrence.edu/fast/GREGGJ/CMSC150/071Calculator/Calculator.html

/****** Rules ******/
//If we encounter an operator token in the input and the operator stack is empty, we push the operator token onto the operator stack.
//If we encounter an operator token in the input with a precedence that is greater than the precedence of the operator token at the top of the operator stack, we push the new operator token onto the operator stack.
//If we encounter an operator token in the input with a precedence that is less than or equal to the precedence of the operator token at the top of the operator stack, we process and remove the operator at the top of the stack. This continues until the operator stack is empty or until an operator with lower precedence than the input operator appears at the top of the stack.
//When we reach the end of the input, any operators that remain on the operator stack are processed and removed until the operator stack is empty. At that point, there should be only one number token left on the value stack: that number is the result of the evaluation.


class Solution {
  
  
  public Double evaluateExpr(String s){
  
    Stack<Double> val = new Stack<Double>();
    Stack<Character> op = new Stack<Character>();
    
    Map<Character, Integer> hm = new HashMap<Character, Integer>();
    
    hm.put('*',2);
    hm.put('/',2);
    hm.put('+',1);
    hm.put('-',1);
    
    String temp="";
    for (int i=0; i < s.length(); i++){
      char ch = s.charAt(i);
      if(ch != '*' && ch != '/' && ch != '+' && ch != '-'){
          temp += ch;
      }else if(op.isEmpty() || hm.get(ch) > hm.get(op.peek()) ) {
        op.push(ch);
        val.push(Double.parseDouble(temp));
        temp = "";
      }else { 
        val.push(Double.parseDouble(temp));
        temp = "";
        while(!op.isEmpty() && hm.get(ch) <= hm.get(op.peek())) {
            double v1 = val.pop();
            double v2 = val.pop();
            char ev = op.pop();
            if ( ev == '*') { val.push(v2*v1); }
            else if( ev == '/') { val.push(v2/v1); }
            else if (ev == '+') { val.push(v2+v1); }
            else if (ev == '-') { val.push(v2-v1); } 
          
        }
        op.push(ch);
        
      }
      
    }
    val.push(Double.parseDouble(temp));
    
    while(!op.isEmpty()) {
            double v1 = val.pop();
            double v2 = val.pop();
            char ev = op.pop();
            if ( ev == '*') { val.push(v2*v1); }
            else if( ev == '/') { val.push(v2/v1); }
            else if (ev == '+') { val.push(v2+v1); }
            else if (ev == '-') { val.push(v2-v1); } 
    }
      
    
    
    return val.pop();
    
  }
  
  public static void main(String[] args) {
    
    Solution s = new Solution();
    
    double result = s.evaluateExpr("12.5*18+35.64/23.45+64.12-77.1+24/65+13.76+246.34-23*123+162.1+24*6-19+94");
    
    System.out.println(result);
    
    
    
  }
}

