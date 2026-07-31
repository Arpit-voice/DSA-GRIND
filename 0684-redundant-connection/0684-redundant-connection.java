class Solution {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];   // nodes are 1-indexed in this problem
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) parent[i] = i;
        Arrays.fill(size, 1);

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int leaderU = find(u);
            int leaderV = find(v);

            if (leaderU == leaderV) {
                return edge;   // already connected before this edge -> this IS the redundant one
            }
            union(leaderU, leaderV);
        }
        return new int[0];
        
    }
    public int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
    public void union(int leaderX, int leaderY) {
        if (leaderX == leaderY) return;

        if (size[leaderX] >= size[leaderY]) {
            parent[leaderY] = leaderX;
            size[leaderX] += size[leaderY];
        }else{
            parent[leaderX] = leaderY;
            size[leaderY] += size[leaderX];
        }

    }

}