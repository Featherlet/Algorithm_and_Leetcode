#include <iostream>
#include <stdlib.h>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

class Solution {
public:
	vector<vector<int>> threeSum(vector<int>& nums) {		
		vector<vector<int>> res;
		if (nums.size() < 3)
			return res;
		sort(nums.begin(), nums.end());
		for (int i = 0; i < nums.size() - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			unordered_map<int, int> hash;
			int target = 0 - nums[i];
			int left = i + 1;
			int right = nums.size() - 1;
			while (left < right) {
				if (nums[left] + nums[right] == target) {
					vector<int> sum;
					sum.push_back(nums[i]);
					sum.push_back(nums[left]);
					sum.push_back(nums[right]);
					res.push_back(sum);
					while (left < right && nums[left + 1] == nums[left]) left++;
					while (left < right && nums[right - 1] == nums[right]) right--;
					left++;
					right--;
				}
				else if (nums[left] + nums[right] < target) 
					left++;
				else
					right--;
			}
		}
		return res;
	}
};