package org.example.dp;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * temp));

            res = Math.max(res, max);
        }

        return res;
    }
}
