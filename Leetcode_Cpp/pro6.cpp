#include<string>
using namespace std;

class Solution {
public:
	string convert(string s, int numRows) {
		string news(s);
		int lhalf = numRows;
		int shalf = numRows - 2;
		int sublen = lhalf + shalf;
		int len = s.size();
		int segNum = (len % sublen == 0) ? (len / sublen) : (len / sublen + 1);
		int index = 0;
		//first line
		for (int i = 0; i < len; i += sublen) {
			news[index++] = s[i];
		}
		//middle lines
		for (int i = 1; i < numRows - 1; i++) {
			int j = 0;
			for (int k = 0; i + j < len; k++) {
				news[index++] = s[i + j];
				if (k % 2 == 0) {
					j += sublen - 2 * i;
				}
				else {
					j += 2 * i;
				}
			}
		}
		//final line
		for (int i = numRows - 1; i < len; i += sublen) {
			news[index++] = s[i];
		}
		news[index] = '\0';
		return news;
	}
};