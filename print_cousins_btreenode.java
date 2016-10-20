import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 Print cousins of a given node in Binary Tree. Siblings should not be included. 
             1
           /   \
          2     3
        /   \  /  \
       4    5  6   7
 
 If given node is 5, Output will be 6, 7. sibling 4, should not be included.  
 */
// The important thing to remember is when talking about level, it starts from 1 and the level of the root is 1.Note that the depth of the root is 0.

class Node {
  
    Node left;
    Node right;
    int data;
    
    public Node(int data) {
      this.data=data;
    }
    
  }

class Solution {
  
  public Node root;
  
  
  int getLevel(Node root, Node fnode, int level){
    
    if(root == null) {
      return 0;
    }
    if (root == fnode){
      return level;
    }
    int dlevel = getLevel(root.left, fnode, level+1);
    if (dlevel != 0){
      return dlevel;
    }
    
    return getLevel(root.right, fnode, level+1);
  }
  
  void printCousin(Node root, Node fnode, int level){
    if (root == null || level < 2) {
      return;
    }
    
    if (level == 2 ) {
      if (root.left == fnode || root.right == fnode) {
        return;
      }
      if(root.left != null ) {
        System.out.println(root.left.data);
      }
      if(root.right != null ){
        System.out.println(root.right.data);
      }
      
    }
    
    if ( level > 2){
      printCousin(root.left, fnode, level-1);
      printCousin(root.right, fnode, level-1);
    
    }
  
  }
  
  public static void main(String[] args) {
    
    Solution sol = new Solution();
    sol.root = new Node(1);
    sol.root.left = new Node(2);
    sol.root.right = new Node(3);
    sol.root.left.left = new Node(4);
    sol.root.left.right = new Node(5);
    sol.root.right.left = new Node(6);
    sol.root.right.right = new Node(7);
    
    int level = sol.getLevel(sol.root, sol.root.left.right, 1);
    
    sol.printCousin(sol.root, sol.root.left.right, level);
    
  }
}

