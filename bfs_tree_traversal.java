import java.io.*;
import java.util.*;

/*          10
 *    9            8
 * 7                  4
                    3      2  
 *
 * If you need more classes, simply define them inline.
 */
// This code can be used to solve 3 different problems:-
// 1) Level by Level tree node printing.
// 2) BFS Tree Traversal
// 3) Finding height of the tree in non recursive approach

class TreeNode{
  
  int val;
  TreeNode left;
  TreeNode right;
  
  TreeNode(int data){
    val = data;
  }

}


class Solution {
  
  public TreeNode root;
  
  //Set<Integer> se = new HashSet<Integer>();
  String bfs = "";
  StringTokenizer st;
  
  public void bfsTraversal() {
    
    Queue<TreeNode> clevel = new LinkedList<TreeNode>();
    Queue<TreeNode> nlevel = new LinkedList<TreeNode>();
    
    if(root!=null){
      clevel.add(root);
    }
    
    while(!clevel.isEmpty()){
      
      Iterator<TreeNode> it = clevel.iterator();
      
      while(it.hasNext()){
        TreeNode cur = it.next();
        System.out.print("\t"+cur.val);
        bfs = bfs + cur.val + " ";  
        if(cur.left != null){
        nlevel.add(cur.left);
        }
        if(cur.right != null){
        nlevel.add(cur.right);
        }  
        
      }
      
      System.out.println();
      clevel = nlevel;
      nlevel = new LinkedList<TreeNode>();
    
    }
    
    st = new StringTokenizer(bfs, " ");
    
  }

  /*
  Print level order of tree alternative method without queues.
  */
  public void printLevelOrder(Node root)
  {
    int h = height(root);
    int i;
    for (i=1; i<=h; i++)
    {
        printGivenLevel(root, i);
        System.out.println();
    }
  }
  /* Print nodes at a given level */
  void printGivenLevel(Node root, int level)
  {
    if (root == null)
        return;
    if (level == 1)
        System.out.println(root.data);
    else if (level > 1)
    {
        printGivenLevel(root.left, level-1);
        printGivenLevel(root.right, level-1);
    }
  }
/* 
The time complexity of the above solution is O(n2)
*/

  
  public boolean hasnext(){
    if(st.hasMoreTokens()){
      return true;
    }
    return false;
    
  }
  
  public String next(){
    
    return st.nextToken();
    
  }
  
  public static void main(String[] args) {
    
    Solution sol = new Solution();
    sol.root = new TreeNode(10);
    sol.root.left = new TreeNode(9);
    sol.root.right = new TreeNode(8);
    sol.root.left.left = new TreeNode(7);
    sol.root.right.right = new TreeNode(4);
    sol.root.right.right.left = new TreeNode(3);
    sol.root.right.right.right = new TreeNode(2);
   
    sol.bfsTraversal();
    
    while (sol.hasnext()){
    
      System.out.println(sol.next());
    }
    
    
    
  }
}

