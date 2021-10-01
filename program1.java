import java.util.*;

class Student {
    String Usn, Name, Branch, Phone;

    public Student(String usn, String name, String branch, String phone) {
        Usn = usn;
        Name = name;
        Branch = branch;
        Phone = phone;
    }
}

public class program1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Number of Students : ");
        int n = in .nextInt();

        Student[] st = new Student[n];
        String usn, name, branch, phone;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of Student " + (i + 1));
            System.out.println("Enter Usn : ");
            usn = in .next();
            System.out.println("Enter Name : ");
            name = in .next();
            System.out.println("Enter Branch : ");
            branch = in .next();
            System.out.println("Enter Phone : ");
            phone = in .next();

            st[i] = new Student(usn, name, branch, phone);
        }

        System.out.println("Students details : ");
        System.out.println("USN \t\tName \t\tBranch \t\tPhone ");

        for (int i = 0; i < n; i++) {
            System.out.println(st[i].Usn + "\t\t" + st[i].Name + "\t\t" + st[i].Branch + "\t\t" + st[i].Phone + "\t\t");
        }
    }
}