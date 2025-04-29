package org.example;

import java.util.*;

public class App {

    // Dijkstra's algorithm using an adjacency list
    public static int dijkstra(Map<Integer, List<int[]>> graph, int start, int end) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();

        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        minHeap.offer(new int[]{start, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int dist = current[1];

            if (node == end) return dist;
            if (visited.contains(node)) continue;

            visited.add(node);

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int next = neighbor[0];
                int weight = neighbor[1];
                if (dist + weight < distances.getOrDefault(next, Integer.MAX_VALUE)) {
                    distances.put(next, dist + weight);
                    minHeap.offer(new int[]{next, dist + weight});
                }
            }
        }

        return -1; // No path
    }

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new int[]{2, 1}, new int[]{5, 1}));
        graph.put(2, Arrays.asList(new int[]{3, 1}));
        graph.put(3, Arrays.asList(new int[]{4, 1}));
        graph.put(4, Arrays.asList(new int[]{5, 1}));
        graph.put(5, new ArrayList<>());

        int result = dijkstra(graph, 2, 5);
        System.out.println("Shortest distance from 2 to 5: " + result);
    }
}
