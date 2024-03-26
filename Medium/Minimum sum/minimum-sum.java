//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            String ans = new Solution().solve(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends

 
//User function Template for Java





class Solution {
    String solve(int[] arr, int n) {
        Arrays.sort(arr);
        StringBuilder minSum = new StringBuilder();
        int carry = 0;
        for (int i = n - 1; i >= (n % 2 == 0 ? 0 : 1); i = i - 2) {
            int sum = arr[i] + arr[i - 1] + carry;
            minSum.insert(0, sum % 10);
            carry = sum / 10;
        }
        
        
        if (n % 2 != 0) {
            int sum = (arr[0] + carry);
            minSum.insert(0, sum % 10);
        } else {
            minSum.insert(0, carry);
        }
        

        while ((minSum.charAt(0) == '0') && (minSum.length() > 1)) {
            minSum.deleteCharAt(0);
        }
        
        return minSum.toString();
    }
}
