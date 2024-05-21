//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        Map<Integer, Integer> buckets = new HashMap<>(3);
        int left = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            buckets.put(fruits[i], buckets.getOrDefault(fruits[i], 0) + 1);
            if (buckets.size() >= 3) {
                while (buckets.size() >= 3) {
                    buckets.put(fruits[left], buckets.get(fruits[left]) - 1);
                    if (buckets.get(fruits[left]) == 0) {
                        buckets.remove(fruits[left]);
                    }
                    left++;
                }
            }
            
            if (buckets.size() <= 2) {
                max = Math.max(max, i - left + 1);
            }
        }
        
        return max;
    }
}