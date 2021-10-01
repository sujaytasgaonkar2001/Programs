import java.util.Random;
import java.util.Scanner;

class SLL
{
	class Node		
	{
		int data;
		Node next;
		public Node(int d)
		{
			data = d;
			next = null;
		}
	}
	Node first;
	
	void insert(int data)	
	{
		if(first == null)
		{
			first = new Node(data);
			return;
		}
		else
		{
			Node pre = first;
			while(pre.next != null)
				pre = pre.next;
			
			Node newNode = new Node(data);
			pre.next = newNode;
		}
	}
	
	void print(Node n)	
	{
		while(n != null)
		{
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	
	Node getTail(Node start)	
	{
		Node n = start;
		while(n.next != null)
			n = n.next;
		return n;
	}
	
	void preSort(Node start)
	{
		sort(start,getTail(start));
		return;
	}
	void sort(Node start, Node end)
	{
		if(start == null || start == end)
			return;
		
		Node pivot_prev = partition(start , end);
		sort(start, pivot_prev);
		
		if(pivot_prev != null && pivot_prev == start)
			sort(pivot_prev.next, end);
		
		else if(pivot_prev != null && pivot_prev.next != null)
			sort(pivot_prev.next.next, end);
	}
	
	Node partition(Node start, Node end)
	{
		if(start == null || start == end || end == null)
			return start;
		Node pivot_prev = start;
		Node pre = start;
		int pivot = end.data;
		
		while(start != end)
		{
			if(start.data < pivot)
			{
				pivot_prev = pre;
				int temp = pre.data;
				pre.data = start.data;
				start.data = temp;
				pre = pre.next;
			}
			start = start.next;
		}
		int temp = pre.data;
		pre.data = pivot;
		end.data = temp;
		
		return pivot_prev;
	}
}
public class quickSSL {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SLL list = new SLL();
		
		Scanner read = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Enter number of elements to be sorted");
		int m = read.nextInt();
		for(int y = 0 ; y<m; y++)
		{
			list.insert(rand.nextInt(10000));
		}
		System.out.println("\nElements to be sorted are");
		list.print(list.first);
		
		list.preSort(list.first);
		
		System.out.println("\nSorted list is ");
		list.print(list.first);
	}
}