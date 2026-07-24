class Solution {
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer>s = new Stack<>();

        for(String token:tokens) {
            if(!isOperator(token)) {
                s.push(Integer.parseInt(token));
            }
            else {
                int b = s.pop();
                int a = s.pop();
                int result = 0;

                switch(token) {
                    case "+":
                            result = a+b;
                            break;
                    case "-":
                            result = a-b;
                            break;
                    case "*":
                            result = a*b;
                            break;
                    case "/":
                            result=a/b;
                            break;
                }
                s.push(result);
            }
        }
        return s.pop();
    }
}
