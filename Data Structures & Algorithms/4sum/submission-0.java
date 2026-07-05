
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate i

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicate j

                int p = j + 1, q = n - 1;
                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        // skip duplicate p
                        while (p < q && nums[p] == nums[p + 1]) p++;
                        // skip duplicate q
                        while (p < q && nums[q] == nums[q - 1]) q--;
                        p++;
                        q--;
                    }
                }
            }
        }
        return list;
    }

    
}
