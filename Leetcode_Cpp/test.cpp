#include<iostream>
#include<stdlib.h>
#include <vector>
#include<string>
#include <unordered_map>
using namespace std;
#include "pro266.cpp"


class Point {
private:
	int x, y;
public:
	Point(int a, int b) : x(a), y(b) {
	}
	Point() {
		x = 0;
		y = 0;
	}
	Point(Point &p) {
		x = p.x;
		this->y = p.y;
	}
	void show() {
		cout << "Point(" << x << "," << y << ")" << endl;
	}
};

class Line {
private:
	Point p1, p2;
public:
	Line(Point &p1, Point &p2) {
		this->p1 = p1;
		this->p2 = p2;
	}

};

int main() 
{
	Solution sol;
	bool res = sol.canPermutePalindrome("aabbx");
	cout << res << endl;
	system("pause");
	
}