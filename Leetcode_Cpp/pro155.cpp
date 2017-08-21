#include<vector>
#include<stack>
#include<algorithm>
using namespace std;

class MinStack {
public:
	/** initialize your data structure here. */
	vector<int> minBefore;
	int size;
	stack<int> mystack;

	MinStack() {
		size = 0;
	}

	void push(int x) {
		if (size == 0) {
			minBefore.push_back(x);
			mystack.push(x);
			size++;
		}
		else {
			minBefore.push_back(min(minBefore[size - 1], x));
			mystack.push(x);
			size++;
		}
	}

	void pop() {
		mystack.pop();
		minBefore.pop_back();
		size--;
	}

	int top() {
		return mystack.top();
	}

	int getMin() {
		return minBefore[size - 1];
	}
};