import java.util.HashMap;
import java.util.Map;

public class Solution146{
    DoubleLinkedList head = null;
    DoubleLinkedList tail = null;
    int count = 0;
    int capacity = 0;
    Map<Integer, DoubleLinkedList> cache = null;

    public Solution146(int capacity) {
        cache = new HashMap<Integer, DoubleLinkedList>();
        this.capacity = capacity;
        tail = new DoubleLinkedList(-1, 0);
        head = tail;
        tail.next = null;
        tail.pre = head;
    }
    
    public int get(int key) {
        DoubleLinkedList node = cache.get(key);
        if(node == null){
            return -1;
        }else{
            movetoHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        DoubleLinkedList node = cache.get(key);
        if(node == null){
            node = new DoubleLinkedList(key, value);
            addNew(node);
        }else{
            node.val = value;
            movetoHead(node);
        }
    }
    
    private void movetoHead(DoubleLinkedList node){
    	if(node == head)
    		return;
        DoubleLinkedList pren = node.pre;
        DoubleLinkedList postn = node.next;
        pren.next = postn;
        postn.pre = pren;
        node.next = head;
        head = node;
        node.next.pre = node;
    }
    
    private void deleteTail(){
        DoubleLinkedList cur = tail.pre;
        cur.pre.next = tail;
        tail.pre = cur.pre;
        cache.remove(cur.key);
        count--;
    }
    
    private void addNew(DoubleLinkedList node){
        node.next = head;
        head = node;
        node.next.pre = node;
        count++;
        if(count > capacity){
            deleteTail();
        }
        cache.put(node.key, node);
    }
    
    class DoubleLinkedList{
        public int key;
        public int val;
        DoubleLinkedList pre = null;
        DoubleLinkedList next = null;
        public DoubleLinkedList(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
}


