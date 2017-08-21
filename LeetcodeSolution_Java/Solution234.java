
public class Solution234 {
	public boolean isPalindrome(ListNode head) {
		if(head == null)
			return true;
        //find the middle place and reverse the second half 
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null)
                break;
            cur.next = next.next;
            next.next = slow.next;
            slow.next = next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        while(second != null){
        	if(first.val != second.val)
				return false;
        	first = first.next;
        	second = second.next;
        }
        return true;
    }
}
