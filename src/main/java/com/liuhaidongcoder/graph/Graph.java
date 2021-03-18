package com.liuhaidongcoder.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Liu Haidong
 * @date 20/11/28
 */
public class Graph {
    private int v;
    private LinkedList<Integer>[] linkedLists;

    public Graph(int v) {
        this.v = v;
        linkedLists = new LinkedList[this.v];
        for (int i = 0; i < v; i++) {
            this.linkedLists[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) {
        this.linkedLists[s].add(t);
        this.linkedLists[t].add(s);
    }
    public void bfs(int s,int t){
        boolean[] visited = new boolean[this.v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while(queue.size() > 0){
            int c = queue.poll();
            for(int i= 0;i < linkedLists[c].size();i++){
                int q = linkedLists[c].get(i);
                if (!visited[q]) {
                    prev[q] = c;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }
    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.bfs(0,3);
    }
}
