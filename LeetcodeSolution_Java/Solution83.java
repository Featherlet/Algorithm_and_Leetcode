
public class Solution83 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
        ListNode p = head;
        while(p.next != null){
        	ListNode next = p.next;
        	if(p.val == next.val){
        		ListNode temp = next;
        		p.next = next.next;
        		temp = null;
        	}else
        		p = p.next;
        }
        return head;
    }
}
