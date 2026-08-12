class Solution {
    public boolean isBipartite(int[][] graph) {
        int r = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<r;i++){
            adj.add(new ArrayList<>());
        }

        int []color = new int[r];
        Arrays.fill(color,-1);

        for(int i =0;i<r;i++){
            for(int j =0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        // for(int i =0;i<r;i++){
        //     for(int j =0;j<graph[i].length;j++){
        //         System.out.print(adj.get(i).get(j)+" ");  
        //     }
        //      System.out.println();
        // }
        for(int i =0;i<r;i++){
            for(int j =0;j<adj.get(i).size();j++){
                int node = adj.get(i).get(j);
                if(color[node]==-1){
                    boolean temp = bipartite(node,adj,r,color);
                    if(!temp) return false;
                }
            }
        }
        return true;

    }

    public boolean bipartite(int src,ArrayList<ArrayList<Integer>> adj,int n,int[] color){

        Queue<Integer> q= new LinkedList<>();
        color[src]=0;
        q.offer(src);

        while(!q.isEmpty()){
            int levelsize = q.size();

            for(int i=0;i<levelsize;i++){
                int u = q.poll();

                for(int v: adj.get(u)){
                    if(color[v]==-1){
                        color[v] = 1-color[u];
                        q.offer(v);
                    }
                    else if(color[v]==color[u]) return false;
                }
            }
        }
        return true;
    }
}