//representation of graph using arraylist

import java.lang.*;
import java.util.*;
import java.io.*;

class Representation{
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int V;
    public Representation(int vertices) {
        V = vertices;
        for (int i = 0; i < V; i++) {
            arr.add(new ArrayList<>());
            }
    }
    public void addEdge(int u, int v) {
        arr.get(u).add(v);
        arr.get(v).add(u);
    }
    public static void print()
    {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(" " + arr.get(i).get(j));
            }
            System.out.println();
        }
    }
    // public static void main(String args[])
    // {
    //     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // int V = 6;
    // int U = 6;
    
    // for(int i = 0; i <= V ; i++)
    // {
    //     graph.add(new ArrayList<Integer>());
    // }
    // graph.get(1).add(2);
    // graph.get(2).add(1);

    // graph.get(1).add(5);
    // graph.get(5).add(1);

    // graph.get(2).add(3);
    // graph.get(3).add(2);

    // graph.get(3).add(4);
    // graph.get(4).add(3);

    // graph.get(5).add(4);
    // graph.get(4).add(5);
    // // for printing the graph list 
    // for(int i = 1 ; i <= V ; i++)
    // {
    //     for(int j = 0 ; j < graph.get(i).size();j++)
    //     {
    //         System.out.print(graph.get(i).get(j)+" ");
    //     }
    //     System.out.println();
    // }
    // }
    public static void main(String args[])
    {
        int V = 6; // number of vertices
        Representation arr = new Representation(V);

        arr.addEdge(1, 2);
        arr.addEdge(1, 5);
        arr.addEdge(2, 3);
        arr.addEdge(3, 4);
        arr.addEdge(5, 4);

        arr.print();  
    }
}
