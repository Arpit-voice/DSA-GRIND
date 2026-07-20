class Solution {
    static Set<Integer> visited;
    static int provinces;

    public int findCircleNum(int[][] isConnected) {
        visited = new HashSet<>();
        provinces = 0;


        for(int city=0;city<isConnected.length; city++ ){
            if(!visited.contains(city)){
                provinces++;
                dfs(city,isConnected);
            }
        }
        return provinces;
    }
    public void dfs(int city, int [][] isConnected){
        visited.add(city);

        for(int neighbor=0;neighbor<isConnected[0].length ; neighbor++){
            if(isConnected[city][neighbor]==1 && !visited.contains(neighbor)){
                dfs(neighbor,isConnected);
            }
        }

    }
}