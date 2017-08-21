import java.util.Arrays;

public class Solution322 {
	public int coinChange(int[] coins, int amount) {
		if(amount == 0)
			return 0;
		Arrays.sort(coins);
        int[][] opt = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++)
            opt[i][0] = 0;
        for(int i = 1; i <= amount; i++)
            opt[0][i] = i % coins[0] == 0 ? i / coins[0] : 0;
        for(int i = 1; i < coins.length; i++)
            for(int j = 1; j <= amount; j++){
                if(j < coins[i])
                    opt[i][j] = opt[i - 1][j];
                else if(opt[i - 1][j] == 0){
                	if(j % coins[i] == 0)
                		opt[i][j] = j / coins[i];
                	else
                		opt[i][j] = 0;
                }else
                    opt[i][j] = Math.min(opt[i][j - coins[i]] + 1, opt[i - 1][j]);
            }
        if(opt[coins.length - 1][amount] == 0)
            return -1;
        else
            return opt[coins.length - 1][amount];
    }
}
