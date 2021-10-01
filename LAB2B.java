import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Customer
{
 private String name;
 private String dob;

 void Read_Customer(String n, String d)
 {
 name = n;
 dob = d;
 }

 void Display_Customer()
 {
 StringTokenizer st = new StringTokenizer(dob,"/");
 System.out.println("Customer details are");
 System.out.println("Name," + "\t" + "DD, MM, YYYY");
 System.out.print(name+",\t");

 while(st.hasMoreTokens())
 {
 System.out.print(st.nextToken() + ", ");
 }
 }
}
class LAB2B {
 public static void main(String[] args) throws Exception
 {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 Customer c = new Customer();

 System.out.println("Enter name");
 String name = br.readLine();

 System.out.println("Enter DOB in (DD/MM/YYYY) format only");
 String dob = br.readLine();

 c.Read_Customer(name, dob);
 c.Display_Customer();
 }
}