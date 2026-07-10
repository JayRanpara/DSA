class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        HashMap<Character,Integer>targetmap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<t.length(); i++) {
            targetmap.put(t.charAt(i),targetmap.getOrDefault(t.charAt(i),0)+1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();  
        int have = 0, need = targetmap.size();
        int resLeft=0;
        int resRight=0;
        int left = 0;
        for(int right=0; right<s.length(); right++) {
            char c = s.charAt(right);

            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if(targetmap.containsKey(c)&&windowCount.get(c)==targetmap.get(c)) {
                have++;
            }

            while(have==need) {
                if(right-left+1<minLen) {
                    minLen = right - left + 1;
                    resLeft = left;
                    resRight = right;
                }

                //shrink window

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (targetmap.containsKey(leftChar) && 
                    windowCount.get(leftChar) < targetmap.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight + 1);
    }
}
