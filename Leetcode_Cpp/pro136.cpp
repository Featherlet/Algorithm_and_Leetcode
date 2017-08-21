#include<iostream>
#include<stdlib.h>
#include <vector>
#include<string>
#include<set>
#include <algorithm> 
using namespace std;

class Solution {
public:
	int singleNumber(vector<int>& nums) {
		int com = 0;
		if (nums.size() == 0)
			return com;
		for (int i = 0; i < nums.size(); i++)
			com = com ^ nums[i];
		return com;
	}
};