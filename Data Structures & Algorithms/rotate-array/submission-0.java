class Solution {
    public void reverse(int [] arr, int si, int ei) {
        while(si<ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
}