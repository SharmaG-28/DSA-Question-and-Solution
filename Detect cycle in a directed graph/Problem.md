# Detect cycle in a directed graph

Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

# Example 1:
Input:  
  0 -----> 1  
           |  
           |  
-->3<------2  
|__|  
  
Output: 1  
Explanation: 3 -> 3 is a cycle

# Your task:
You dont need to read input or print anything.  
Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency  list adj as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.  
In the adjacency list adj, element adj[i][j] represents an edge from i to j.  

#
Expected Time Complexity: O(V + E)  
Expected Auxiliary Space: O(V)


# Constraints:
1 ≤ V, E ≤ 105

