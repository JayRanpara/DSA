class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n-1;
        int maxWater = Integer.MIN_VALUE;
        while(i<j) {
            int height = Math.min(heights[i],heights[j]);
            int width = j-i;

            maxWater = Math.max(maxWater,height*width);
            if(heights[i]>heights[j]) {
                j--;
            }
            else {
                i++;
            }
        }
        return maxWater;
    }
}
