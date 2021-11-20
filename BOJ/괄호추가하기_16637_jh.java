package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String st =br.readLine();
		List<Integer> number = new ArrayList<>();
		List<Character> op = new ArrayList<>();
		for(char c : st.toCharArray()){
			if(c == '+' || c == '-' || c== '*')
				op.add(c);
			else
				number.add(c - '0');
		}
		System.out.println(number);
		System.out.println(op);
	}
}
