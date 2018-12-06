package com.my.test1;

public class Dijkstra 
{ 
 // A utility function to find the vertex with minimum distance value, 
 // from the set of vertices not yet included in shortest path tree 
 int minDistance(int dist[], Boolean sptSet[]) 
 { 
     // Initialize min value 
     int min = Integer.MAX_VALUE, min_index=-1; 

     for (int v = 0; v < 9; v++) 
         if (sptSet[v] == false && dist[v] <= min) 
         { 
             min = dist[v]; 
             min_index = v; 
         } 

     return min_index; 
 } 

 // A utility function to print the constructed distance array 
 void printSolution(int dist[], int n) 
 { 
     System.out.println("Vertex   Distance from Source"); 
     for (int i = 0; i < 9; i++) 
         System.out.println(i+" tt "+dist[i]); 
 } 

 // Funtion that implements Dijkstra's single source shortest path 
 // algorithm for a graph represented using adjacency matrix 
 // representation 
 void dijkstra(int graph[][], int src, int dist[]) 
 {

     // sptSet[i] will true if vertex i is included in shortest 
     // path tree or shortest distance from src to i is finalized 
     Boolean sptSet[] = new Boolean[9]; 

     // Initialize all distances as INFINITE and stpSet[] as false 
     for (int i = 0; i < 9; i++) 
     { 
         dist[i] = Integer.MAX_VALUE; 
         sptSet[i] = false; 
     } 

     // Distance of source vertex from itself is always 0 
     dist[src] = 0; 

     // Find shortest path for all vertices 
     for (int count = 0; count < 8; count++) 
     { 
         // Pick the minimum distance vertex from the set of vertices 
         // not yet processed. u is always equal to src in first 
         // iteration. 
         int u = minDistance(dist, sptSet); 

         // Mark the picked vertex as processed 
         sptSet[u] = true; 

         // Update dist value of the adjacent vertices of the 
         // picked vertex. 
         for (int v = 0; v < 9; v++) 

             // Update dist[v] only if is not in sptSet, there is an 
             // edge from u to v, and total weight of path from src to 
             // v through u is smaller than current value of dist[v] 
             if (!sptSet[v] && graph[u][v]!=0 && 
                     dist[u] != Integer.MAX_VALUE && 
                     dist[u]+graph[u][v] < dist[v]) 
                 dist[v] = dist[u] + graph[u][v]; 
     } 

     // print the constructed distance array 
     printSolution(dist, 9); 
 } 

 // Driver method 
 public static void main (String[] args) 
 { 
     /* Let us create the example graph discussed above */
    int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                               {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                               {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                               {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                               {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                               {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                               {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                               {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                               {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                              }; 
     int[] a = {1, 2, 4, 3, 4, 7, 5};
     int[] b = {5, 2, 3, 2, 7, 2, 6};
     int[][] d = {{1, 6, 20}, {1, 5, 10}, {2, 4, 5}, {4, 3, 50}, {4, 7, 12}, {3, 7, 18}};
     int g[][] = new int[9][9];
     for(int i = 0; i<d.length; i++) {
    	 int[] arr = d[i];
    	 int x = arr[0];
    	 int y = arr[1];
    	 int z = arr[2];
    	 g[x-1][y-1] = z;
    	 g[y-1][x-1] = z;
     }
     Printer.printArr2D(g);
     
     int distAll[][] = new int[9][9];
     Dijkstra t = new Dijkstra(); 
     for(int i = 0; i<9;i++) {
    	 int dist[] = new int[9];
    	 t.dijkstra(g, i, dist); 
    	 distAll[i] = dist;
     }
     Printer.printArr2D(distAll);
 } 
} 
