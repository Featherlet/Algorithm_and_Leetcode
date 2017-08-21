

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode *head;
		ListNode *tail = nullptr;
		head = tail;
		int flag = 0;
		while (l1 != nullptr || l2 != nullptr) {
			if (l1 == nullptr) {
				if (tail == nullptr) {
					head = tail = new ListNode((l2->val + flag) %10);
				}
				else {
					tail->next = new ListNode((l2->val + flag) % 10);
					tail = tail->next;
				}
				if (l2->val + flag >= 10)
					flag = 1;
				else
					flag = 0;
			}
			else if (l2 == nullptr) {
				if (tail == nullptr) {
					head = tail = new ListNode((l1->val + flag) % 10);
				}
				else {
					tail->next = new ListNode((l1->val + flag) % 10);
					tail = tail->next;
				}
				if (l1->val + flag >= 10)
					flag = 1;
				else
					flag = 0;
			}
			else {
				if (tail == nullptr) {
						head = tail = new ListNode((l1->val + l2->val + flag) % 10);
				}
				else {
					tail->next = new ListNode((l1->val + l2->val + flag) % 10);
					tail = tail->next;
				}
				if (l1->val + l2->val + flag >= 10)
					flag = 1;
				else
					flag = 0;
			}
			if(l1 != nullptr)
				l1 = l1->next;
			if (l2 != nullptr)
				l2 = l2->next;
		}
		if (flag == 1) {
			tail->next = new ListNode(1);
			tail = tail->next;
		}
		tail->next = nullptr;
		return head;
	}
};