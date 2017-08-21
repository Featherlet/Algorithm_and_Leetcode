import java.util.ArrayList;
import java.util.Stack;


public class Solution20 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			if(isLeft(s.charAt(i)))
				stack.push(s.charAt(i));
			else{
				if(stack.isEmpty())
					return false;
				char c = stack.pop();
				if(!isMatched(c, s.charAt(i)))
					return false;
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	private boolean isLeft(char c){
		if(c == '(' || c == '[' || c == '{')
			return true;
		return false;
	}
	
	private boolean isMatched(char a, char b){
		if(a == '(' && b == ')')
			return true;
		if(a == '[' && b == ']')
			return true;
		if(a == '{' && b == '}')
			return true;
		return false;
	}
}
