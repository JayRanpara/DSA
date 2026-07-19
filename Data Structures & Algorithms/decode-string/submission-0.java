class Solution {
    public String decodeString(String str) {
        Stack<Integer>numStack = new Stack<>();
        Stack<String>charStack = new Stack<>();
        String currStr = "";
        int n = 0;

        for(Character c:str.toCharArray()) {
            if(Character.isDigit(c)) {
                n = n*10+(c-'0');
            } else if(c == '[') {
                numStack.push(n);
                charStack.push(currStr);
                currStr = "";
                n = 0;
            } else if(c == ']') {
                StringBuilder sb = new StringBuilder(charStack.pop());
                int repeat = numStack.pop();
                for(int i =0; i<repeat; i++) {
                    sb.append(currStr);
                } 
                currStr = sb.toString();
            }
            else {
                currStr+=c;
            }
        }
        return currStr;
    }
}