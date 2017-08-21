#include <iostream>
#include <stdlib.h>
#include <set>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	/*int lengthOfLongestSubstring(string s) {
		if (s.length() == 0)
			return 0;
		set<char> record;
		int maxlen = 0;
		int i = 0, j = 0;
		set<char>::iterator it;
		while (j < s.length()) {
			if (record.find(s[j]) == record.end()) {
				record.insert(s[j]);
				j++;
				maxlen = max(maxlen, (int)record.size());
			}
			else
				record.erase(s[i++]);
		}
		return maxlen;
	}*/

	int lengthOfLongestSubstring(string s) {
		if (s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		vector<int> record(256, -1);
		int start = -1;
		int i = 0, maxlen = 0;
		for (int i = 0; i < s.size(); i++) {
			if (record[s[i]] <= start) {
				record[s[i]] = i;
				maxlen = max(maxlen, i - start);
			}
			else {				
				start = record[s[i]];
				record[s[i]] = i;
			}
		}
		return maxlen;
	}
};