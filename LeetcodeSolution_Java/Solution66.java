
public class Solution66 {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for(int i = digits.length - 1; i >= 0; i--){			
			int newval = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;
			digits[i] = newval;
			if(carry == 0)
				break;
		}
		if(carry == 1){
			int newdigits[] = new int[digits.length + 1];
			newdigits[0] = 1;
			for(int i = 0; i < digits.length; i++)
				newdigits[i + 1] = digits[i];
			return newdigits;
		}
		return digits;
    }
}
