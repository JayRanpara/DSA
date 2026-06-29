class Solution {
    public boolean isAnagram(String s, String t) {
        int arr[] = new int[26];

        if(s.length()<t.length()) {
           String temp = s;
           s = t;
           t = temp;
        }

        for(char ch:s.toCharArray()) {
            arr[ch-'a']++;
        }

        for(char ch:t.toCharArray()) {
            arr[ch-'a']--;
        } 

        for(int i=0; i<arr.length; i++) {
            if(arr[i]>0) {
                return false;
            }
        }
        return true;
    }
}
