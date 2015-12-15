import java.util.*;

class items
{
	int number;
	int profit;
	int weight;
	
	 public items(Scanner f)
     {		 
		 number = f.nextInt();		
		 profit = f.nextInt();
		 weight = f.nextInt();	 
     }
	 
	 public int getNumber()
	 {
		 return number;
	 }	 
	 public int getProfit()
	 {
		 return profit;
	 }
	 public int getWeight()
	 {
		 return weight;
	 }	 
	 
	  public String toString()
	  {
	    return "Item number: " +number+ " Profit= " +profit+ " Weight= "+weight;
	  }
}