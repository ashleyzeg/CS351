/*
Ashley Zegiestowksy
CS351 Algorithms
Zhihong Chen
December 11, 2015
0/1 Knapsack Program using Bruteforce Algorithm
*/

public class knapsackBF
{
	private static final int Cap = 9;

	public static void main(String [] args)
	{
		//hard-coded list of item profit and weight
		int [] p = {20,30,35,12,3}; 
		int [] w = {2,5,7,3,1};
		long start=0, stop=0, runTime=0; 


		System.out.println("***0/1 Knapsack Algorithm using Bruteforce***");
		start = System.currentTimeMillis();
		int maxProfit = forceful(p,w);
		stop = System.currentTimeMillis();
		runTime = stop-start;
		System.out.println("Max Profit: " + maxProfit);
		System.out.println("Runtime (milliseconds): " + runTime);
	}

	public static int forceful(int [] p, int [] w)
	{
		int maxprofit = 0, i = 0;

		int [] benefit = new int[(int) Math.pow(2, 5)];
		int [] weight = new int[(int) Math.pow(2, 5)];

		for(int a = 0; a <= 1; a++)
			for(int b = 0; b <= 1; b++)
				for(int c = 0; c <= 1; c++)
					for(int d = 0; d <= 1; d++)
						for(int e = 0; e <= 1; e++)
						{
							if(a==1)
							{
								benefit[i] += p[0];
								weight[i] += w[0];
							}
							if(b==1)
							{
								benefit[i] += p[1];
								weight[i] += w[1];
							}
							if(c==1)
							{
								benefit[i] += p[2];
								weight[i] += w[2];
							}
							if(d==1)
							{
								benefit[i] += p[3];
								weight[i] += w[3];
							}
							if(e==1)
							{
								benefit[i] += p[4];
								weight[i] += w[4];
							}
							i++;
						}

		for(int j = 0; j < benefit.length; j++)
			if(maxprofit < benefit[j] && weight[j] <= Cap)
				maxprofit = benefit[j];

		return maxprofit;
	}
}

/*
-----Sample Run (using exercise 33 from book)-----
***0/1 Knapsack Algorithm using Bruteforce***
Max Profit: 55
Runtime (milliseconds): 0
*/