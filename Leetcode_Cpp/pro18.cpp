#include <iostream>
#include <stdlib.h>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

class Solution {
public:
	vector<vector<int>> fourSum(vector<int>& nums, int target) {
		vector<vector<int>> res;
		if (nums.size() < 4)
			return res;
		sort(nums.begin(), nums.end());
		for (int i = 0; i < nums.size() - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.size() - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int left = j + 1;
				int right = nums.size() - 1;
				int newtar = target - nums[i] - nums[j];
				while (left < right) {
					if (nums[left] + nums[right] == newtar) {
						vector<int> sum(4);
						sum[0] = nums[i];
						sum[1] = nums[j];
						sum[2] = nums[left];
						sum[3] = nums[right];
						res.push_back(sum);
						while (left < right && nums[left] == nums[left + 1]) left++;
						while (left < right && nums[right] == nums[right - 1]) right--;
						left++;
						right--;
					}
					else if (nums[left] + nums[right] > newtar)
						right--;
					else
						left++;
				}
			}
		}
		return res;
	}
};