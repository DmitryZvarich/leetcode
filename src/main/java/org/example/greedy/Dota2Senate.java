package org.example.greedy;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int banNextRadiant = 0;
        int banNextDire = 0;
        int countRadiant = 0;
        int countDire = 0;

        for (char c : senate.toCharArray()) {
            queue.add(c);
            if (c == 'R') {
                countRadiant++;
            } else {
                countDire++;
            }
        }

        while (countRadiant > 0 && countDire > 0) {
            Character poll = queue.poll();

            if (poll == 'R') {
                if (banNextRadiant > 0) {
                    banNextRadiant--;
                    countRadiant--;
                } else {
                    banNextDire++;
                    queue.add(poll);
                }
            } else {
                if (banNextDire > 0) {
                    banNextDire--;
                    countDire--;
                } else {
                    banNextRadiant++;
                    queue.add(poll);
                }
            }
        }

        return countRadiant == 0 ? "Dire" : "Radiant";
    }
}
