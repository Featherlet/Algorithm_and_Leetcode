#include <iostream>
#include <stdlib.h>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

public:
	int romanToInt(string s) {
		int sum = 0;
		for (int i = 0; i < s.size() - 1; i++) {
			if (number(s[i]) < number(s[i + 1])) {
				sum -= number(s[i]);
			}
			else {
				sum += number(s[i]);
			}
		}
		sum += number(s[s.size() - 1]);
		return sum;
	}

	int number(char c) {
		switch (c)
		{
			case 'I' : return 1; break;
			case 'V': return 5; break;
			case 'X': return 10; break;
			case 'L': return 50; break;
			case 'C': return 100; break;
			case 'D': return 500; break;
			case 'M': return 1000; 
			default: break;
		}
	}
};