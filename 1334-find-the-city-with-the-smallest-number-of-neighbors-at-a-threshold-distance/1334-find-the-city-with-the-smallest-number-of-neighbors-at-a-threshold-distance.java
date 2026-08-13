class Solution {
    public int findTheCity(int n, int[][] edges, int dt) {
        int inf= Integer.MAX_VALUE/2;

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }

        // Add all directed edges.
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=inf&&dist[k][j]!=inf&&dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j] =dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        int []city= new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]<=dt){
                    city[i]++;
                }
            }
        }
        int bestCity = 0, minCount = city[0];
        for (int i = 1; i < n; i++) {
            if(city[i]<=minCount){
                minCount = city[i];
                bestCity = i;
            }
            // compare city[i] to minCount, decide whether to update bestCity
        }
        return bestCity;
    }
}