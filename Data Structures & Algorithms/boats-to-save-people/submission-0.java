class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i=0; 
        int j=n-1;
        int count = 0;
        while(i<=j) {
            int sum = people[i]+people[j];

            if(sum<=limit) {
                count++;
                i++;
                j--;
            }
            else {
                count++;
                j--;
            }
        }
        return count;
    }
}