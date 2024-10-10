/*https://www.geeksforgeeks.org/problems/alien-dictionary/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=alien-dictionary
 * Alien dictory
 */
import java.lang.*;
import java.io.*;
import java.util.*;

// class Graph{
//      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//      int V;
//      Graph(int V) {
//         this.V = V;
//         for(int i= 0; i < V; i++)
//         {
//             adj.add(new ArrayList<Integer>());
//         }
//      }
//      public void addedge(int u,int v)
//      {
//         adj.get(u).add(v);
//      }
//      public void print(){
//         for(int i=0;i<V;i++)
//         {
//             System.out.print(i+"=> ");
//             for(int j = 0 ; j < adj.get(i).size();j++)
//             {
//                 System.out.print(adj.get(i).get(j)+" ");
//             }
//             System.out.println();
//         }
//     }
//      public ArrayList<ArrayList<Integer>> getgraph(){
//         return adj;
//      }
//      public int getvertices(){
//         return V;
//     }
// }

class alienDictionary {
    public static List<Integer> topoSort(int K, List<List<Integer>> adj) {
        int[] indegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll(); // Use poll instead of peek + remove
            res.add(node);
            for (int i = 0; i < adj.get(node).size(); i++) {
                indegree[adj.get(node).get(i)]--;
                if (indegree[adj.get(node).get(i)] == 0) {
                    q.add(adj.get(node).get(i));
                }
            }
        }
        return res;
    }

    public static String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int i = 0; i < N - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int length = Math.min(word1.length(), word2.length());
            for (int j = 0; j < length; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Perform topological sort
        List<Integer> topo = topoSort(K, adj);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < topo.size(); i++) {
            sb.append((char) (topo.get(i) + 'a'));
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans = findOrder(dict, N, K);
        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
