class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inpath = new HashSet<>();

        for(int i =0; i < prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.computeIfAbsent(u,k-> new ArrayList<>()).add(v);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited.contains(i)){
                if(dfsCycle(i,adj,visited,inpath)) return false;
            }
        }

        return true;

    }

    public boolean dfsCycle(int node ,Map<Integer,List<Integer>> adj, Set<Integer> visited, Set<Integer> inpath ){
        visited.add(node);
        inpath.add(node);

        for(int nbr : adj.getOrDefault(node , new ArrayList<>()) ){
            if(!visited.contains(nbr)){
                if(dfsCycle(nbr,adj,visited,inpath)) return true;
            }
            else if(inpath.contains(nbr)){
                return true;
            }
        }

        inpath.remove(node);
        return false;
    }
}