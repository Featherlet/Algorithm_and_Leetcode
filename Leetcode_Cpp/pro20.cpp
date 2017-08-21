#include<string>
#include <stack>
using std::string;
using std::stack;

class Solution {
public:
	bool isValid(string s) {
		stack<char> charStack;
		int len = s.length();
		for (int i = 0; i < len; i++)
		{
			if (isLeft(s[i]))
				charStack.push(s[i]);
			else
			{
				if (charStack.empty())
					return false;
				else
				{
					char c = charStack.top();
					if (!isMatched(c, s[i]))
						return false;
					charStack.pop();
				}
			}
		}
		if (charStack.empty())
			return true;
		else
			return false;
	}

private:
	bool isLeft(char c) 
	{
		if (c == '(' || c == '[' || c == '{')
			return true;
		return false;
	}

	bool isMatched(char a, char b)
	{
		if (a == '(' && b == ')')
			return true;
		if (a == '[' && b == ']')
			return true;
		if (a == '{' && b == '}')
			return true;
		return false;
	}
};