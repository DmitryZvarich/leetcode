package org.example.design;

public class Vector2D {
    private int[][] vec;
    private int ptR;
    private int ptC;
    public Vector2D(int[][] vec) {
        this.vec = vec;
        ptR = 0;
        ptC = -1;
    }

    public int next() {
        if (ptC + 1 < vec[ptR].length){
            ptC++;
        } else {
            ptR++;
            while (ptR < vec.length && vec[ptR].length == 0){
                ptR++;
            }
            ptC = 0;
        }

        return vec[ptR][ptC];
    }

    public boolean hasNext() {
        if(vec == null || vec.length == 0) {
            return false;
        }

        if (ptC + 1 < vec[ptR].length){
            return true;
        } else {
            int p = ptR + 1;
            while (p < vec.length && vec[p].length == 0){
                p++;
            }

            return p <= vec.length - 1 && vec[p].length != 0;
        }
    }
}
