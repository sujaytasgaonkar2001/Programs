import java.util.*;
class rea {
	String str;
	int n;
	int m =0;
	Scanner read = new Scanner(System.in);
	public void read() {
		System.out.println("Enter a string");
		str = read.next();
		n = str.length();
		
	}
	public void frequency() {
		int freq[] = new int[n];
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			freq[ch-'a']++;
			if(freq[ch-'a'] > m)
				m = freq[ch-'a'] ;
		}
		
	}
	public void display() {
		char c[] = str.toCharArray();
		if(m > (str.length() - m +1)) {
			System.out.println("Not possible");
			System.exit(0);
		}
		char temp;
		for(int i=0,t=i+1;i<str.length();i++,t++) {
			for(int j=i+1;j<str.length();j++) {
				if(c[i] != c[j]) {
					if(j != i+1) {
						temp = c[t];
						c[t] = c[j];
						c[j] = temp;
					}
					break;
				}
				
			}
		}
		System.out.println("Original String : " +str);
		System.out.print("Rearranged string :");
		for(int i=0;i<str.length();i++)
			System.out.print(c[i]);
	}
}
class Main {
	public static void main(String[] args) {
		rea ra = new rea();
		ra.read();
		ra.frequency();
		ra.display();
	}
}