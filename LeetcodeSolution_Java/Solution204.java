
public class Solution204 {
	public int countPrimes(int n) {
		if(n < 3)
			return 0;
		boolean[] notPrime = new boolean[n];
		int counter = 0;
		for(int i = 2; i < n; i++){
			if(notPrime[i] == false){
				counter++;
				for(int j = 2; i * j < n; j++)
					notPrime[i * j] = true;
			}
		}
		return counter;
	}
	
	/*public int countPrimes(int n) {
        int count = 0;
        if(n < 2)
        	return 0;
        for(int i = 2; i <= n; i++){
        	if(isPrime(i))
        		count++;
        }
        return count;
    }

	public boolean isPrime(int n){
		if(n == 0)
			return false;
		if(n == 1 || n == 2)
			return true;
		for(int i = 2; i <= Math.sqrt(n * 1.0); i++)
			if(n % i == 0)
				return false;
		return true;
	}*/
}
