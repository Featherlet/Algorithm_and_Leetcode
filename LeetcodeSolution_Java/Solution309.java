
public class Solution309 {
	public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2){
        	System.out.println("error input!");
        	return 0;
        }
        int op[] = new int[length];
        op[0] = 0;
        for(int i = 1; i < length; i++){       	
        	int profit = 0;
        	for(int j = 0; j < i; j++){
        		int temp = prices[i] - prices[j];
        		if(j >= 2)
        			temp += op[j - 2];
        		if(profit < temp)
        			profit = temp;
        	}
        	if(op[i - 1] < profit)
        		op[i] = profit;
        	else
        		op[i] = op[i - 1];
        }
        return op[length - 1];
    }
}
