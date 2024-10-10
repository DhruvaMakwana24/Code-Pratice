// it is shortst path algorithm 
//can be used ffor negative weight
//In this algorithm, the edges can be given in any order. 
//The intuition is to relax all the edges for N-1( N = no. of nodes) times sequentially. 
//After N-1 iterations, we should have minimized the distance to every node
import java.lang.*;
import java.util.*;
import java.io.*;

class BellManFord{
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[S] = 0;
        for (int i = 0; i < V - 1; i++) {
             for(ArrayList<Integer> it : edges)
             {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v])
                {
                    distance[v] = distance[u] + wt;
                }
             }
        }
        for(ArrayList<Integer> it : edges)// if contains negative cycle it will continously decrese the value of distance in the array
        {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v])
            {
                int[] temp  = new int[1];
                temp[0] = -1;
                return temp;
            }
           
        }
        return distance;
    }
    public static void main(String args[])
    {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
    
        int[] dist = bellman_ford(V, edges, S);
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
        
    }
}