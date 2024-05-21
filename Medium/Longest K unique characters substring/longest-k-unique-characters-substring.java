//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        char[] freq = new char[128];
        int max = 0;
        char[] chars = s.toCharArray();
        int count = 0;
        int left = 0;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            freq[chars[i]]++;
            count = getDistinctChars(freq);
            
            if (count > k) {
                freq[chars[left++]]--;
                count = getDistinctChars(freq);
            }
            
            if (count <= k) {
                flag = (count == k);
                max = Math.max(max, i - left + 1);
            }
            
        }
        
        if (!flag) {
            return -1;
        }
        
        return max;
        
    }
    
    private int getDistinctChars(char[] freq) {
        int count = 0;
        for (int i : freq) {
            if (i > 0) {
                count++;
            }
        }
        return count;
    }
}