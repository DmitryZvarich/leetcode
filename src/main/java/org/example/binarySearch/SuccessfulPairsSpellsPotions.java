package org.example.binarySearch;

import java.util.Arrays;

public class SuccessfulPairsSpellsPotions {
    private int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Sort the potions array in increasing order.
        Arrays.sort(potions);
        int[] answer = new int[spells.length];

        int m = potions.length;
        int maxPotion = potions[m - 1];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            // Minimum value of potion whose product with current spell
            // will be at least success or more.
            int minPotion = (int) Math.ceil((1.0 * success) / spell);
            // Check if we don't have any potion which can be used.
            if (minPotion > maxPotion) {
                answer[i] = 0;
                continue;
            }
            // We can use the found potion, and all potion in its right
            // (as the right potions are greater than the found potion).
            int index = lowerBound(potions, minPotion);
            answer[i] = m - index;
        }

        return answer;
    }
}
