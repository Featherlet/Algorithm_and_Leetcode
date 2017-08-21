
public class CountInversion {
	public int count(int[] nums){
		int[] temp = new int[nums.length];
		return sortCount(nums, 0, nums.length - 1, temp);
	}
	
	private int sortCount(int[] nums, int left, int right, int[] temp){
		if(left == right){
			temp[0] = nums[left];
			return 0;
		}
		int mid = (right + left) / 2;
		int[] temp1 = new int[mid - left + 1];
		int[] temp2 = new int[right - mid];
		int lcount = sortCount(nums, left, mid, temp1);
		int rcount = sortCount(nums, mid + 1, right, temp2);
		int mcount =  mergeCount(temp1, temp2, temp);
		return lcount + rcount + mcount;
	}
	
	private int mergeCount(int[] a, int[] b, int[] res){
		int len1 = a.length;
		int len2 = b.length;
		int i = 0, j = 0, k = 0;
		int count = 0;
		while(i < len1 && j < len2){
			if(a[i] < b[j]){
				res[k++] = a[i++];
			}else{
				res[k++] = b[j++];
				count += len1 - i;
			}
		}
		if(i == len1){
			while(j < len2)
				res[k++] = b[j++];
		}
		if(j == len2){
			while(i < len1)
				res[k++] = a[i++];
		}
		return count;
	}
	
}
