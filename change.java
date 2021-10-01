import java.util.*;
class rearrange {
	String string1;
	int n;
	int m =0;
	Scanner read = new Scanner(System.in);
	public void read() {
		System.out.println("Enter a string");
		string1 = read.next();
		n = string1.length();
		
	}
	public void frequency() 
	{
		int freq[] = new int[n];
		for(int i=0;i<string1.length();i++) 
		{
			char character = string1.charAt(i);
			freq[character-'a']++;
			if(freq[character-'a'] > m)
			{
				m = freq[character-'a'] ;
			}	
		}
		
	}
	public void display() 
	{
		char StringN[] = string1.toCharArray();
		if(m > (string1.length() - m +1)) 
		{
			System.out.println("Rearrangement of string not possible");
			System.exit(0);
		}
		char temp;
		for(int i=0,k=i+1;i<string1.length();i++,k++) 
		{
			for(int j=i+1;j<string1.length();j++) 
			{
				if(StringN[i] != StringN[j]) 
				{
					if(j != i+1) 
					{
						temp = StringN[k];
						StringN[k] = StringN[j];
						StringN[j] = temp;
					}
					break;
				}
				
			}
		}
		System.out.println("The String Entered is : " +string1);
		System.out.print("The String after rearrangement is:");
		for(int i=0;i<string1.length();i++)
			System.out.print(StringN[i]);
	}
}
public class change 
{
	public static void main(String[] args) 
	{
		rearrange change = new rearrange();
		change.read();
		change.frequency();
		change.display();
	}
}
