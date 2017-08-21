#include<iostream>
#include<stdlib.h>
#include <vector>
#include<string>
#include <algorithm> 
using namespace std;

class Solution {
public:
	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		sort(candidates.begin(), candidates.end());
		vector<vector<int>> res;
		vector<int> combination;
		findCombination(candidates, target, 0, combination, res);
		return res;
	}

private:
	void findCombination(vector<int>& candidates, int target, int begin, vector<int>& combination, vector<vector<int>>& res) {
		if (target == 0) {
			res.push_back(combination);
		}
		else {
			for (int i = begin; i < candidates.size() && candidates[i] <= target; i++) {
				combination.push_back(candidates[i]);
				findCombination(candidates, target - candidates[i], i, combination, res);
				combination.pop_back();
			}
		}
	}
};