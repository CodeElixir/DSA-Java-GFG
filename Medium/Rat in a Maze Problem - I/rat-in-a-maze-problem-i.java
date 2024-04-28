//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
       ArrayList<String> paths = new ArrayList<>();
       findPathHelper(0, 0, m, new StringBuilder(), paths, 'D');
       return paths;
    }
    
    private static void findPathHelper(int i, int j, int[][] m, StringBuilder path, ArrayList<String> paths, char direction) {
        if (i < 0 || j < 0 || i == m.length || j == m[0].length || m[i][j] == 0) {
            return;
        }
        
        if (i == m.length - 1 && j == m[0].length - 1) {
            path.append(direction);
            paths.add(path.toString());
            path.deleteCharAt(path.length() - 1);
            return;
        }
        
        m[i][j] = 0;
        if (i != 0 || j != 0) {
            path.append(direction);
        }
        findPathHelper(i + 1, j, m, path, paths, 'D');
        findPathHelper(i, j - 1, m, path, paths, 'L');
        findPathHelper(i, j + 1, m, path, paths, 'R');
        findPathHelper(i - 1, j, m, path, paths, 'U');
        if (path.length() > 0) {
            path.deleteCharAt(path.length() - 1);
        }
        m[i][j] = 1;
    }
}