/* this toposort is done by uisng the kahn's alogorithm i.e
 * we implement this method by modifing the bfs
 * and follows the condition for topological sort
 */
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
 class Toposort{
    public static int[] topoSort(ArrayList<ArrayList<Integer>> adj , int V)
    {
        int[] indegree = new int[V];
        for(int i = 0 ; i < V ; i++)
        {
            for(int j = 0 ; j < adj.get(i).size() ; j++)
            {
                indegree[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++)
        {
            if(indegree[i] == 0 )
            {
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int index = 0 ;
        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            topo[index++] = node;
            for(int i : adj.get(node)){
            indegree[i]--;
            if(indegree[i] == 0){
                q.add(i);
            }
          }
        }
        
        return topo;
    }
    public static void main(String args[]){
        Graph adj = new Graph(6);
           adj.addedge(2,3);//   adj.get(2).add(3);
           adj.addedge(3,1);//   adj.get(3).add(1);
           adj.addedge(4,0);//   adj.get(4).add(0);
           adj.addedge(4,1);//   adj.get(4).add(1);
           adj.addedge(5,0);//   adj.get(5).add(0);
           adj.addedge(5,2);//   adj.get(5).add(2);
           adj.print();
           int[] result = topoSort(adj.getgraph(),adj.getvertices());
           System.out.println("Topological Sort:");
           for (int i : result) {
               System.out.print(i + " ");
           }     
    }
}
