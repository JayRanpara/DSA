class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m-1;
        int lastzero = nums1.length-1;
        int j = n-1;
        while(last>=0&&j>=0) {
            if(nums1[last]>nums2[j]) {
                nums1[lastzero] = nums1[last];
                last--;
            }
            else {
                nums1[lastzero] = nums2[j];
                j--;
            }
            lastzero--;
        }
        while(j>=0) {
            nums1[lastzero--] = nums2[j--];
        }
    }
}