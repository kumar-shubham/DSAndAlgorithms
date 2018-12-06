package com.my.test1;

import java.util.Scanner;

public class TestClass {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = s.nextInt();
		}

		int m = s.nextInt();
		int[][] cost = new int[m][3];

		for (int i = 0; i < m; i++) {
			cost[i][0] = s.nextInt();
			cost[i][1] = s.nextInt();
			cost[i][2] = s.nextInt();
		}

		int graph[][] = new int[n][n];

		for (int i = 0; i < cost.length; i++) {
			int[] arr = cost[i];
			int x = arr[0];
			int y = arr[1];
			int z = arr[2];
			graph[x - 1][y - 1] = z;
			graph[y - 1][x - 1] = z;
		}

		int distAll[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			int dist[] = new int[n];
			dijkstra(graph, i, dist, n);
			distAll[i] = dist;
		}
		
		int totalCost = 0;
		for(int i = 0; i<n; i++) {
			int a1 = a[i];
			int b1 = b[i];
			if(a1 != b1) {
				int c = distAll[a1-1][b1-1];
			    if(c == Integer.MAX_VALUE) {
			    	System.out.println(-1);
			    	return;
			    }
				totalCost += distAll[a1-1][b1-1];
			}
		}
		
		System.out.println(totalCost);
		return;
	}

	static void dijkstra(int graph[][], int src, int dist[], int V) {

		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V-1; count++) {
			int u = minDistance(dist, sptSet, V);

			sptSet[u] = true;

			for (int v = 0; v < V; v++)

				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

	}

	static int minDistance(int dist[], Boolean sptSet[], int V) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}
}
