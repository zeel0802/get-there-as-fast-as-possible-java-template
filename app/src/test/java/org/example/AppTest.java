package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private Map<Integer, List<int[]>> buildTestGraph() {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new int[]{2, 1}, new int[]{5, 1}));
        graph.put(2, Arrays.asList(new int[]{3, 1}));
        graph.put(3, Arrays.asList(new int[]{4, 1}));
        graph.put(4, Arrays.asList(new int[]{5, 1}));
        graph.put(5, new ArrayList<>());
        return graph;
    }

    @Test
    public void testDirectPath() {
        Map<Integer, List<int[]>> graph = buildTestGraph();
        assertEquals(1, App.dijkstra(graph, 1, 2));
    }

    @Test
    public void testMultiStepPath() {
        Map<Integer, List<int[]>> graph = buildTestGraph();
        assertEquals(3, App.dijkstra(graph, 2, 5));
    }

    @Test
    public void testNoPath() {
        Map<Integer, List<int[]>> graph = buildTestGraph();
        assertEquals(-1, App.dijkstra(graph, 5, 1));
    }
}
