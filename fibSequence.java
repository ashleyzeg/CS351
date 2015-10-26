/*
Ashley Zegiestowsky
10/23/2015
CS351 Algorithms
Fibonacci Sequence using recursion, dynamic programming with array, and
dynamic programming without array
*/

import java.io.*;
import java.util.*;

public class fibSequence {
	public static void main(String [] args) {

		double start, stop, runTime;
		int fib1, fib2, fib3;

		System.out.println("*** Welcome to the Fibonacci Sequence Program! ***");
		System.out.println("Please enter which number in the Fibonacci Sequence \nyou would like to know: (-1 to exit)");

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while (num != -1) {
			
			start = System.currentTimeMillis();
			fib2 = fibWithArray(num);
			stop = System.currentTimeMillis();
			runTime = (stop - start)/1000;
			System.out.println("Fib with Array: " + fib2 + ", Run Time (seconds): " + runTime);

			start = System.currentTimeMillis();
			fib3 = fibWithArray(num);
			stop = System.currentTimeMillis();
			runTime = (stop - start)/1000;
			System.out.println("Fib without Array: " + fib3 + ", Run Time (seconds): " + runTime);

			start = System.currentTimeMillis();
			fib1 = fibRecursive(num);
			stop = System.currentTimeMillis();
			runTime = (stop - start)/1000;
			System.out.println("Fib with Recursion: " + fib1 + ", Run Time (seconds): " + runTime);

			num = in.nextInt();
		}
	}

	//ANALYSIS: Highest n possible that will complete in 5 minutes is n=54 (the 54rd term in the fibonacci sequence)
	//When n = 54, the running time for the fibRecursive function is approximately 4 minutes & 55 seconds
	//Exponential Time Complexity: O(2^n)
	public static int fibRecursive(int n) {
		if (n == 1 || n ==2) return 1;
		return fibRecursive(n-1) + fibRecursive(n-2);
	}

	//Linear Time Complexity: O(n) 
	public static int fibWithArray(int n) {
		int f[] = new int [n+1];
		f[1] = f[2] = 1;
		if (n <= 2) return f[1];
		for (int i=3; i<=n; i++) 
			f[i] = f[i-1] + f[i-2];
		return f[n];
	}

	//Linear Time Complexity: O(n)
	public static int fibWithOutArray(int n) {
		int a =1; int b=1; int c=1;
		if (n <= 2) return a;
		for (int i=3; i <= n; i++) {
			c=a;
			a=a+b;
			b=c;
		}
		return a;
	}
}