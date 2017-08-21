import java.util.List;

public class Solution139 {
	public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int[][] opt = new int[len][len];
        for(int i = 0; i < len; i++){
        	opt[i][i] = inDict(s.substring(i, i + 1), wordDict) ? 1 : 0;
        }
        //g = j - i
        for(int g = 1; g < len; g++){
        	//calculate each opt[i][j] of length g
        	for(int i = 0; i < len - g; i++){
        		int j = i + g;
        		//if the substring itself can match the dict
        		if(inDict(s.substring(i, j + 1), wordDict)){
        			opt[i][j] = 1;
        			continue;
        		}
        		//else find the best split position
        		else{
        			for(int k = i; k < j; k++){
        				if(opt[i][k] == 1 && opt[k + 1][j] == 1){
        					opt[i][j] = 1;
        					break;
        				}
        			}
        		}
        	}
        }
        if(opt[0][len - 1] == 1)
        	return true;
        else 
        	return false;
    }
	
	public boolean inDict(String s, List<String> wordDict){
		for(int i = 0; i < wordDict.size(); i++)
			if(s.equals(wordDict.get(i)))
				return true;
		return false;
	}
}
