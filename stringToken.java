import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Customer {
    private String name;
    private String DOB;

    void readCustomerDetails(String Name, String dateofbirth) {
        name = Name;
        DOB = dateofbirth;
    }

    void displayCustomerDetails() {
        StringTokenizer tokens = new StringTokenizer(DOB, "/");
        System.out.println("Customer details are");
        System.out.println("Name," + "\t" + "DD, MM, YYYY");
        System.out.print(name + ",\t");

        while (tokens.hasMoreTokens()) {
            System.out.print(tokens.nextToken() + ", ");
        }
    }
}
class stringToken {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Customer newUser = new Customer();

        System.out.println("Enter the Name");
        String name = reader.readLine();

        System.out.println("Enter DOB in (DD/MM/YYYY) format");
        String dob = reader.readLine();

        newUser.readCustomerDetails(name, dob);
        newUser.displayCustomerDetails();
    }
}