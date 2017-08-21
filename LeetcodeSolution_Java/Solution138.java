import java.util.HashMap;
import java.util.Map;

public class Solution138 {
	/*public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        RandomListNode newhead = new RandomListNode(head.label);
        map.put(head.label, head.random);
        RandomListNode p = head;
        RandomListNode cur = newhead;
        while(p.next != null){
            p = p.next;
            RandomListNode newnode = new RandomListNode(p.label);
            map.put(p.label, p.random);
            cur.next = newnode;
            cur = cur.next;
        }
        cur.next = null;
        p = newhead;
        while(p != null){
            RandomListNode ran = map.get(p.label);
            if(ran == null)
                p.random = null;
            else
                p.random = findNode(newhead, ran.label);
            p = p.next;
        }
        return newhead;
    }
    
    private RandomListNode findNode(RandomListNode head, int label){
        RandomListNode p = head;
        while(p != null){
            if(p.label == label)
                return p;
            p = p.next;
        }
        return null;
    }*/
	
	public RandomListNode copyRandomList(RandomListNode head){
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode node = head;
		while(node != null){
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}
		
		node = head;
		RandomListNode newhead, p;
		newhead = map.get(node);
		newhead.next = map.get(node.next);
		newhead.random = map.get(node.random);
		node = node.next;
		p = newhead.next;
		while(node != null && p != null){
			p.next = map.get(node.next);
			p.random = map.get(node.random);
			p = p.next;
			node = node.next;
		}
		return newhead;
	}
}
