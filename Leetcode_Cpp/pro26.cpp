#include<iostream>
#include<stdlib.h>
#include <vector>
using namespace std;

class Solution {
public:
	int removeDuplicates(vector<int> &nums) {
		int counter = 0;
		int index1 = 0, index2 = 0;
		while (index2 < nums.size()) {
			//two indeces meet
			if (index1 == index2) {
				counter++;
				index2++;
			}
			else {
				//index 2 has the same value with index1
				if (nums[index1] == nums[index2])
					nums.erase(nums.begin() + index2);
				//if index2 reach a new value
				else
					index1 = index2;
			}
		}
		return counter;
	}
	
};