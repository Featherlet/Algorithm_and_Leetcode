
struct ListNode {
	 int val;
	 ListNode *next;
	 ListNode(int x) : val(x), next(nullptr) {}	
};

class Solution {
public:
	ListNode* swapPairs(ListNode* head) {
		if (head == nullptr || head->next == nullptr)
			return head;
		ListNode *p1, *p2, *prior, *after;
		p1 = head;
		p2 = head->next;
		after = p2->next;
		head = p2;
		p2->next = p1;
		p1->next = after;

		prior = p1;
		p1 = prior->next;
		if (p1 == nullptr)
			return head;
		p2 = p1->next;
		if (p2 == nullptr)
			return head;
		after = p2->next;

		while (p2 != nullptr)
		{
			prior->next = p2;
			p2->next = p1;
			p1->next = after;
			//move to the next two nodes
			prior = p1;
			p1 = prior->next;
			if (p1 == nullptr)
				break;
			p2 = p1->next;
			if (p2 == nullptr)
				break;
			after = p2->next;
		}
		return head;
	}
};