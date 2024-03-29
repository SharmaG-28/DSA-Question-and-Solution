# Pairs with Positive Negative values
Given an array of integers, print all the pairs having positive and negative values of a number that exists in the array.  
NOTE: If no such pair exists, simply return an empty array, also multiple pairs of the same number could exist and you need to print each of them separately.

# Example 1:
Input:  
n = 8  
a [ ] = {1, -3, 2, 3, 6, -1, -3, 3}  
Output:  
-1 1 -3 3 -3 3  
Explanation:  
The array contains both 1 and -1, and 3 & -3 two times.

# Example 2:
Input:  
n = 8  
a [ ] = {4, 8, 9, -4, 1, -1, -8, -9}  
Output:  
-1 1 -4 4 -8 8 -9 9  
Explanation:  
Here, the array contains the pairs 1 & -1, 4 & -4, 8 & -8, and 9 & -9.

# cYour Task:  
You don't need to read input or print anything.  
Your task is to complete the function PosNegPair() which takes the array a[] and its size n as inputs and returns all the required pairs in the increasing order of their absolute numbers.

#
Expected Time Complexity: O(nLog(n))  
Expected Auxiliary Space: O(n)

# Constraints:
1<=n<=105  
-105<=a[i]<=105
