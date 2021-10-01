import java.io.*;
import java.util.Scanner;

class Stack
{
	private int stack[];
	private int top,maxsize;
	public Stack(int s)
	{
		maxsize=s;
		stack=new int[maxsize];
		top=-1;
	}
	public void push(int p)
	{
		if(top==maxsize-1)
			System.out.println("Stack Overflow");
		else
		{
			stack[++top]=p;
			System.out.println("Element "+p+" pushed");
		
		}
	}
	public void pop()
	{
		if(top==-1)
			System.out.println("Stack Underflow");
		else
		{
			System.out.println("Element "+(stack[top--])+" popped");
		}
	}
	public void display()
	{
		if(top==-1)
			System.out.println("Underflow");
		else
		{
			for(int i=top;i>=0;i--)
				System.out.println(stack[i]);
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n=sc.nextInt();
		Stack s=new Stack(n);
		int choice;
		for(;;)
		{
			System.out.println("Enter Your choice : \n 1.PUSH \n 2.POP \n 3.DISPLAY \n 4.EXIT");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:System.out.println("Enter the element to be pushed");
				int item=sc.nextInt();
				s.push(item);
				break;
				case 2:s.pop();
				break;
				case 3:s.display();
				break;
				case 4:break;
			}
		}
	}

}