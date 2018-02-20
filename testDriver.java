package adt_project3;

import java.util.ArrayList;

public class testDriver {
	public static void main(String[] args){
		String infix = "2+3*4/5";
		GenericStack<String>stack = new GenericStack<String>();
		stack.push(infix);
		Expression exp = new Expression();
		ArrayList<String> result = new ArrayList<String>();
		result = exp.infixToPostfix(infix);
		String check = stack.peek();
		int result2 = exp.evaluate(result);
		System.out.println(check);
		System.out.println("");
		String convertedString = "";
		for(int i = 1; i <= 52; i++){
			System.out.println(i);
		}
		for(int i = 0; i < result.size();i++){
			convertedString  = convertedString + result.get(i);
		}
		System.out.println(convertedString);
		System.out.println("");
		System.out.println(result2);
		System.out.println("");
		for(int i = 0; i < result.size(); i++){
			System.out.print(result.get(i));
		}
	}
}
