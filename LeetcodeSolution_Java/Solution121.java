
public class Solution121 {
	public int maxProfit(int[] prices) {
		if(prices.length < 2)
			return 0;
        int[] delta = new int[prices.length];
        delta[0] = 0;
        for(int i = 1; i < prices.length; i++){
        	delta[i] = prices[i] - prices[i - 1];
        }
        int[] op = new int[prices.length];
        op[0] = 0;
        for(int i = 1; i < prices.length; i++){
        	int temp = op[i - 1] + delta[i];
        	if(temp <= 0)
        		op[i] = 0;
        	else
        		op[i] = op[i - 1] + delta[i];
        }
        int min, max = 0;
        min = max = op[0];
        for(int i = 1; i < op.length; i++){
        	if(op[i] > max)
        		max = op[i];
        	if(op[i] < min)
        		min = op[i];
        }
        return max - min;
    }
}
