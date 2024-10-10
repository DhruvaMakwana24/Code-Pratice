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
     
       }
    }
    public ArrayList<ArrayList<Integer>> getAdjacencyList() {
        return arr;
    }
}
class BFS{
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> arr)
    {
        int V = arr.size()+1;
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        visited[1] = true;
        q.add(1);
        while(!q.isEmpty()){
            int s = q.poll();
            bfs.add(s);
            for(int it : arr.get(s))
            {
                if(!visited[it])
                {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
        Graph arr = new Graph(6);
        arr.addEdge(1, 2);
        arr.addEdge(1, 5);
        arr.addEdge(2, 3);
        arr.addEdge(3, 4);
        arr.addEdge(5, 4);
        arr.printgraph();
        ArrayList<Integer> result = bfs(arr.getAdjacencyList());
        System.out.println(result);

    }
}