// insertion sort
public class Solution147 {
	public ListNode insertionSortList(ListNode head) {
        ListNode n1 = head;
        ListNode n1pre = head;
		while(n1 != null){
			ListNode min = n1;
			ListNode minpre = n1pre;
			ListNode n2 = n1;
			ListNode n2pre = n1pre;
			while(n2 != null){
				if(n2.val < min.val){
					min = n2;
					minpre = n2pre;
				}
				if(n2 == head)
					n2 = n2.next;
				else{
					n2 = n2.next;
					n2pre = n2pre.next;
				}
			}
			int temp = n1.val;
			n1.val = min.val;
			min.val = temp;
			n1 = n1.next;
			n1pre = n1pre.next;
		}
		return head;
    }
}
