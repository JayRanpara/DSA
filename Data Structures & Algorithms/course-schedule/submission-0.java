class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];

        for(int edge[]:prerequisites) {
            int src = edge[0];
            int desc = edge[1];

            indegree[src]++;
            adj.get(desc).add(src);
        }

        Queue<Integer>q = new LinkedList<>();
        int count = 0;

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                count++;
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();

            for(int i=0; i<adj.get(curr).size(); i++) {
                int edge = adj.get(curr).get(i);

                indegree[edge]--;

                if(indegree[edge] == 0) {
                    count++;
                    q.add(edge);
                }
            }
        }

        if(count == numCourses) {
            return true;
        }

        return false;
    }
}
