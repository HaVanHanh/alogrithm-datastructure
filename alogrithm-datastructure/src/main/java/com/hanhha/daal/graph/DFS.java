package com.hanhha.daal.graph;

import java.util.List;

public class DFS {
    private final List<List<Integer>> adjList;

    public DFS(List<List<Integer>> adjList) {
        this.adjList = adjList;
    }

    public void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < adjList.get(start).size(); i++) {
            int neighbor = adjList.get(start).get(i);
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = List.of(
            List.of(1, 2),
            List.of(0, 3, 4),
            List.of(0, 5, 6),
            List.of(1),
            List.of(1),
            List.of(2),
            List.of(2)
        );

        DFS dfs = new DFS(adjList);
        boolean[] visited = new boolean[adjList.size()];
        dfs.dfs(0, visited);
    }


}
