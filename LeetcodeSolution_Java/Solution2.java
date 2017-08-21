
public class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int flag = 0;
        while(l1 != null || l2 != null){
        	int val1 = 0, val2 = 0;
        	if(l1 != null){
        		val1 = l1.val;
        		l1 = l1.next;
        	}
        	if(l2 != null){
        		val2 = l2.val;
        		l2 = l2.next;
        	}
        	int newNum = (val1 + val2 + flag) % 10;
        	flag = (val1 + val2 + flag) / 10;
        	if(tail == null)
        		head = tail = new ListNode(newNum);
        	else{
        		tail.next = new ListNode(newNum);
        		tail = tail.next;
        	}
        }
        if(flag == 1){
        	tail.next = new ListNode(1);
        	tail = tail.next;
        }
        tail.next = null;
        return head;
    }
        
}

