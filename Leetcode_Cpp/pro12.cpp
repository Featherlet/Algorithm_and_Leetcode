#include <iostream>
#include <stdlib.h>
#include <map>
#include <algorithm>
using namespace std;

class Solution {
private:
	map<int, string> itr;
	map<char, int> rti;
	int units[7] = { 1, 5, 10, 50, 100, 500, 1000 };

public:
	Solution() {
		/*itr.insert(pair<int, string>(1, "I"));
		itr.insert(pair<int, string>(5, "V"));
		itr.insert(pair<int, string>(10, "X"));
		itr.insert(pair<int, string>(50, "L"));
		itr.insert(pair<int, string>(100, "C"));
		itr.insert(pair<int, string>(500, "D"));
		itr.insert(pair<int, string>(1000, "M"));*/
		itr.insert(pair<int, string>(4, "IV"));
		itr.insert(pair<int, string>(9, "IX"));
		itr.insert(pair<int, string>(90, "XC"));
		itr.insert(pair<int, string>(900, "XM"));
	}
	string intToRoman(int num) {
		string str = "";
		int thou = num / 1000;
		if (thou > 0) {
			for (int i = 0; i < thou; i++)
				str += "M";
		}
		num = num % 1000;
		int hun = num / 100;
		if (hun == 9)
			str += "CM";
		else if (hun >= 5) {
			str += "D";
			hun -= 5;
			for (int i = 0; i < hun; i++)
				str += "C";
		}
		else if (hun == 4)
			str += "CD";
		else if (hun > 0) {
			for (int i = 0; i < hun; i++)
				str += "C";
		}
		num = num % 100;
		int ten = num / 10;
		if (ten == 9)
			str += "XC";
		else if (ten >= 5) {
			str += "L";
			ten -= 5;
			for (int i = 0; i < ten; i++)
				str += "X";
		}
		else if (ten == 4)
			str += "XL";
		else if(ten > 0){
			for (int i = 0; i < ten; i++)
				str += "X";
		}
		num = num % 10;
		if (num == 9)
			str += "IX";
		else if (num >= 5) {
			str += "V";
			num -= 5;
			for (int i = 0; i < num; i++)
				str += "I";
		}
		else if(num == 4)
			str += "IV";
		else if (num > 0) {
			for (int i = 0; i < num; i++)
				str += "I";
		}

		return str;
	}

	
};