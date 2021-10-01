import java.util.Scanner;
public class program3A
{
	public static void main(String args[])
	{
		int a, b, quotient;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value of A :");
		a = scan.nextInt();
		System.out.println("Enter the value of B :");
		b = scan.nextInt();
		try
		{
			quotient = a/b;
			System.out.println("Quotient = " +quotient);
		}
		catch(ArithmeticException ae)
		{
			System.out.println(ae);
		}
	}
}