import java.util.Arrays;
import java.util.Scanner;

/**
 * An class used to wrap properties of an item.
 * We implement the Comparable interface so that
 * we can sort an array of objects of this type
 * in descending order.
 *
 */

class Item implements Comparable<Item> {
	/**
	 * The weight of the item
	 */
	public float weight;
	
	/**
	 * Profit of the item
	 */
	public float profit;
	
	/**
	 * Per item profit for the item
	 */
	public float perItemProfit;
	
	/**
	 * Constructor - Used to initialize the data 
	 * members of the class
	 * @param w	The weight of the item
	 * @param p	The profit of the item
	 */
	public Item(float w, float p) {
		weight = w;
		profit = p;
		perItemProfit = p / w;
	}

	@Override
	//compares two strings 
	public int compareTo(Item o) {
		if (perItemProfit < o.perItemProfit)
			return 1;
		else if (perItemProfit > o.perItemProfit)
			return -1;
		else
			return 0;
	}
}

public class FractionalKnapsack {
	
	/**
	 * The items for which knapsack problem needs to be applied
	 */
	private Item[] items;
	
	/**
	 * Constructor
	 * @param w	- The weights 
	 * @param p	- The profits associated with the weights
	 */
	public FractionalKnapsack(float[] w, float[] p)	{
		// initialize the array based on the number of elements
		int count = w.length;
		items = new Item[count];
		
		// create the items and add it to the array
		for (int i = 0; i < count; i++) {
			Item item = new Item(w[i], p[i]);
			items[i] = item;
		}
	}
	
	/**
	 * Function that returns the max profit based on the 
	 * for the weights and profits specified in the items
	 * @param maxCapacity	The maximum capacity of the knapsack
	 */
	public float getMaxProfit(int maxCapacity) {
		int index = 0;
		float totalWeight = 0;
		float totalProfit = 0;
		float remainingWeight = maxCapacity;
		int itemCount = items.length;
		
		// order the items in descending order of the per item profit
		Arrays.sort(items);
		System.out.println("Sorted PiP(Per Item Profit):");
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i].perItemProfit +"   ");
		}
		System.out.println();

		
		// Iterate over the items and keep adding it
		// to the knapsack until it is full
		while (index < itemCount && remainingWeight > 0) {
			float itemWeight = items[index].weight;
			float itemPip = items[index].perItemProfit;
			
			float weightThatCanBeAdded = 0;
			if (itemWeight < remainingWeight) {
				// the item weight is less that the total weight that
				// can still be added to the knapsack. Consider the 
				// entire weight of the item
				weightThatCanBeAdded = itemWeight;
			}
			else {
				// item weight is more that the total weight that
				// can still be added to the knapsack. Consider
				// only that part of the item weight that can be added
				weightThatCanBeAdded = remainingWeight;
			}
			
			totalWeight += weightThatCanBeAdded;
			totalProfit += (weightThatCanBeAdded * itemPip);
			remainingWeight -= weightThatCanBeAdded;
			index++;
		}
		
		return totalProfit;
	}
	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of array elements: ");
		int n = input.nextInt();
		System.out.println("Enter the capacity of Knapsack : ");
		int capacity = input.nextInt();
		float [ ] weights = new float [n];
		float [ ] profits = new float [n];
		System.out.println("Enter the weights: ");
		for (int i = 0; i < n; i++)
		{
           weights[i] = input.nextFloat();   	                         
		}
		System.out.println("Enter the profits: ");
		for (int i = 0; i < n; i++)
		{
           profits[i] = input.nextFloat();   	                         
		}
		//float weights[] = { 10, 5, 8, 3 };
		//float profits[] = { 20, 90, 40, 30 };
		
		FractionalKnapsack knapSack = new FractionalKnapsack(weights, profits);
		float optimalProfit = knapSack.getMaxProfit(capacity);
		
        System.out.println("Optimal profit is: " + optimalProfit); 
    }
}	
	