package org.example.twoPointers;

import java.util.Arrays;

public class NumberSubsequencesThatSatisfyGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int res = 0;

        int mod = 1_000_000_007;
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        for (int l = 0; l < nums.length; l++) {
            if (nums[l] > target / 2) {
                break;
            }
            int r = binarySearchRightMost(nums, target - nums[l]);

            res += power[r - l - 1];
            res %= mod;
        }

        return res;
    }

    private int binarySearchRightMost(int[] nums, int num) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] <= num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}
