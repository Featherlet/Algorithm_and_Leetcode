
public class Solution23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0 || lists == null)
			return null;
        return partition(lists, 0, lists.length - 1);
    }
	
	public ListNode partition(ListNode[] lists, int start, int end){
		if(start == end)
			return lists[start];
		int index = (start + end) / 2;
		ListNode l1 = partition(lists, start, index);
		ListNode l2 = partition(lists, index + 1, end);
		return mergeLists(l1, l2);
	}
	
	public ListNode mergeLists(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		if(l1.val < l2.val){
			l1.next = mergeLists(l1.next, l2);
			return l1;
		}else{
			l2.next = mergeLists(l1, l2.next);
			return l2;
		}
	}
	
}
