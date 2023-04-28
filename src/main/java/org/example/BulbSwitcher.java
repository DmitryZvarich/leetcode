package org.example;

import java.util.Arrays;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        int[] ar = new int[n];

        Arrays.fill(ar, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j + 1) % (i + 1) == 0) {
                    ar[j] = ar[j] == 0 ? 1 : 0;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += ar[i];
        }

        return res;
    }
}
