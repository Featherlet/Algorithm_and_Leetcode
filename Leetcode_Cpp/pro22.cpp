#include <vector>
#include <string>
#include<iostream>
using namespace std;

class Solution {
public:
	vector<string> generateParenthesis(int n) {
		string line = "";
		vector<string> res;
		backTracking(res, line, 0, 0, n);
		return res;
	}

	void backTracking(vector<string> &res, string line, int leftNum, int rightNum, int n) {
		if (leftNum == rightNum && leftNum == n) {
			res.push_back(line);
			return;
		}
		if (leftNum == rightNum) {
			line += '(';
			backTracking(res, line, leftNum + 1, rightNum, n);
		}
		else if (leftNum == n) {
			line += ')';
			backTracking(res, line, leftNum, rightNum + 1, n);
		}
		else if (leftNum < rightNum) {
			cout << "error" << endl;
		}
		else {
			line += '(';
			backTracking(res, line, leftNum + 1, rightNum, n);
			line = line.substr(0, line.size() - 1);
			line += ')';
			backTracking(res, line, leftNum, rightNum + 1, n);
			line = line.substr(0, line.size() - 1);
		}
	}
};