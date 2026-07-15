class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int [] arr = new int[temperatures.length];

        Stack<Integer>s = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            // If stack not empty, calculate days difference
            if (!s.isEmpty()) {
                arr[i] = s.peek() - i;
            } else {
                arr[i] = 0;
            }

            s.push(i);
        }
        return arr;
    }
}
