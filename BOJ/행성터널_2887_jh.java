package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] parent;
	public static int n;

	public static class point{
		int num;
		int x;
		int y;
		int z;

		public point(int num, int x, int y, int z){
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static class node implements Comparable<node>{
		int start;
		int end;
		int weight;
		public node(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(node n){
			return this.weight - n.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		List<point> input = new ArrayList<>();
		List<node> list = new ArrayList<>();
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			input.add(new point(i, x, y, z));
		}

		Collections.sort(input,new Comparator<point>(){
			@Override
			public int compare(point p1, point p2){
				return p1.x - p2.x;
			}
		});

		for(int i = 0; i < n - 1; i++){
			int dist = Math.abs(input.get(i).x - input.get(i+1).x);
			list.add(new node(input.get(i).num,input.get(i+1).num,dist));
		}

		Collections.sort(input,new Comparator<point>(){
			@Override
			public int compare(point p1, point p2){
				return p1.y - p2.y;
			}
		});

		for(int i = 0; i < n - 1; i++){
			int dist = Math.abs(input.get(i).y - input.get(i+1).y);
			list.add(new node(input.get(i).num,input.get(i+1).num,dist));
		}

		Collections.sort(input,new Comparator<point>(){
			@Override
			public int compare(point p1, point p2){
				return p1.z - p2.z;
			}
		});

		for(int i = 0; i < n - 1; i++){
			int dist = Math.abs(input.get(i).z - input.get(i+1).z);
			list.add(new node(input.get(i).num,input.get(i+1).num,dist));
		}
		Collections.sort(list);
		parent = new int[n];
		for(int i = 0; i < n; i++){
			parent[i] = i;
		}
		int answer = 0;
		for(int i = 0; i < list.size(); i++){
			node n = list.get(i);

			if(find(n.start) != find(n.end)){
				answer += n.weight;
				union(n.start, n.end);
			}
		}
		System.out.println(answer);
	}
	public static void union(int x, int y){
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot != yRoot) parent[yRoot] = xRoot;
	}
	public static int find(int x){
		if(parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}
}
