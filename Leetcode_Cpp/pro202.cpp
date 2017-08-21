#include<iostream>
#include<stdlib.h>
#include <vector>
#include<string>
#include<set>
#include <algorithm> 
using namespace std;

class Solution {
public:
	bool isHappy(int n) {
		set<int> myset;
		return judge(n, myset);
	}

	bool judge(int i, set<int>& myset) {
		if (myset.find(i) != myset.end())
			return false;
		else if (i == 1)
			return true;
		else {
			myset.insert(i);
			int sum = 0;
			while (i > 0) {
				sum += (i % 10) * (i % 10);
				i = i / 10; 
			}
			return judge(sum, myset);
		}
	}
};