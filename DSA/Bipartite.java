// bipartite graph is graph where each adj node of graph as different color 
// every graph is bipartite graph execpt the odd cycle graph
// this is implemented using dfs

import java.lang.*;
import java.util.*;
import java.io.*;
class Graph{
  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  int V;
  Graph(int vertices) {
    V = vertices;
    for(int i = 0; i < V ; i++)
    {
        graph.add(new ArrayList<Integer>());
    }
  }
  public void addEdge(int u,int v){
    graph.get(u).add(v);
    graph.get(v).add(u);
  }
  public void print()
  {
    for(int i = 0 ; i<V; i++)
    {
        System.out.print( i +"->");
        for(int j = 0 ; j<graph.get(i).size(); j++)
        {
            System.out.println( graph.get(i).get(j)+",");
        }
        System.out.println();
    }
  }
  public ArrayList<ArrayList<Integer>> getAdjList(){
    return graph;
  }
  public int getVertices()
  {
    return V;
  }
}
class Bipartite{
    public static boolean dfs(int node ,int col,ArrayList<ArrayList<Integer>> graph,int[] color)
    {
        color[node] = col;
        for(int it : graph.get(node))
        {
             if(color[it] == -1)
             { 
                if(dfs(it, 1 - col , graph,color) == false)
                {
                    return false;
                }
             }
             else if(color[it] == col)
             {
                return false;
             }
        }
        return true;
    }
    public static boolean isBipartite(ArrayList<ArrayList<Integer>> graph , int V)
    {
        int[] color = new int[V];
        for(int i = 0 ; i < V ; i++)
        {
            color[i] = -1;
        }
        for(int i = 0 ; i < V ; i++)
        {
            if(color[i] == -1)
            {
                if(dfs(i,0,graph,color)==false)
                {
                    return false;
                }
            }
        }
        return true; 
    }
    public static void main(String args[])
    {
        Graph graph = new Graph(4);
        graph.addEdge(0,2);// adj.get(0).add(2);
        graph.addEdge(2,0);// adj.get(2).add(0);
        graph.addEdge(0,3);// adj.get(0).add(3);
        graph.addEdge(3,0);// adj.get(3).add(0);
        graph.addEdge(1,3);// adj.get(1).add(3);
        graph.addEdge(3,1);// adj.get(3).add(1);
        graph.addEdge(2,3);// adj.get(2).add(3);
        graph.addEdge(3,2);// adj.get(3).add(2);
         boolean result = isBipartite(graph.getAdjList(),graph.getVertices());
         System.out.println(result);
    }
}