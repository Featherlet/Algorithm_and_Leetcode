import java.util.ArrayList;

public class Solution6 {
	public String convert(String s, int numRows) {
		int len = s.length();
		if(numRows >= s.length() || numRows == 1){
			return s;
		}
		//ArrayList<Character> chars = new ArrayList<Character>();
		char[] chars = new char[s.length()];
		int counter = 0;;
		int groupLength = 2 * numRows - 2;
		int groupNum = s.length() / groupLength;
		//The first line
		for(int i = 0; i * groupLength < s.length(); i++){
			int index = i * groupLength;
			//chars.add(s.charAt(i * groupLength));
			chars[counter++] = s.charAt(i * groupLength);
		}
		//The middle lines
		for(int i = 1; i < numRows - 1; i++){
			int term1 = 2 * (numRows - 1 - i);
			int term2 = 2 * i;
			int index = i;
			//chars.add(s.charAt(index));
			chars[counter++] = s.charAt(index);
			for(int j = 1; ; j++){
				if(j % 2 == 0)
					index = index + term2;
				else 
					index += term1;
				if(index >= s.length())
					break;
				//chars.add(s.charAt(index));
				chars[counter++] = s.charAt(index);
			}
		}
		//The last line
		for(int i = 0; i * groupLength + numRows - 1 < s.length(); i++){
			int index = i * groupLength + numRows - 1 ;
			//chars.add(s.charAt(i * groupLength + numRows - 1));
			chars[counter++] = s.charAt(index);
		}
		String str = String.valueOf(chars);
		return str;
    }
}
