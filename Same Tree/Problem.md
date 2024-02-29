# Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.  
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

# Example 1:

Input:
   Tree p           Tree q
     1               1
    / \             / \
   2   1           2   1
  /             / 
 3             3   

Enter values for tree node p:
Enter value (or -1 for null): 1
Enter left for 1:
Enter value (or -1 for null): 2
Enter left for 2:
Enter value (or -1 for null): 3
Enter left for 3:
Enter value (or -1 for null): -1
Enter right for 3:
Enter value (or -1 for null): -1
Enter right for 2:
Enter value (or -1 for null): -1
Enter right for 1:
Enter value (or -1 for null): 1
Enter left for 1:
Enter value (or -1 for null): 2
Enter left for 2:
Enter value (or -1 for null): 3
Enter left for 3:
Enter value (or -1 for null): -1
Enter right for 3:
Enter value (or -1 for null): -1
Enter right for 2:
Enter value (or -1 for null): -1

Output: true

# Constraints:
The number of nodes in both trees is in the range [0, 100].  
-104 <= Node.val <= 104