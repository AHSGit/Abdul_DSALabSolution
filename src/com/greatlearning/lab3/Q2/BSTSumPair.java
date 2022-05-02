package com.greatlearning.lab3.Q2;

import java.util.HashSet;

public class BSTSumPair {
	
	static boolean status = false;
	
	//Inner class to represent a Node, which is made static so that main() can access it
	static class Node {
		int key;
		Node leftNode;
		Node rightNode;
	}
	
	// Utility function for creating a new Node
	static Node newNode(int key) {
		Node temp = new Node();	
		temp.key = key;
		temp.leftNode = null;
		temp.rightNode = null;
	
		return temp;
	}
	
	// Method to insert a new node
	static Node insertNode(Node root, int key) {
			
		if (root == null)
            return newNode(key);
		
        if (key < root.key)
            root.leftNode = insertNode(root.leftNode, key);
        
        else
            root.rightNode = insertNode(root.rightNode, key);
        
        return root;
	}
	
	// Method to traverse BST by InOrder and find pairs using HashSet
	static boolean findPairInOrder(Node root, HashSet<Integer> set, int sum) {
		
		//	Instead of using stopping condition as:
		//     if (root == null)
		//		return false;
		//	I've used a while loop that will also check if more than one sum-pair is present in the BST
		
		while (root != null) { //Stopping condition
			
			if(findPairInOrder(root.leftNode, set, sum)) //Recursion for left subtrees
				status = true;
		
		// To check the difference between given sum and node’s value inside the set 
		// In case it is found then sum-pair exists, else not 
			if(set.contains(sum - root.key)) {	
				System.out.print("Pair is (" + (sum - root.key) + ", " + root.key + ")\n");
				status = true;
			}
			
		// To traverse BST and insert node’s value into a set if above condition is not met
			else
				set.add(root.key); 
			
			return findPairInOrder(root.rightNode, set, sum); //Recursion for right subtrees
			
		} return status;
	}
	
	
	static void findSumPair(Node root, int sum)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        
        // To check for negative outcomes
        if (!findPairInOrder(root, set, sum) && status == false)
            System.out.print("Nodes are not found!");
    }
	
	//Driver code
	public static void main(String[] args) {
		
		Node root = null;

        // Insert the key values
		root = insertNode(root, 40);
		root = insertNode(root, 20);
		root = insertNode(root, 60);
		root = insertNode(root, 10);
		root = insertNode(root, 30);
		root = insertNode(root, 50);
		root = insertNode(root, 70);
		
		
		int sum =130;
		findSumPair(root, sum);
	}	
}
