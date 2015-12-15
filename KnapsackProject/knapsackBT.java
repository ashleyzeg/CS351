/*
Ashley Zegiestowksy
CS351 Algorithms
Zhihong Chen
December 11, 2015
0/1 Knapsack Program using Backtracking Algorithm
*/

import java.io.*;
import java.util.*;

public class knapsackBT
{
	public static int n;
	public static int Cap;
	public static String [] include;
	public static String [] bestset;
	public static items [] items;
	public static int numbest = 0;
	public static int maxprofit = 0;
	public static int totweight=0;

	public static void main(String [] args) throws FileNotFoundException
	{
		
		System.out.println("***0/1 Knapsack Algorithm using Backtracking***");
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the filename that contains the information about the items");
		String filename = input.nextLine();

		Scanner file = new Scanner(new FileReader(filename));
		n = file.nextInt();
		n++;
		Cap = file.nextInt();
		include = new String[n];
		bestset = new String[n];
		items = new items[n];

		//populate each item from file
		for(int i=1; i<n; i++)
		{
			items[i] = new items(file);
		}

		//calculate runTime
		long start=0, stop=0, runTime=0; 
		start = System.currentTimeMillis();
		knapsack(0,0,0);
		stop = System.currentTimeMillis();
		runTime = stop-start;

		int sackWeight=0;

		for(int k=1; k < n; k++)
		{
			if(bestset[k]=="yes")
				sackWeight += items[k].getWeight();

		}

		System.out.println("Amount of items: " +numbest);
		System.out.println("Max profit: " +maxprofit);
		System.out.println("Total weight: " +sackWeight+ "\n");
		System.out.println("Items picked:");
		System.out.println("Item" + "\t" + "Profit" + "\t" + "Weight");

		for(int j = 1; j < n; j++) {
			if(bestset[j] == "yes") {
				System.out.println(j + "\t" + items[j].getProfit() + "\t" + items[j].getWeight());
			}
		}

		System.out.println("\nRuntime (milliseconds): " + runTime);

	}

	public static void knapsack(int i, int profit, int weight)
	{
		if (weight <= Cap && profit > maxprofit)
		{
			maxprofit = profit;
			numbest = i-1;

			for(int j = 0; j < n; j++)
				bestset[j] = include[j];
		}

		if(promising(i, weight, profit))
		{
			include[i+1] = "yes";
			knapsack(i+1, profit + items[i+1].getProfit(), weight + items[i+1].getWeight());
			include[i+1] = "no";
			knapsack(i+1, profit, weight);
		}
	}

	public static boolean promising(int i, int weight, int profit)
	{
		int j, k;
		float bound;

		if(weight >= Cap)
			return false;
		else
		{
			j = i+1;
			bound = profit;
			totweight = weight;
			while (j < n && totweight + items[j].getWeight() <= Cap)
			{
				totweight = totweight + items[j].getWeight();
				bound = bound + items[j].getProfit();
				j++;
			}
			k = j;
			if (k < n)
				bound = bound + (Cap - totweight) * (items[k].getProfit()/items[k].getWeight());

			return bound > maxprofit;
		}
	}
}

/*
-----Sample Run (using exercise 33 from book)-----
***0/1 Knapsack Algorithm using Backtracking***
Please enter the filename that contains the information about the items
items.txt
Amount of items: 2
Max profit: 55
Total weight: 9

Items picked:
Item	Profit	Weight
1	20	2
3	35	7

Runtime (milliseconds): 0

-----Sample Run (using 25 items)-----
***0/1 Knapsack Algorithm using Backtracking***
Please enter the filename that contains the information about the items
items25.txt
Amount of items: 7
Max profit: 1480
Total weight: 30

Items picked:
Item	Profit	Weight
1	200	4
2	150	3
3	250	5
4	350	7
5	98	2
8	432	9

Runtime (milliseconds): 0

-----Sample Run (using 100 items)-----
***0/1 Knapsack Algorithm using Backtracking***
Please enter the filename that contains the information about the items
items100.txt
Amount of items: 12
Max profit: 3235
Total weight: 67

Items picked:
Item	Profit	Weight
1	200	4
2	150	3
3	250	5
4	350	7
5	98	2
6	49	1
7	196	4
8	432	9
9	528	11
10	517	11
11	235	5
13	230	5
*/