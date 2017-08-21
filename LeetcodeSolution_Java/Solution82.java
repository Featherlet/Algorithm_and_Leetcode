
public class Solution82 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
        	return null;
		ListNode p = head;
        int flag = 0;
        ListNode pre = p;
        int value = p.val;
        while(p != null && p.next != null){
        	if(flag == 0){
        		if(p.next.val == p.val){
        			flag = 1;
        		}else{
        			pre = p;
        			p = p.next;
        		}
        	}else{
        		if(p == head){
        			ListNode next = p;
        			while(next != null && next.val == p.val)
        				next = next.next;
        			head = next;
        			p = pre = next;
        			flag = 0;
        		}else{
        			ListNode next = p;
        			while(next != null && next.val == p.val)
        				next = next.next;
        			pre.next = next;
        			p = next;
        			flag = 0;
        		}
        	}
        	
        }
        return head;
    }

}
