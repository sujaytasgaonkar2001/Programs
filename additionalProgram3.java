import java.util.*;
public class additionalProgram 
{
	public static void main(String[] args)
	{
		Scanner elements =new Scanner(System.in);
		
		int i, j, mainArray = 0, subArray = 0, flag = 0;
		
		System.out.println("Enter the number of elements of array A");
		mainArray =elements .nextInt();
		int []arrayA = new int[mainArray];
		
		System.out.println("Enter the number of elements of array B");
		subArray=elements .nextInt();
		int []arrayB = new int[subArray];
		
		if(subArray<=mainArray)
		{	
			System.out.println("Enter elements of array A");
			for(i=0;i<mainArray ;i++)
			{
				arrayA[i] = elements .nextInt();
			}
		
			System.out.println("Enter elements of array B");
			for(i=0;i<subArray;i++)
			{
				arrayB[i] = elements .nextInt();
			} 
		
			for(j=0;j<subArray;j++)
				for(i=0; i < mainArray ;i++)
				{
					if(arrayB[j] == arrayA[i])
					{
						flag++;
						break;
					}
				}
			if (flag == subArray)
				System.out.println("It is a Subset");
			else
				System.out.println("It is not a Subset");
		}
		else 
			System.out.println("Invalid Input!");
		}

}