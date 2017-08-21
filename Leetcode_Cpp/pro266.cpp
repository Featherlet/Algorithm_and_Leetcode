#include<string>
#include<unordered_map>
using namespace std;

class Solution {
public:
	bool canPermutePalindrome(string s) {
		if (s.size() == 0)
			return false;
		if (s.size() == 1)
			return true;
		unordered_map<char, int> mymap;
		for (int i = 0; i < s.size(); i++) {
			if (mymap.find(s[i]) == mymap.end())
				mymap[s[i]] = 1;
			else
				mymap[s[i]]++;
		}

		int count = 0;
		for (unordered_map<char, int>::iterator it = mymap.begin(); it != mymap.end(); it++) {
			if (it->second % 2 == 1)
				count++;
		}
		if (count > 1)
			return false;
		else
			return true;
	}
};