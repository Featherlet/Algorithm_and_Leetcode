#include<iostream>
#include<stdlib.h>
#include <vector>
using namespace std;

class Solution {
public:
	int thirdMax(vector<int>& nums) {
		int max1, max2, max3;
		max1 = max2 = max3 = -999;
		int flag1, flag2, flag3;
		flag1 = flag2 = flag3 = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] == max1 || nums[i] == max2 || nums[i] == max3)
				continue;
			if (flag1 == 0 || nums[i] > max1) {
				if (flag1 == 1) {
					if (flag2 == 1)
						flag3 = 1;
					else
						flag2 = 1;
				}
				else
					flag1 = 1;
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			}
			else {
				if (flag2 == 0 || nums[i] > max2) {
					if (flag2 == 1)
						flag3 = 1;
					else
						flag2 = 1;
					max3 = max2;
					max2 = nums[i];
				}
				else {
					if (flag3 == 0 || nums[i] > max3) {
						flag3 = 1;
						max3 = nums[i];
					}
				}
			}
		}
		if (flag3 == 0)
			return max1;
		else
			return max3;
	}
};