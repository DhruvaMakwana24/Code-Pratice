//the topological sorting is done on DAG only 
// the condition for this is let the u,v be adj node and 
import java.lang.*;
import java.io.*;
import java.util.*;

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

class Topologicalsort{
    public static void dfs(int node,Stack<Integer> st ,ArrayList<ArrayList<Integer>> adj,boolean[] visited )
    {
        visited[node] = true;
        for(int it : adj.get(node))
        {
            if(!visited[it])
            {
                dfs(it,st,adj,visited);
            }
        }
        st.push(node);
    }
    public static int[] topologicalSort(ArrayList<ArrayList<Integer>> adj,int V)
    {
         boolean[] visited = new boolean[V];
         Stack<Integer> st = new Stack<>();
         for(int i = 0 ; i <V ;i++)
         {
            if(!visited[i])
            {
                dfs(i,st,adj,visited);
            }
         }
         int[] ans = new int[V];
         int index = 0;
         while (!st.isEmpty()) {
             ans[index++] = st.pop();
         }
     
         return ans;
    }
    public static void main(String[] args) {
          Graph adj = new Graph(6);
           adj.addedge(2,3);//   adj.get(2).add(3);
           adj.addedge(3,1);//   adj.get(3).add(1);
           adj.addedge(4,0);//   adj.get(4).add(0);
           adj.addedge(4,1);//   adj.get(4).add(1);
           adj.addedge(5,0);//   adj.get(5).add(0);
           adj.addedge(5,2);//   adj.get(5).add(2);
           adj.print();
           int[] result = topologicalSort(adj.getgraph(),adj.getvertices());
           System.out.println("Topological Sort:");
           for (int i : result) {
               System.out.print(i + " ");
           }     
    }
}