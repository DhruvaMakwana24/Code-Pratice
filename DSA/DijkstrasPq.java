// used to find shortest path algorithm 
// it is used for dag
// it don't allow any negative weight 
import java.lang.*;
import java.util.*;
import java.io.*;
class Graph{
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
     int V;
     Graph(int V) {
        this.V = V;
        for(int i= 0; i < V; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
     }
     public void addedge(int u,int v)
     {
        adj.get(u).add(v);
     }
     public void print(){
        for(int i=0;i<V;i++)
        {
            System.out.print(i+"=> ");
            for(int j = 0 ; j < adj.get(i).size();j++)
            {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
     public ArrayList<ArrayList<Integer>> getgraph(){
        return adj;
     }
     public int getvertices(){
        return V;
    }
}
class Pair{
    int dist;
    int node;
    Pair(int dist,int node){
        this.dist = dist;
        this.node = node;
    }
}
class DijkstrasPq{
    public  static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] path = new int[V];
        for(int i = 0; i < V ; i++)
        {
            path[i] = Integer.MAX_VALUE;
        }
        path[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(0,S));
        while(!pq.isEmpty())
        {
            int dist = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            for(int i = 0 ; i < adj.get(node).size();i++)
            {
                int edgeweight = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);
                if(dist + edgeweight < path[adjnode])
                {
                    path[adjnode] = dist + edgeweight;
                    pq.add(new Pair(path[adjnode],adjnode));
                }
            } 
        }
        return path;
    }
    public static void main(String args[])
{
    // Create a graph with 6 vertices
    Graph g = new Graph(6);
    
    // Add edges to the graph
    g.addedge(0, 1);
    g.addedge(0, 2);
    g.addedge(1, 3);
    g.addedge(1, 4);
    g.addedge(2, 4);
    g.addedge(3, 5);
    g.addedge(4, 5);
    
    // Convert the graph to the format required by the Dijkstra's algorithm
    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
    for (int i = 0; i < g.getvertices(); i++) {
        adj.add(new ArrayList<>());
        for (int j : g.getgraph().get(i)) {
            // Assuming the weight of each edge is 1 for simplicity
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(j);
            edge.add(1); // weight
            adj.get(i).add(edge);
        }
    }
    
    // Run Dijkstra's algorithm starting from vertex 0
    int[] shortestPaths = dijkstra(g.getvertices(), adj, 0);
    
    // Print the shortest paths
    System.out.println("Shortest paths from vertex 0:");
    for (int i = 0; i < shortestPaths.length; i++) {
        System.out.println("Vertex " + i + " -> " + shortestPaths[i]);
    }
}

}