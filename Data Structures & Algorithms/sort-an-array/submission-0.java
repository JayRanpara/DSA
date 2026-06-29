class Solution {

    public void conqueure(int[] nums, int si, int mid, int ei) {
        int merged[] = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int count = 0;
        while(idx1<=mid&&idx2<=ei) {
            if(nums[idx1]<=nums[idx2]) {
                merged[count++] = nums[idx1++];
            }
            else {
                merged[count++] = nums[idx2++];
            }
        }
        while(idx1<=mid) {
            merged[count++] = nums[idx1++];
        }
        while(idx2<=ei) {
            merged[count++] = nums[idx2++];
        }

        for(int i=0; i<merged.length; i++) {
            nums[si+i] = merged[i];
        }
    }

    public void divide(int[] nums, int si, int ei) {
        if(ei<=si) {
            return;
        }
        int mid = si+(ei-si)/2;
        divide(nums,si,mid);
        divide(nums,mid+1,ei);
        conqueure(nums,si,mid,ei);
    }
    
    public int[] sortArray(int[] nums) {
        divide(nums,0,nums.length-1);
        return nums;
    }
}