struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
	ListNode *detectCycle(ListNode *head) {
		if (head == nullptr)
			return nullptr;
		//set slow and fast pointer, they will meet at the node k steps 
		//before the begin of the cycle while k is the number of nodes before cycle
		//slow has (n - k) steps while fast has 2(n - k) = n + (n - 2k)
		ListNode *slow = head;
		ListNode *fast = head;
		while (fast->next != nullptr && fast->next->next != nullptr) {
			slow = slow->next;
			fast = fast->next->next;
			if (slow == fast)
				break;
		}
		if (fast->next == nullptr || fast->next->next == nullptr)
			return nullptr;
		//move slow to head, now both slow and fast are k steps away from 
		//the beginning
		slow = head;
		while (slow != fast) {
			slow = slow->next;
			fast = fast->next;
		}
		return slow;
	}
};