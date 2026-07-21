class Solution {
    class Pair{
        int first;
        int sec;

        public Pair(int first, int sec){
            this.first= first;
            this.sec = sec;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int cnt1 =0;
        Queue<Pair> q = new LinkedList<>();
        for(int i =0 ;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    visited[i][j]=1;
                }
                else if(grid[i][j]==1){
                    cnt1 ++;
                }
            }
        }
        if(cnt1==0) return 0;
        int[] arr = bfs(q,visited,grid,0);
        int freshCnt = arr[0];
        int time = arr[1];
        
        System.out.println(cnt1);
        System.out.println(freshCnt);
        System.out.println(time);

        return freshCnt<cnt1 ? -1:time;
    }
    public int[] bfs( Queue<Pair> q ,int[][] visited,int[][] grid,int time) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int freshCnt=0;
        while (!q.isEmpty()) {
 
            int levelsize = q.size();
            for(int i=0;i<levelsize;i++){
                Pair curr = q.poll();
                int row = curr.first;
                int col = curr.sec;

                for (int k = 0; k < 4; k++) {

                    int newRow = row + dr[k];
                    int newCol = col + dc[k];

                    if (newRow >= 0 && newCol >= 0 &&
                        newRow < grid.length && newCol < grid[0].length &&
                        grid[newRow][newCol] ==1 &&
                        visited[newRow][newCol] !=1) {

                            visited[newRow][newCol] =1;
                            freshCnt ++;
                            q.add(new Pair(newRow, newCol));
                    }
                }
            }
            if(!q.isEmpty()) time++;
        }
        return new int[] {freshCnt,time};
    }
}
