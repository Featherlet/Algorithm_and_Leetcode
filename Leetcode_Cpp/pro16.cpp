#include <iostream>
#include <stdlib.h>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	int threeSumClosest(vector<int>& nums, int target) {
		int mingap = INT_MAX;
		int res = 0;
		sort(nums.begin(), nums.end());
		for (int i = 0; i < nums.size() - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = nums.size() - 1;
			int newtar = target - nums[i];
			while (left < right) {
				if (nums[left] + nums[right] == newtar)
					return target;
				if (abs(nums[left] + nums[right] + nums[i] - target) < mingap) {
					mingap = abs(nums[left] + nums[right] + nums[i] - target);
					res = nums[i] + nums[left] + nums[right];
				}
				if (nums[left] + nums[right] > newtar)
					right--;
				else
					left++;
			}
		}
		return res;
	}
};