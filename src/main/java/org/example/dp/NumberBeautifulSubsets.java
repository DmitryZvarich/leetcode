package org.example.dp;

import java.util.LinkedList;

public class NumberBeautifulSubsets {
    public int beautifulSubsets(int[] nums, int k) {
        int res = 0;
        LinkedList<Integer> l = new LinkedList<>();

        for (int num : nums) {
            while (l.contains(num - k) || l.contains(num + k)){
                l.removeFirst();
            }
            if (l.size() > 0){
                res++;
            }

            l.add(num);
            res++;
        }

        return res;
    }
}
