package org.example.greedy;

import java.util.Arrays;

public class BoatsSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int cnt = 0;

        if (people.length == 0) {
            return cnt;
        }

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            cnt++;

            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
        }


        return cnt;

    }
}
