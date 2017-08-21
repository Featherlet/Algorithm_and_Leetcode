#include<iostream>
#include<stdlib.h>
#include <vector>
#include<string>
using namespace std;

class Solution {
public:
	string multiply(string num1, string num2) {
		string res = string(num1.size() + num2.size(), '0');
		for (int i = num1.size() - 1; i >= 0; i--) {
			int carry = 0;
			for (int j = num2.size() - 1; j >= 0; j--) {
				int temp = (res[i + j + 1] - '0') + (num1[i] - '0') * (num2[j] - '0') + carry;
				res[i + j + 1] = '0' + temp % 10;
				carry = temp / 10;
			}
			res[i] += carry;
		}
		size_t index = res.find_first_not_of("0");
		if (index != string::npos) {
			res = res.substr(index);
			return res;
		}
		else return "0";
	}
};