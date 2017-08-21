
public class Solution122 {
	public int maxProfit(int[] prices) {
		if(prices.length < 2)
			return 0;
        int buy = prices[0];
        int sell = prices[0];
        int value = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] < sell){
        		value += sell - buy;
        		buy = prices[i];
        	}
        	sell = prices[i];
        }
        value += sell - buy;
        return value;
    }
}
