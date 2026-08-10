class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int V =r*c;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<r;i++){
            for(int j=0;j<c;j++){
                int node = i*c +j;
                int h = heights[i][j];
                if(i-1>=0){
                    int up  =  heights[i-1][j];
                    adj.get(node).add(new int[]{(i-1)*c+j,Math.abs(h-up)});
                } 
                if(i+1<r){
                    int down = heights[i+1][j]; 
                    adj.get(node).add(new int[]{(i+1)*c+j,Math.abs(h-down)});
                } 
                if(j-1>=0){
                    int left = heights[i][j-1]; 
                    adj.get(node).add(new int[]{i*c + j-1,Math.abs(h-left)});
                } 
                if(j+1<c){
                    int right= heights[i][j+1]; 
                    adj.get(node).add(new int[]{i*c + j+1,Math.abs(h-right)});
                } 
            }
        }

        return dijkstra(0,adj,r*c);
    }
    public int dijkstra(int src ,ArrayList<ArrayList<int[]>> adj,int V){
        int effort[] = new int[V];
        Arrays.fill(effort,Integer.MAX_VALUE);
        effort[src] =0;

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0,src});
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int h = top[0];
            int u = top[1];

            if (h > effort[u]) continue;

            for(int[] nbr : adj.get(u)){
                int v = nbr[0];
                int diff = nbr[1];

                if(effort[u]<effort[v] && diff<effort[v]){
                    effort[v] = Math.max(diff,effort[u]);
                    pq.offer(new int[]{effort[v],v});
                }
            }
        }
        return effort[V-1];
    }
}