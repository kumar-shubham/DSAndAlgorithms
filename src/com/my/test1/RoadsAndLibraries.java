package com.my.test1;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RoadsAndLibraries {
	// Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        Set<Integer> disjointSets = new HashSet<>();

        DisjointSet1 ds = new DisjointSet1();

        for(int i = 1; i<= n; i++){
            ds.makeSet(i);
        }

        for(int i = 0; i<cities.length; i++){
            int a = cities[i][0];
            int b = cities[i][1];
            ds.union(a,b);
        }

        for(int i = 1; i<= n; i++){
            int p = ds.findSet(i);
            disjointSets.add(p);
        }

        int totalDisjointSets = disjointSets.size();
        
        System.out.println("total disjoints sets: " + totalDisjointSets);

        int minLib = totalDisjointSets;

        long minCost = Long.MAX_VALUE;

        for(long i = minLib; i<= n; i++){
            long cost = i*c_lib + (n-i)*c_road;
            if(minCost > cost){
                minCost = cost;
            }
        }
        return minCost;

    }

    public static void printArr(int[] a) {
        System.out.print("[");
        for(int i = 0; i<a.length; i++) {
            if(i<a.length-1) {
                System.out.print(a[i] + ", ");
            }
            else {
                System.out.print(a[i] + "]");
            }
        }
        System.out.println();
    }
    
    public static void printArr2D(int[][] a) {
        System.out.println("[");
        for(int i = 0; i<a.length; i++) {
            printArr(a[i]);
            if(i<a.length-1) {
            }
            else {
                System.out.println("]");
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
        }

        scanner.close();
    }
}

class DisjointSet1{

    private HashMap<Integer, Node> map = new HashMap<>();
    class Node {
        int data;
        Node parent;
        int rank;
    }

    public void makeSet(int data){
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data, node);
    }

    public boolean union(int data1, int data2){

        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node p1 = findSet(node1);
        Node p2 = findSet(node2);

        if(p1 == p2){
            return false;
        }

        if(p1.rank >= p2.rank){
            p1.rank = p1.rank == p2.rank ? p1.rank + 1: p1.rank;
            p2.parent = p1;
        }
        else{
            p1.parent = p2;
        }

        return true;

    }

    public int findSet(int data){
        return findSet(map.get(data)).data;
    }

    public Node findSet(Node node){

        Node parent = node.parent;
        if(node == parent){
            return parent;
        }

        node.parent = findSet(node.parent);

        return node.parent;
    }
}