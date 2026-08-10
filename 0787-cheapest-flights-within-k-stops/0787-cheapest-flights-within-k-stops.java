class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int []>>  adj = new ArrayList<>();

        for(int i =0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<flights.length ;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            adj.get(u).add(new int[]{v,w});
            // adj.get(v).add(new int[]{u,w});
        }
        int ans  = dijkstra(src,dst,adj,n,k);

        return ans;
    }
    public int dijkstra (int src , int dst , ArrayList<ArrayList<int[]>> adj ,int n,int k){
        
        int[] dist =new int[n] ;
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        Queue<int[]> pq =new LinkedList<>();
        pq.offer(new int []{0,src,0}) ; /// (stops,node,dist);

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int s =  top[0];
            int u =  top[1];
            int d =  top[2];

            if(s>k) continue; 

            for(int[]nbr: adj.get(u)){
                int v = nbr[0];
                int w = nbr[1];
                
                if(d+w<dist[v]){
                    dist[v] = d+w;
                    pq.offer(new int[]{s+1,v,d+w});
                } 
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
    
}    
