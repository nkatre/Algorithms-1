package com.shubham.ds;

public class InfixToPostFix {
	
	public String getPostFixFromInfix(String infix) throws Exception {
		Stack stack = new Stack();
		String sb = "";
		char[] charArr = infix.toCharArray();
		for(char character : charArr) {
			if(!InfixToPostFix.isOperator(character)) {
				sb += character;
			} else {
				// if it is an operator
				while(!stack.isEmpty() && precedence(stack.top.getInfo().charAt(0), character)) {
					String top = stack.pop().getInfo();
					sb += top.toString();
				}
				stack.push(Character.toString(character));
			}
		}
		
		while(!stack.isEmpty()) {
			sb += stack.pop();
		}
		return sb;
	}
	
	private boolean precedence(char operator1, char operator2) throws Exception {
		if(operator1 == '+' & operator2 == '*') return false;
		if(operator1 == '*' & operator2 == '+') return true;
		throw new Exception("Don't know what to do for this precendence rule");
	}
	
	private static boolean isOperator(char c) {
		if(c == '+' || c == '-'|| c == '*'|| c == '/') return true;
		return false;
	}
	
}
