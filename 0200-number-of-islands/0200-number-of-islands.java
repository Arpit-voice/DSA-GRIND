class Solution {
    static int count;
    static int[][] visited;
    public int numIslands(char[][] grid) {
        count =0;
        visited = new int[grid.length][grid[0].length];

        for(int i=0; i< grid.length; i++){
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    public void dfs(int i , int j , char[][]grid){
        if(i<0 || i>=grid.length ||j<0|| j>= grid[0].length || grid[i][j] =='0' || visited[i][j] == 1) return;
        
        visited[i][j] = 1;

        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
    }    
}