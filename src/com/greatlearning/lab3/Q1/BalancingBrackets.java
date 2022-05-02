package com.greatlearning.lab3.Q1;

import java.util.Stack;

public class BalancingBrackets {
	
	// Method to check if the brackets are balanced using Stack
	static boolean checkBrackets(String expression) {
		
		Stack<Character> stack = new Stack<Character>();
		
		// Loop to return the char value at the specified index of this string
		for(int i = 0; i < expression.length(); i++) {	
			
			char character = expression.charAt(i);			
			
			// Push char value to stack if opening bracket is encountered 
			if(character == '(' || character == '{' || character == '[') {
				stack.push(character);
				continue;
			}
			
			// Stack cannot be empty at this point as the current character 
            // must be a closing bracket if it's not an opening bracket
			if (stack.isEmpty())
                return false;
			
			char ch;			
			switch(character) {
			
			case ')': 
				ch = stack.pop();			// If popped character is the matching 
				if(ch == '{' || ch == '[')	// opening bracket, then bracket is balanced
					return false;
				break;
			
			case '}':
				ch = stack.pop();
				if(ch == '(' || ch == '[')
					return false;
				break;
				
			case ']':
				ch = stack.pop();
				if(ch == '(' || ch == '{')
					return false;
				break;			
			}
			
		} return stack.isEmpty(); // If brackets are balanced, stack will be empty after the loop
		
	}

	// Driver code
	public static void main(String[] args) {
		String expression = "([[{}]]))";
		
		if(checkBrackets(expression))
			System.out.println("The entered String has Balanced Brackets!");
		
		else
			System.out.println("The entered String does not contain Balanced Brackets!");

	}

	

}
