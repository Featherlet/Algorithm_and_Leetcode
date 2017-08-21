
public class Solution88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
        	for(int i = 0; i < n; i++)
        		nums1[i] = nums2[i];
        	return;
        }
        if(n == 0)
        	return;
        int index1 = m - 1;
        int index2 = n - 1;
        for(int i = m + n - 1; i >= 0; i--){
        	if(nums1[index1] > nums2[index2]){
        		nums1[i] = nums1[index1];
        		index1--;
        	}else{
        		nums1[i] = nums2[index2];
        		index2--;
        	}
        	if(index2 < 0)
        		break;
        	if(index1 < 0 && index2 >= 0){
        		for(i = i - 1; i >=0; i--)
        			nums1[i] = nums2[index2--];
        		break;
        	}
        }
    }
}
