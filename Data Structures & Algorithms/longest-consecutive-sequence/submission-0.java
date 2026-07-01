class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        HashMap<Integer,Boolean>map = new HashMap<>();

        for(int num:nums) {
            map.put(num,false);
        }

        for(int num:nums) {
            int currLen = 1;

            int nextNum = num+1;

            while(map.containsKey(nextNum)&&map.get(nextNum) == false) {
                currLen++;

                map.put(nextNum,true);
                nextNum++;
            }

            int prev = num-1;

            while(map.containsKey(prev)&&map.get(prev) == false) {
                currLen++;

                map.put(prev,true);
                prev--;
            }

            maxLen = Math.max(currLen,maxLen);

        }

        return maxLen;
    }
}