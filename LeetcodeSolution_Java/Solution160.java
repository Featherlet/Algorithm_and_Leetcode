
public class Solution160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    public int getLength(ListNode head){
        int count = 0;
        ListNode p = head;
        while(p != null){
            count++;
            p = p.next;
        }
        return count;
    }
}
