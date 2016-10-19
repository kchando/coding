import java.io.*;
import java.util.*;

/*
 * Reverse a Single Linked List Using Recursion 
 * Input : 1->2->3->4
 * Output: 4->3->2->1
 * Reference:- http://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
 */


class Node {

  Node next;
  int data;
  
public Node (int data) {
this.data = data;  
}

}  

class Solution {
  
  Node root;
  Node temp;
  
  public void print(Node li){
  
    while(li!=null){
      System.out.println(li.data);
      li= li.next;
    }
    
  }
  
public Node Reverse(Node li) {

    if ( li == null) {
    return null;
    }

    if ( li.next == null ) {
    return li;
    }
// 1 -> 2
// 2 -> 1
    Node se = li.next;

    li.next = null;

    Node rest = Reverse(se);

    se.next = li;

    return rest;

}
  
  public static void main(String[] args) {
    
    Solution s = new Solution();
    s.root = new Node(1);
    s.root.next = new Node(2);
    s.root.next.next = new Node(3);
    s.root.next.next.next = new Node(4);
    s.temp = s.root.next.next.next;
    
    s.print(s.root);
    s.Reverse(s.root);
    System.out.println("After Reverse--------------------------------");
    s.print(s.temp);
    
    
    
  }
}

