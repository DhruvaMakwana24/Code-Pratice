/*
 * https://leetcode.com/problems/count-the-number-of-complete-components/description/
 * description:
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.

 
 */
import java.util.ArrayList;
import java.util.Arrays;

class CountCompleteComponents {
    private ArrayList<ArrayList<Integer>> adj;
    private boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        visited = new boolean[n];
        Arrays.fill(visited, false);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] result = dfs(i);
                // A complete component has edges equal to nodes * (nodes - 1)
                if (result[0] * (result[0] - 1) == result[1]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private int[] dfs(int node) {
        visited[node] = true;
        int nodecnt = 1;
        int edgecnt = adj.get(node).size();

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                int[] result = dfs(it);
                nodecnt += result[0];
                edgecnt += result[1];
            }
        }

        return new int[]{nodecnt, edgecnt};
    }

    public static void main(String[] args) {
        CountCompleteComponents solution = new CountCompleteComponents();

        // Example test case
        int n = 5;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0},
            {3, 4}
        };

        int result = solution.countCompleteComponents(n, edges);
        System.out.println("Number of complete components: " + result);
    }
}
