class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>s = new Stack<>();

        for(String str:operations) {
            if(str.equals("+")) {
                int val1 = s.pop();
                int val2 = s.peek();
                s.push(val1);

                s.push(val1+val2);
            }
            else if(str.equals("D")) {
            
                s.push(s.peek()*2);
            }
            else if(str.equals("C")) {
                s.pop();
            }
            else {
                s.push(Integer.parseInt(str));
            }
        }
        int sum = 0;

        while(!s.isEmpty()) {
            sum+=s.pop();
        }
        return sum;
    }
}