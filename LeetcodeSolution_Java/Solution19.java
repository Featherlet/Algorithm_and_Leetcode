
public class Solution19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p;
		ListNode newHead;
		if(head.next == null){
			newHead = null;
			return newHead;
		}
		p = head;
		int counter = 1;
		while(p.next != null){
			counter++;
			p = p.next;
		}
		int realN = counter - n + 1;
		ListNode prior, after;
		if(realN == 1){
			p = head.next;
			newHead = new ListNode(p.val);
			p = p.next;
			ListNode np = newHead;
			while(p != null){
				np.next = new ListNode(p.val);
				p = p.next;
				np = np.next;
			}
			np.next = null;
		}else if(realN == counter){
			p = head;
			newHead = new ListNode(p.val);
			ListNode np = newHead;
			p = p.next;
			for(int i = 1; i < counter - 1; i++){
				np.next = new ListNode(p.val);
				p = p.next;
				np = np.next;
			}
			np.next = null;
		}else{
			prior = after = head;
			newHead = new ListNode(head.val);
			ListNode np = newHead;
			p = head.next;
			for(int i = 1; i < realN - 1; i++){
				np.next = new ListNode(p.val);
				prior = p;
				p = p.next;
				np = np.next;
			}
			after = p.next;
			while(after != null){
				np.next = new ListNode(after.val);
				np = np.next;
				after = after.next;
			}
			p = null;
			np.next = null;
		}
		return newHead;
    }
}
