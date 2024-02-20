//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class delMiddle {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        Stack<Integer> temp = new Stack<>();
        int count;
        
        if(sizeOfStack % 2 == 0)
            count = -1;
        else 
            count = 0;
        
        
        for(int i=0; i<sizeOfStack; i++){
            count++;
            int v = s.pop();
            if(count == (sizeOfStack+1)/2)
                continue;
            else
                temp.push(v);
        }
        
        for(int i=0; i<sizeOfStack-1; i++) {
            s.push(temp.pop());
        }
    } 
}

