//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        if (root == null) {
            return 0;
        }
        Map<Node, Node> parentMap = new HashMap<>();
        Map<Node, Boolean> visitedMap = new HashMap<>();
        Node targetNode = mapParent(root, parentMap, target);
        Deque<Node> queue = new ArrayDeque<>();
        visitedMap.put(targetNode, true);
        queue.addLast(targetNode);
        int minTime = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int flag = 0;
            for (int i = 0; i < size; i++) {
                Node node = queue.removeFirst();
                Node parent = parentMap.get(node);
                if (parent != null && !visitedMap.containsKey(parent)) {
                    flag = 1;
                    queue.addLast(parent);
                    visitedMap.put(parent, true);
                }
                
                if (node.left != null && !visitedMap.containsKey(node.left)) {
                    flag = 1;
                    queue.addLast(node.left);
                    visitedMap.put(node.left, true);
                }
                
                if (node.right != null && !visitedMap.containsKey(node.right)) {
                    flag = 1;
                    queue.addLast(node.right);
                    visitedMap.put(node.right, true);
                }
                
            }
            
            if (flag != 0) {
                minTime++;
            }
        }
        return minTime;
        
    }
    
    private static Node mapParent(Node root, Map<Node, Node> parentMap, int target) {
        if (root == null) {
            return null;
        }
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        parentMap.put(root, null);
        Node targetNode = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.removeFirst();
                if (node.data == target) {
                    targetNode = node;
                }
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    queue.addLast(node.left);
                }
                
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    queue.addLast(node.right);
                }
            }
        }
        return targetNode;
    }
}