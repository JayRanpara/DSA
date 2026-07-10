class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        int i=0;
        int sum = 0;
        for(int j=0; j<nums.length; j++) {
            sum+=nums[j];
            while(sum>=target) {
                int len = j-i+1;
                min = Math.min(min,len);
                sum-=nums[i];
                i++;
            }
        }
        return (min==Integer.MAX_VALUE)?0:min;
    }
}