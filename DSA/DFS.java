import java.lang.*;
import java.util.*;
import java.io.*;

class Graph{
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int V;
    Graph(int V) {
        this.V = V;
        for (int i = 0 ; i < V ; i++)
        {
            arr.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int u ,int v)
    {
        arr.get(u).add(v);
        arr.get(v).add(u);
    }
    public void printgraph(){
        for(int i=0;i<V;i++){
            System.out.print("Vertex "+i+":");
            for(int j=0;j<arr.get(i).size();j++){
                System.out.print(arr.get(i).get(j)+" ");
            }
            System.out.println();
       }
    }
    public ArrayList<ArrayList<Integer>> getAdjacencyList() {
        return arr;
    }
    public int getVertices()
    {
        this.V = V;
        return V;
    }
}
class DFS{
    
    public static void dfs(int node,boolean[] visited , ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> ls)
    {
        visited[node] = true;
        ls.add(node);
        for(int it: arr.get(node))
        {   
            if(!visited[it])
            {
              dfs(it,visited,arr,ls);
            }
        }

    }
    public static ArrayList<Integer> dfsarr(ArrayList<ArrayList<Integer>> arr, int V)
    {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 2; i < V; i++) { // Ensure all nodes are covered
            if (!visited[i]) {
                dfs(i, visited, arr, ls);
            }
        }
        return ls;
    }
    public static void main(String[] args) {
        Graph arr = new Graph(6);
        arr.addEdge(1, 2);
        arr.addEdge(1, 5);
        arr.addEdge(2, 3);
        arr.addEdge(3, 4);
        arr.addEdge(5, 4);
        arr.printgraph();
        ArrayList<Integer> result = dfsarr(arr.getAdjacencyList(),arr.getVertices());
        System.out.println(result);

    }
}