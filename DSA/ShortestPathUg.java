// each edge has unit weight
import java.lang.*;
import java.util.*;
import java.io.*;

class ShortestPathUg{
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) { // using normal bfs we are calculating the shortest distance 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i < m; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m; i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] distance = new int[m+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            for(int it : adj.get(node))
            {
               if(distance[node] + 1 < distance[it])
               {
                  distance[it] = distance[node] + 1;
                  queue.add(it);
               }
            }
        }
        for(int i = 0 ; i < m+1 ; i++)
        {
            if(distance[i] == Integer.MAX_VALUE)
            {
                distance[i] = -1;
            }
        }
        return distance;
    }
    public static void main(String[] args) 
    {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int res[] = shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

}