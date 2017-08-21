
public class Solution148 {
	public ListNode sortList(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p != null){
        	count++;
        	p = p.next;
        }
        subsort(head, 0, count - 1);
        return head;
    }
	
	public void subsort(ListNode head, int start, int end){
		if(head == null || (end - start) < 1)
			return;
		int index = FindMid(head, start, end);
		if(index == start)
			subsort(head, start + 1, end);
		else if(index == end)
			subsort(head, start, end - 1);
		else{
			subsort(head, start, index - 1);
			subsort(head, index + 1, end);
		}
	}
	
	public int FindMid(ListNode head, int low, int high){
		int value = getNode(head, low).val;
		while(low < high){
			while(low < high && getNode(head, high).val >= value)
				high--;
			getNode(head, low).val = getNode(head, high).val;
			while(low < high && getNode(head, low).val <= value)
				low++;
			getNode(head, high).val = getNode(head, low).val;
		}
		getNode(head, low).val = value;
		return low;
	}
	
	public ListNode getNode(ListNode head, int index){
		ListNode p = head;
		if(index == 0)
			return head;
		for(int i = 0; i < index; i++)
			p = p.next;
		return p;
	}
}
