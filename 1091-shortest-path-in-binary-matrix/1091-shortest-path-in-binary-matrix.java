class Solution {
    class Pair{
        int f;
        int s;

        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0) return -1;
        if(grid.length==1) return 1;
        int visited[][] =new int [grid.length][grid[0].length];

        int ans = bfs(0,0,grid,visited,1);

        return ans;
    }
    public int bfs(int i,int j,int[][] grid , int visited[][],int t){
        int n = grid.length;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j]=1;


        while(!q.isEmpty()){
            int levelsize = q.size();
            for (int l=0; l<levelsize;l++){
                Pair curr = q.poll();
                int r = curr.f;
                int c = curr.s;
                //do node things 
                for(int dr= -1 ;dr<=1 ;dr++){
                    for(int dc= -1 ;dc<=1 ;dc++){
                        if(dr==0 && dc==0) continue;   // skip self, only 8 real neighbors
                        int nr = r + dr;
                        int nc = c + dc;
                        if(nr>=0 && nc>= 0 && nr<n &&nc <n &&
                            grid[nr][nc]==0&&visited[nr][nc]!=1){
                            visited[nr][nc]=1;
                            if(nr==n-1&&nc==n-1) return t+1;
                            q.add(new Pair(nr,nc));
                        }
                    }
                }    
            }
            t++;
        }
        
        return visited[n-1][n-1]==1 ? t:-1;
    }
  

}