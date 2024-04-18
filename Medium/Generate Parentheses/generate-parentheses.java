//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {

    
    public List<String> AllParenthesis(int n) {
         int openCount = 0;
         int closeCount = 0;
         List<String> answer = new ArrayList<>();
         generateParenthesisHelper(openCount, closeCount, new StringBuilder(), n, answer);
         return answer;
    }

    private void generateParenthesisHelper(int openCount, int closeCount, StringBuilder parenthesis, 
                                            int n, List<String> answer) {
        if (openCount == n && openCount == closeCount) {
            answer.add(parenthesis.toString());
            return;
        }

        if (openCount < n) {
            parenthesis.append("(");
            generateParenthesisHelper(openCount + 1, closeCount, parenthesis, n, answer);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }

        if (openCount > closeCount) {
            parenthesis.append(")");
            generateParenthesisHelper(openCount, closeCount + 1, parenthesis, n, answer);
            parenthesis.deleteCharAt(parenthesis.length() - 1); 
        }
    }
}