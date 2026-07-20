class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; //rows
        int n = grid[0].length; //cols
        int visited [][] = new int[m][n];
        int islands=0;

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j] != 1){
                    dfs(i,j,visited,grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int i, int j , int[][] visited,char[][] grid){
        if(visited[i][j]==1) return;
        visited[i][j]=1;

        if(i>=0 && j-1>=0 && i<grid.length && j-1<grid[0].length && grid[i][j-1]=='1'){
            dfs(i,j-1,visited,grid);
        }
        if(i-1>=0 && j>=0 && i-1<grid.length && j<grid[0].length && grid[i-1][j]=='1'){
            dfs(i-1,j,visited,grid);
        }
        if(i+1>=0 && j>=0 && i+1<grid.length && j<grid[0].length && grid[i+1][j]=='1'){
            dfs(i+1,j,visited,grid);
        }
        if(i>=0 && j+1>=0 && i<grid.length && j+1<grid[0].length && grid[i][j+1]=='1'){
            dfs(i,j+1,visited,grid);
        }
    }
}