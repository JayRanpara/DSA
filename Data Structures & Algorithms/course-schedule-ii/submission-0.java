class Solution {

    public boolean dfs(int curr, ArrayList<ArrayList<Integer>>adj,boolean vis[], boolean inrec[],Stack<Integer>s) {
        vis[curr] = true;
        inrec[curr] = true;

        for(int i=0; i<adj.get(curr).size(); i++) {
            int edge = adj.get(curr).get(i);

            if(!vis[edge]&&dfs(edge,adj,vis,inrec,s)) {
                return true;
            }
            else if(inrec[edge]) {
                return true;
            }
        }
        
        inrec[curr] = false;
        s.push(curr);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int edge[]:prerequisites) {
            int src = edge[0];
            int desc = edge[1];

            adj.get(desc).add(src);
        }

        boolean vis[] = new boolean[numCourses];
        boolean inrec[] = new boolean[numCourses];
        Stack<Integer>s  = new Stack<>();
        

        for(int i=0; i<numCourses; i++) {
            if(!vis[i]&&dfs(i,adj,vis,inrec,s)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        int idx = 0;
        while(!s.isEmpty()) {
            result[idx++] = s.pop();
        }

        return result;
    }
}
