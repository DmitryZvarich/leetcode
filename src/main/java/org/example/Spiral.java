package org.example;

public class Spiral {
    private static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        int dirInd = 0;
        int[][] matrix = new int[n][n];
        int[] boundaries = new int[]{0, -n + 1, -n + 1, 0};
        int curRow = 0;
        int curCol = -1;
        int curVal = 1;

        while (curVal <= n * n) {
            while (true) {
                int[] direction = directions[dirInd];
                int nextRow = curRow + direction[0];
                int nextCol = curCol + direction[1];

                if (nextRow < boundaries[0] || nextCol > Math.abs(boundaries[1])
                        || nextRow > Math.abs(boundaries[2]) || nextCol < boundaries[3]) {
                    boundaries[dirInd]++;
                    dirInd = (dirInd + 1) % directions.length;
                } else {
                    curRow = nextRow;
                    curCol = nextCol;
                    break;
                }
            }

            matrix[curRow][curCol] = curVal++;
        }

        return matrix;
    }
}
