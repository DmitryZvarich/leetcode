package org.example.dp;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int bestBelow = Math.min(
                        triangle.get(row + 1).get(col),
                        triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, bestBelow + triangle.get(row).get(col));
            }
        }
        return triangle.get(0).get(0);
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        int ind = triangle.size() - 2;

        while (ind >= 0) {
            List<Integer> cur = triangle.get(ind);
            List<Integer> next = triangle.get(ind + 1);
            for (int i = 0; i < cur.size(); i++) {
                cur.set(i, cur.get(i) + Math.min(next.get(i), next.get(i + 1)));
            }

            ind--;
        }

        return triangle.get(0).get(0);
    }
}
