class Solution {
    public String simplifyPath(String path) {
        String parts[] = path.split("/");

        Stack<String>s = new Stack<>();

        for(String part : parts) {
            if(part.equals("")||part.equals(".")) {
                continue;
            }
            else if(part.equals("..")) {
                if(!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(part);
            }
        }
        Stack<String> temp = new Stack<>();
        while (!s.isEmpty()) {
            temp.push(s.pop()); // reverse order
        }

        StringBuilder result = new StringBuilder();
        while (!temp.isEmpty()) {
            result.append("/").append(temp.pop());
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}