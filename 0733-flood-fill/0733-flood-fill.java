class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];   // capture BEFORE any changes, only once
        if (startColor == color) return image;  // avoid infinite loop if same color
        dfs(image, sr, sc, startColor, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int startColor, int color) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length 
            || image[i][j] != startColor) return;   // stop if out of bounds OR not part of original region

        image[i][j] = color;

        dfs(image, i-1, j, startColor, color);
        dfs(image, i+1, j, startColor, color);
        dfs(image, i, j-1, startColor, color);
        dfs(image, i, j+1, startColor, color);
    }
}