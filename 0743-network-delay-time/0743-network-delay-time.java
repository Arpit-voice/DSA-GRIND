class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        ArrayList<ArrayList<int []>>  adj = new ArrayList<>();

        for(int i =0; i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<times.length ;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new int[]{v,w});
            // adj.get(v).add(new int[]{u,w});
        }
        
        PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        // dist[0]=0;
        dist[src] =0;

        pq.offer(new int[]{0,src});
        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int d =  top[0];
            int u =  top[1];

            if(d>dist[u]) continue;

            for(int[]nbr: adj.get(u)){
                int v = nbr[0];
                int w = nbr[1];
                
                if(dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                    pq.offer(new int[]{dist[v],v});
                } 
            }
        }

        int max = 0;
        for(int i=1; i<n+1;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            if(dist[i]>max) max=dist[i];
        }

        return max;

    }
}