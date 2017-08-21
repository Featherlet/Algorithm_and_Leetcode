class Solution {
public:
	bool isPalindrome(int x) {
		int y = x;
		int sum = 0;
		while (y > 0) {
			sum = sum * 10 + y % 10;
			y /= 10;
		}
		if (sum == x)
			return true;
		else
			return false;
	}
};