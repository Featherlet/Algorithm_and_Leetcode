
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) 
	{
		ListNode* head = nullptr;
		// if one of them is empty
		if (l1 == nullptr)
			return l2;
		if (l2 == nullptr)
			return l1;
		//put in the first elem into the new list
		ListNode *p = nullptr, *q = nullptr; // q is the last elem of new list and p is the new elem
		int n1 = l1->val;
		int n2 = l2->val;
		if (n1 < n2)
		{
			head = l1;
			l1 = l1->next;
			head->next = nullptr;
			q = head;
		}
		else
		{
			head = l2;
			l2 = l2->next;
			head->next = nullptr;
			q = head;
		}
			
		while (l1 != nullptr || l2 != nullptr)
		{
			if (l1 != nullptr && l2  != nullptr) //both lists has numbers
			{
				int n1 = l1->val;
				int n2 = l2->val;
				if (n1 < n2)
				{
					p = l1;
					l1 = l1->next;
					q->next = p;
					q = q->next;
					q->next = nullptr;
				}
				else
				{
					p = l2;
					l2 = l2->next;
					q->next = p;
					q = q->next;
					q->next = nullptr;
				}
			}
			else if (l1 == nullptr) // only list2 has numbers
			{
				q->next = l2;
				l2 = nullptr;
			}
			else //only list1 has numbers
			{
				q->next = l1;
				l1 = nullptr;
			}
		}
		return head;
	}
};