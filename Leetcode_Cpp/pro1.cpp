#include<iostream>
#include<stdlib.h>
#include <vector>
#include<string>
#include <map>
using namespace std;

class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		map<int, int> mymap;
		vector<int> res;
		for (int i = 0; i < nums.size(); i++) {
			if (mymap.find(target - nums[i]) == mymap.end())
				mymap[nums[i]] = i;
			else {
				res.push_back(mymap[target - nums[i]]);
				res.push_back(i);
				return res;
			}
		}
		return res;
	}
};