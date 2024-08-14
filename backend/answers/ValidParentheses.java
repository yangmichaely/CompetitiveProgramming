//alternate stack solution - if there is an opening character in the string, push the closing character counterpart onto the stack. If there is a closing character in the string, two things must be done. 1. check if the stack is empty and 2. pop off the top element in the stack and check if the element is not equal to c, the current character in the string. If either of these conditions turn out to be true, return false.

import java.util.Stack;

class Solution {
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(c == '{') stack.push('}');
			else if(c == '[') stack.push(']');
			else if(c == '(') stack.push(')');
			else if(stack.empty() || stack.pop() != c)return false;
		}
		return stack.empty();
	}
}