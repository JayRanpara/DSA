class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        
        // Step 1: Pair position with time to reach target
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        // Step 2: Sort cars by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        // Step 3: Use stack to track fleets
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            // If current car takes longer, it forms a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // Else, it merges into the fleet ahead (do nothing)
        }
        
        return stack.size();
    }
}