
public class Solution11 {
	public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left < right){
            int temp = Math.max(height[left], height[right]) * (right - left + 1);
            if(temp > max)
                max = temp;
            if(height[left + 1] > height[left])
                left++;
            else if(height[right- 1] > height[right])
                right--;
        }
        return max;
    }
}
