package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] block = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < w; i++){
			block[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}

