import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all 0 cells to the queue
        // and mark 1 cells as unvisited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        // Four possible directions
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // BFS
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    mat[newRow][newCol] == -1) {

                    mat[newRow][newCol] = mat[row][col] + 1;

                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return mat;
    }
}