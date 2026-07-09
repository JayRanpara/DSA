class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int maxLen = 0;
        int left = 0;
        int maxfreq = 0;

        for(int right=0; right<s.length(); right++) {
            freq[s.charAt(right)-'A']++;
            maxfreq = Math.max(maxfreq,freq[s.charAt(right)-'A']);

            int windowlen = right-left+1;

            if(windowlen-maxfreq>k) {
                freq[s.charAt(left)-'A']--;
                left++;
            }
            windowlen = right-left+1;
            maxLen = Math.max(windowlen,maxLen);
        }
        return maxLen;
    }
}