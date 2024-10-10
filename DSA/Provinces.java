// provinces means the node can vist every single node in the given graph
/* PROBLEM STATMENT :There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces. */
import java.lang.*;
import java.util.*;
import java.io.*;

class Provinces{
    public static int findCircleNum(int[][] isConnected, int V) 
    {
       ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
       for(int i = 0; i < V; i++)
       {
        adjlist.add(new ArrayList<Integer>());
       }
       for(int i = 0; i < isConnected.length; i++)
       {
         for(int j = 0; j < isConnected[i].length; j++)
         {
            if(isConnected[i][j] == 1 && i != j)
            {
                adjlist.get(i).add(j);
                adjlist.get(j).add(i);
            }
         }
       }
       int cnt = 0;
       boolean[] visited = new boolean[V+1];
       for(int i = 0; i < V; i++)
       {
        if(!visited[i])
        {
            cnt++;
            //dfs(i,adjlist,visited);
            bfs(i,adjlist,visited);
        }
       }
       return cnt;
    }
    public static void  dfs(int i,ArrayList<ArrayList<Integer>> adjlist, boolean[] visited) 
    {
        visited[i] = true;
        for(int it : adjlist.get(i))
        {
            if(!visited[it])
            {
                dfs(it,adjlist,visited);
            }
        }
    }
    public static void bfs(int i,ArrayList<ArrayList<Integer>> adjlist, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);
        while(!q.isEmpty())
        {       
            for(int it : adjlist.get(q.poll()))
            {
                if(!visited[it])
                {
                    bfs(i,adjlist,visited);
                }
            }
        }
    }
    public static void main(String args[])
    {
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("Enter the size of the matrix (n x n): ");
            int n = scanner.nextInt();
    
            int[][] isConnected = new int[n][n];
    
            System.out.println("Enter the matrix values row by row (0 or 1): ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    isConnected[i][j] = scanner.nextInt();
                }
            }
    
            int provinces = findCircleNum(isConnected,n);
            System.out.println("Number of provinces: " + provinces);
    
            scanner.close();
        }
    }
