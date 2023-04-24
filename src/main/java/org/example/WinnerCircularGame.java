package org.example;

import java.util.LinkedList;
import java.util.List;

public class WinnerCircularGame {
    public int findTheWinner(int n, int k) {
        List<Integer> l = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            l.add(i);
        }

        int ind = 0;
        while (l.size() > 1){
            ind += k - 1;
            ind %= l.size();

            l.remove(ind);
        }

        return l.get(0);
    }
}
