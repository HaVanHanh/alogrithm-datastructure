package com.hanhha.daal.graph;

import java.util.ArrayList;
import java.util.List;

public class LEC1557 {
    public static void main(String[] args) {
        //with n = 6
        //and edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
        //Output: [0,3]
        LEC1557 lec1557 = new LEC1557();
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(0, 1));
        edges.add(List.of(0, 2));
        edges.add(List.of(2, 5));
        edges.add(List.of(3, 4));
        edges.add(List.of(4, 2));
        List<Integer> result = lec1557.findSmallestSetOfVertices(6, edges);
        System.out.println(result);
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            adjList.get(from).add(to);
        }

        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, result);
            }
        }
        return result;
    }

    public void dfs(int node, List<List<Integer>> adjList, boolean[] visited, List<Integer> res) {
        visited[node] = true;
        res.add(node);
        for (Integer neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, res);
            }
            res.remove(neighbor);
        }
    }


}
