#include <iostream>
#include <stdlib.h>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
	int divide(int dividend, int divisor) {
		if (divisor == 0)
			return 0;
		//value = divisor * times
		long long value[33];
		long long times[33];
		int flag = 0;
		long long sum = 0;
		long long stop = 1;
		stop = stop << 31;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			flag = 1;
		long long a = (long long )abs((double)dividend);
		long long b = (long long)abs((double)divisor);
		value[0] = b;
		times[0] = 1;
		int i = 0;
		while (stop >= value[i]) {
			i++;
			value[i] = 2 * value[i - 1];
			times[i] = 2 * times[i - 1];
		}

		for (int j = i - 1; j >= 0; j--) {
			while (a >= value[j]) {
				a -= value[j];
				sum += times[j];
			}
		}
		sum = flag == 0 ? sum : - sum;
		if (sum >= INT_MAX)
			return INT_MAX;
		else if (sum <= INT_MIN)
			return INT_MIN;
		return (int)sum;
		
	}
};