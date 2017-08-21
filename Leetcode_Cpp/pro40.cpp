#include<iostream>
#include<stdlib.h>
#include <vector>
#include<string>
#include<set>
#include <algorithm> 
using namespace std;

class Solution {
public:
	vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
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
				if (i > 0 && candidates[i] == candidates[i - 1] && i > begin)
					continue;
				combination.push_back(candidates[i]);
				findCombination(candidates, target - candidates[i], i + 1, combination, res);
				combination.pop_back();
			}
		}
	}
};