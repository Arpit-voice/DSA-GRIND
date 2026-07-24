class Solution {
    public int[] findOrder(int numCourses, int[][] prq) {
        boolean hasCycle = false;

        Map<Integer,List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inpath = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i =0; i<prq.length; i++){
            int u = prq[i][0];
            int v = prq[i][1];
            adj.computeIfAbsent(u,k-> new ArrayList<>()).add(v);
        }

        for(int i = 0; i<numCourses; i++){ 
            if(!visited.contains(i)){
                if(dfs(i, adj, visited, inpath,stack)) hasCycle =true ;
            }
        }

        if(hasCycle) return new int[0];

        int[] arr = new int[numCourses];
        int idx = arr.length-1;
        while (!stack.isEmpty()) {
            arr[idx--] = stack.pop();
        }

        return arr;
    }

    public boolean dfs(int node , Map<Integer,List<Integer>> adj , Set<Integer> visited , Set<Integer> inpath,Deque<Integer> stack){
        visited.add(node);
        inpath.add(node);

        for(int nbr : adj.getOrDefault(node,new ArrayList<>())){
            if(!visited.contains(nbr)){
                if (dfs(nbr,adj,visited,inpath,stack)) return true;
            }
            else if(inpath.contains(nbr)){
                return true;
            }
        }

        inpath.remove(node);
        stack.push(node);
        return false;
    }


}