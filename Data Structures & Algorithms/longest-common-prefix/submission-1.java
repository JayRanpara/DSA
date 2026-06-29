class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        String last = strs[strs.length-1];

        for(int i=0; (i<first.length()&&i<last.length()); i++) {
            if(first.charAt(i) == last.charAt(i)) {
                sb.append(first.charAt(i));
            }
            else {
                break;
            }
        }
        return sb.toString();
    }
}