#include <vector>
using namespace std;

class Solution {
public:
	int searchInsert(vector<int>& nums, int target) {
		int length = nums.size() - 1;
		return binarySearch(nums, target, 0, length);
	}

	int binarySearch(vector<int>& nums, int target, int start, int end) {
		if (start == end) {
			if (target > nums[start])
				return start + 1;
			else
				return start;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target)
			return mid;
		else if (nums[mid] > target) {
			if (mid > 0)
				return binarySearch(nums, target, start, mid);
			else
				return 0;
		}
		else {
			if (mid < nums.size() - 1)
				return binarySearch(nums, target, mid + 1, end);
			else
				return mid + 1;
		}
	}
};