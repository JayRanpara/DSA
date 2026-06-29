class Solution {
    static class Pair implements Comparable<Pair>{
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int compareTo(Pair p2) {
            return p2.count-this.count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int result[] = new int[k];

        PriorityQueue<Pair>pq = new PriorityQueue<>();

        HashMap<Integer,Integer>map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer>es : map.entrySet()) {
            pq.add(new Pair(es.getKey(),es.getValue()));
        }

        for(int i=0; i<k; i++) {
            result[i] = pq.remove().num;
        }


        return result;
    }
}
