package org.example.bfs;

import java.util.*;

public class MinimumScorePathBetweenTwoCities {

    public int minScoreBFS(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            map.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        int res = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer curCity = queue.poll();
            visited.add(curCity);

            for (int[] curDistance : map.getOrDefault(curCity, Collections.emptyList())) {
                if (!visited.contains(curDistance[0])) {
                    queue.add(curDistance[0]);
                    res = Math.min(res, curDistance[1]);
                }
            }
        }
        return visited.contains(n) ? res : -1;
    }

    public int minScoreDFS(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            map.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        return helper(1, map, new HashSet<>(), Integer.MAX_VALUE);
    }

    private int helper(int curCity, Map<Integer, List<int[]>> graph, Set<Integer> visited, int res){
        if (visited.contains(curCity)){
            return res;
        }

        visited.add(curCity);

        for (int[] curDist : graph.getOrDefault(curCity, Collections.emptyList())){
            res = Math.min(res, curDist[1]);
            res = Math.min(res, helper(curDist[0], graph, visited, res));
        }

        return res;
    }
}
