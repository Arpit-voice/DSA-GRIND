class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        int[] visited = new int [isConnected.length];
        for(int i=0; i<isConnected.length;i++){
            if(visited[i]!=1){
                dfs(i,visited,isConnected);
                provinces++;
            }
        }
        return provinces;
    }
    void dfs(int city , int[]visited ,int [][]isConnected){
        visited[city] =1;

        for(int j=0;j<isConnected[0].length;j++){
            if(isConnected[city][j]==1 && visited[j]!=1){
                dfs(j,visited,isConnected);
            }
        }

    }
}