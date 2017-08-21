#include <iostream>
#include <stdlib.h>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	int threeSumSmaller(vector<int>& nums, int target) {
		if (nums.size() < 3)
			return 0;
		int mingap = INT_MAX;
		int res = 0;
		sort(nums.begin(), nums.end());
		int count = 0;
		for (int i = 0; i < nums.size() - 2; i++) {
			int left = i + 1;
			int right = nums.size() - 1;
			while (left < right) {
				if (nums[left] + nums[right] + nums[i] < target) {
					count += right - left;
					left++;
				}
				else {
					right--;
				}
			}
		}
		return count;
	}
};