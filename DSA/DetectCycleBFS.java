 import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    static ArrayList<ArrayList<Integer>> graph;
    static int V;

    Graph(int V) {
        this.V = V;
        graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void addEdge(int u, int v) {
        if (u >= 0 && u < V && v >= 0 && v < V) {
            graph.get(u).add(v);
            graph.get(v).add(u);
        } else {
            System.out.println("Error: Vertex out of bounds.");
        }
    }

    public void print() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> getAdjacencyList() {
        return graph;
    }

    public int getVertices() {
        return V;
    }
}

class Node {
    int first;
    int second;

    Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DetectCycleBFS {
    public static boolean detectCycle(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(curr, -1));
        visited[curr] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for (int it : graph.get(node)) {
                if (!visited[it]) {
                    q.add(new Node(it, node));
                    visited[it] = true;
                } else if (par != it) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(graph, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3); // Initialize the graph with 3 vertices
        graph.addEdge(0, 1); // connect vertex 0 and 1
        graph.addEdge(1, 2); // connect vertex 1 and 2
        graph.addEdge(2, 0); // connect vertex 2 and 0, creating a cycle

        graph.print();

        if (isCycle(graph.getAdjacencyList(), graph.getVertices())) {
            System.out.println("Cycle detected in the graph.");
        } else {
            System.out.println("No cycle detected in the graph.");
        }
    }
}
