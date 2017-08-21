import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Node> explored = new HashMap<String, Node>();
        Queue<String> q = new LinkedList<String>();
        
        //we need to initial neighbirs
        HashMap<String, ArrayList<String>> neighbor = new HashMap<String, ArrayList<String>>();
        neighbor.put(beginWord, new ArrayList<String>());
        for(int i = 0; i < wordList.size(); i++){
        	if(isNeighbor(beginWord, wordList.get(i)))
        		neighbor.get(beginWord).add(wordList.get(i));
        }
        for(int i = 0; i < wordList.size(); i++){
            neighbor.put(wordList.get(i), new ArrayList<String>());
            for(int j = 0; j < wordList.size(); j++)
            	if(isNeighbor(wordList.get(i), wordList.get(j)))
            		neighbor.get(wordList.get(i)).add(wordList.get(j));
        }
        q.add(beginWord);
        Node n = new Node(beginWord);
        explored.put(beginWord, n);
        while(!q.isEmpty()){
        	int size = q.size();
        	while(size > 0){
        		String str = q.poll();
        		List<String> neigh = neighbor.get(str);
                for(int i = 0; i < neigh.size(); i++){
                    if(!explored.containsKey(neigh.get(i))){
                        if(isNeighbor(str, neigh.get(i))){
                            Node node = new Node(neigh.get(i));
                            node.pre = str;
                            explored.put(neigh.get(i), node);
                            if(neigh.get(i).equals(endWord)){
                                int count = 1;
                                String s = str;
                                while(s != null){
                                    count++;
                                    s = explored.get(s).pre;
                                }
                                return count;
                            }else{
                            	q.add(neigh.get(i));
                            }                         
                        }
                    }   
                }
        		size--;
        	}
            
        }
        return 0;
    }
	
	private boolean isNeighbor(String a, String b){
		if(a.length() != b.length())
			return false;
		int count = 0;
		for(int i = 0; i < a.length(); i++)
			if(a.charAt(i) != b.charAt(i))
				count++;
		if(count == 1)
			return true;
		return false;
	}
    class Node{
        public String str = null;
        public String pre = null;
        public Node(String s){
            str = s;
        }
    }
    
}
