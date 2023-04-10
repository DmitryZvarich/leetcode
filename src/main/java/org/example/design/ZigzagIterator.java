package org.example.design;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
    private List<List<Integer>> vectors;

    private Queue<Pair<Integer, Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        vectors = List.of(v1, v2);
        queue = new LinkedList<>();

        for (int i = 0; i < vectors.size(); i++) {
            if (vectors.get(i).size() > 0) {
                queue.add(new Pair<>(i, 0));
            }
        }
    }

    public int next() {
        Pair<Integer, Integer> poll = queue.poll();
        Integer vecInd = poll.getKey();
        List<Integer> integers = vectors.get(vecInd);
        Integer ind = poll.getValue();

        if (ind + 1 < integers.size()) {
            queue.add(new Pair<>(vecInd, ind + 1));
        }
        return integers.get(ind);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
