package com.hanhha.daal.graph;

import java.util.List;

//https://leetcode.com/problems/keys-and-rooms/
public class LECKeyAndRoom {

    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int total = rooms.size();
        boolean[] vis = new boolean[total];
        dfs(rooms, 0, vis);
        return count == total;
    }

    void dfs(List<List<Integer>> rooms, Integer node, boolean[] vis) {
        vis[node] = true;
        count++;
        for(Integer neighbour : rooms.get(node)) {
            if(!vis[neighbour]) {
                dfs(rooms, neighbour, vis);
            }
        }
    }

    public static void main(String[] args) {
        //[[1],[2],[3],[]]

        List<List<Integer>> rooms = List.of(
            List.of(1),
            List.of(2),
            List.of(3),
            List.of()
        );

        LECKeyAndRoom keyAndRoom = new LECKeyAndRoom();
        System.out.println(keyAndRoom.canVisitAllRooms(rooms));

    }

}
