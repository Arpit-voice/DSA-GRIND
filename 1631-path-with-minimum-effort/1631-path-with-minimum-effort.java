class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        int[][] effort = new int[r][c];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // PQ entries: {effortSoFar, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], row = top[1], col = top[2];

            if (d > effort[row][col]) continue;           // stale entry, skip
            if (row == r - 1 && col == c - 1) return d;    // early exit — target finalized

            for (int k = 0; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];
                if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;

                int diff = Math.abs(heights[row][col] - heights[nr][nc]);
                int candidate = Math.max(d, diff);

                if (candidate < effort[nr][nc]) {
                    effort[nr][nc] = candidate;
                    pq.offer(new int[]{candidate, nr, nc});
                }
            }
        }

        return effort[r - 1][c - 1]; // fallback, unreachable given problem guarantees
    }
}