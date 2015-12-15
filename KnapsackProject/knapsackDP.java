/*
Ashley Zegiestowksy
CS351 Algorithms
Zhihong Chen
December 11, 2015
0/1 Knapsack Program using Dynamic Programming Algorithm
*/

import java.io.*;
import java.util.*;
 
//Knapsack Algorithm using Dynamic Programming
public class knapsackDP 
{
    public static int knapSack(int W, int wt[], int prof[], int n)
    {
        int i, w;
        int [][]K = new int[n+1][W+1];
 
	   // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0) {
                    K[i][w] = 0;
                } else if (wt[i-1] <= w) {
                    K[i][w] = Math.max(prof[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                } else {
                    K[i][w] = K[i-1][w];
                }
            }
        }
        return K[n][W];
    }
 
    public static void main(String args[])
    {
        int W = 0, maxProfit = 0; //W = capacity of knapsack
        long start=0, stop=0, runTime=0; //initialize variables to calculate runTime

        System.out.println("***0/1 Knapsack Algorithm using Dynamic Programming***");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        //initialize size of weight and profit array to size n
        int []wt = new int[n];
        int []prof = new int[n];

        System.out.println("Press 1 to manually enter item contents, \nPress 2 to randomly generate item contents");
        int choice = sc.nextInt();

        //allows user to manually enter the weight and profit of each item, and the knapsack capcity
        if(choice == 1) {
            System.out.println("Enter the items weights: ");
            //allow user to manually enter item weights
            for(int i=0; i<n; i++)
                wt[i] = sc.nextInt();
 
            System.out.println("Enter the items profits: ");
            //allow user to manually enter item profits
            for(int i=0; i<n; i++)
                prof[i] = sc.nextInt();
 
            System.out.println("Enter the maximum capacity of the knapsack: ");
            //allow user to manually enter knapsack capcity
            W = sc.nextInt();

        } else if (choice == 2) {
            Random rn = new Random();

            //randomly generate item weights (between 1 and 30)
            for(int i=0; i<n; i++) 
                wt[i] = (int)rn.nextInt(30)+1;
 
            //randomly generate item profits (between 1 and 50)
            for(int i=0; i<n; i++) 
                prof[i] = (int)rn.nextInt(50)+1;
 
            //randomly generate knapsack capacity (between 1 and 50)
            W = (int)rn.nextInt(50)+1;           
        } 

        //print all items being evaluated
        System.out.println("Knapsack Capcity: " + W);
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "density");
        for (int i=0; i<n; i++) {
            System.out.println(i+1 + "\t" + prof[i] + "\t" + wt[i] + "\t" + (double)prof[i]/(double)wt[i]);
        }

        //calculate runtime of the dynammic programming algorithm
        start = System.currentTimeMillis();
        maxProfit = knapSack(W, wt, prof, n); //calculate the max profit of the knapsack
        stop = System.currentTimeMillis();
        runTime = stop-start;

        //print out the max profit and runtime for the knapsack
        System.out.println("The maximum profit that can be put in a knapsack of capacity "+ W +" is: " + maxProfit);
        System.out.println("Runtime (milliseconds): "+ runTime);
        sc.close();
    }
}

/*
-----Sample Run (using exercise 33 from book)-----
***0/1 Knapsack Algorithm using Dynamic Programming***
Enter the number of items: 
5
Press 1 to manually enter item contents, 
Press 2 to randomly generate item contents
1
Enter the items weights: 
2
5
7
3
1
Enter the items profits: 
20
30
35
12
3
Enter the maximum capacity: 
9
Knapsack Capcity: 9
item    profit  weight  density
1   20  2   10.0
2   30  5   6.0
3   35  7   5.0
4   12  3   4.0
5   3   1   3.0
The maximum profit that can be put in a knapsack of capacity 9 is: 55
Runtime (milliseconds): 0

-----Sample Run (using 25 items)-----
***0/1 Knapsack Algorithm using Dynamic Programming***
Enter the number of items: 
25
Press 1 to manually enter item contents, 
Press 2 to randomly generate item contents
2
Knapsack Capcity: 32
item    profit  weight  density
1   27  14  1.9285714285714286
2   42  22  1.9090909090909092
...
24  50  6   8.333333333333334
25  41  20  2.05
The maximum profit that can be put in a knapsack of capacity 32 is: 200
Runtime (milliseconds): 0

-----Sample Run (using 100 items)-----
***0/1 Knapsack Algorithm using Dynamic Programming***
Enter the number of items: 
100
Press 1 to manually enter item contents, 
Press 2 to randomly generate item contents
2
Knapsack Capcity: 23
item    profit  weight  density
1   35  26  1.3461538461538463
2   21  11  1.9090909090909092
...
99  20  29  0.6896551724137931
100 13  9   1.4444444444444444
The maximum profit that can be put in a knapsack of capacity 23 is: 231
Runtime (milliseconds): 1
*/
