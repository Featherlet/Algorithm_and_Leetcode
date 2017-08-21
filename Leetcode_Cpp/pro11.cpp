#include <iostream>
#include <stdlib.h>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	//My method, time exceeded.
	/*int maxArea(vector<int>& height) {
		if (height.size() == 2) {
			if (height[0] == 0 || height[1] == 0)
				return 0;
			else
				return  min(height[0],height[1]) * 1;
		}
		int contain = getMaxArea(height, 0, height.size() - 1);
		return contain;
	}
	int getMaxArea(vector<int>& height, int l, int r) {
		if(r - l == 1)
			return min(height[l], height[r]) * (r - l);
		else {
			int a1 = getMaxArea(height, l + 1, r);
			int a2 = getMaxArea(height, l, r - 1);
			int a = min(height[l], height[r]) * (r - l);
			return max(a, max(a1, a2));
		}
	}*/

	//best solution
	int maxArea(vector<int>& height) {
		int water = 0, i = 0, j = height.size() - 1;
		while (i < j) {
			int h = min(height[i], height[j]);
			water = max(water, (j - i) * h);
			while (height[i] <= h && i < j) i++;
			while (height[j] <= h && i < j) j--;
		}
		return water;
	}
};