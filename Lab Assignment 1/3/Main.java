package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    class Edge {
        int src, dest, weight;
        Edge()
        {
            src = dest = weight = 0;
        }
    };
    public static class destination {
        int dest, weight;
        destination()
        {
            dest = weight = 0;
        }
    };

    int V, E;
    Edge edge[];
    static boolean reachable = true;

    Main(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    static int BellmanFord(Main graph, int src, int dest)
    {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Negative cycles Exist");
                reachable = false;
                return Integer.MIN_VALUE;
            }
        }
        return dist[dest];
    }

    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void addEdge(ArrayList<ArrayList<destination> > adj,
                        int u, int v, int d)
    {
        destination obj = new destination();
        obj.dest = v;
        obj.weight = d;
        adj.get(u).add(obj);

        destination obj2 = new destination();
        obj.dest = u;
        obj.weight = d;
        adj.get(v).add(obj2);
    }

    public static void dfs(ArrayList<ArrayList<destination> > adj, ArrayList<Integer> path,int startVertex, int endVertex, int[] visited, int travelled){
        visited[startVertex] = 1;
        path.add(startVertex);
        // System.out.println(startVertex);
        if(startVertex == endVertex) {
            for(int i=0;i<path.size();++i){
                System.out.print(path.get(i)+" ");
            }
            System.out.println("with a cost of "+travelled);

            int index = path.size()-1;
            path.remove(index);
            visited[startVertex] = 0;
            return;
        }
        else {
            for (int i = 0; i < adj.get(startVertex).size(); i++) {

                if (visited[adj.get(startVertex).get(i).dest] == 0) {
                    dfs(adj, path, adj.get(startVertex).get(i).dest, endVertex, visited, travelled + adj.get(startVertex).get(i).weight);
                }
            }
            int index = path.size()-1;
            path.remove(index);
            visited[startVertex] = 0;
        }
    }

    public static void main(String[] args) {
        // write your code here

        reachable = true;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();

        ArrayList<ArrayList<destination> > adj
                = new ArrayList<ArrayList<destination> >(v);

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<destination>());
        }

        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();

        Main graph = new Main(v, e);

        for(int i=0;i<e;++i) {
            int s,ee,d;
            System.out.print("Enter the starting vertex of the edge: ");
            s = scanner.nextInt();
            System.out.print("Enter the ending vertex of the edge: ");
            ee = scanner.nextInt();
            System.out.print("Enter the weight of the edge: ");
            d = scanner.nextInt();

            destination obj = new destination();
            obj.dest = ee;
            obj.weight = d;
            adj.get(s).add(obj);

            destination obj2 = new destination();
            obj2.dest = s;
            obj2.weight = d;
            adj.get(ee).add(obj2);

            graph.edge[i].src = s;
            graph.edge[i].dest = ee;
            graph.edge[i].weight = d;

        }

//        for(int i=0;i<adj.size();++i) {
//            for(int j=0;j<adj.get(i).size();++j){
//                System.out.print(adj.get(i).get(j).dest+" ");
//            }
//            System.out.println();
//        }

        System.out.println("Let's check between two nodes: ");
        System.out.print("Enter the starting vertex to start with: ");
        int startVertex = scanner.nextInt();
        System.out.print("Enter the ending vertex to end with: ");
        int endVertex = scanner.nextInt();

        int distance = BellmanFord(graph, startVertex, endVertex);

        if(distance == Integer.MAX_VALUE){
            System.out.println("Negative cycles Exist");
            return;
        }

        if(reachable == true) {
            System.out.println("Minimum Distance between source and destination: " + distance);

            System.out.println("All the paths from source to destination: ");

            ArrayList<Integer> path = new ArrayList<Integer>();
            int[] visited = new int[v];
            dfs(adj, path,startVertex,endVertex, visited, 0);
        }

    }
}
