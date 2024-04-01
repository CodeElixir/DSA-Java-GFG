//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
      long len = n;
      long sumN = (len * (len + 1)) / 2;
      long sumNSquares = (len * (len + 1) * (2 * len + 1)) / 6;
      long sum = 0;
      long sumSquares = 0;
       
      for (int i = 0; i < n; i++) {
          sum += (long) arr[i];
          sumSquares += (long) arr[i] * (long) arr[i];
      }
       
      long val1 = sumN - sum;
      long val2 = (sumNSquares - sumSquares) / val1;
      long missingNumber = (val1 + val2) / 2;
      long repeatingNumber = missingNumber - val1;
      int[] res = new int[]{(int) repeatingNumber, (int) missingNumber};
      return res;
    }
}