
public class Solution206 {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode prehead = head;
        ListNode cur = prehead.next;
        while(cur != null){
        	prehead.next = cur.next;
        	cur.next = head;
        	head = cur;
        	cur = prehead.next;
        }
        return head;
    }
}
