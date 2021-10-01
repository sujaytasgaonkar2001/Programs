import java.io.*;
class Staff {
    private int staffid;
    private String name;
    private long phone;
    private int salary;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void Read_Staff() throws Exception {
        System.out.println("Enter Staff ID");
        staffid = Integer.parseInt(br.readLine());
        System.out.println("Enter Staff Name");
        name = br.readLine();
        System.out.println("Enter Staff Phone number");
        phone = Long.parseLong(br.readLine());
        System.out.println("Enter Staff Salary");
        salary = Integer.parseInt(br.readLine());
    }

    void Display_Staff() {
        System.out.print(staffid + "\t" + name + "\t" + phone + "\t" + salary + "\t");
    }
}
class Teaching extends Staff{
    private String domain;
    private String pub;

    void Read_Teaching() throws Exception {
        super.Read_Staff();
        System.out.println("Enter Domain");
        domain = br.readLine();
        System.out.println("Enter Publications");
        pub = br.readLine();
    }

    void Display_Teaching() {
        super.Display_Staff();
        System.out.println(domain + "\t" + pub);
    }
}
class Technical extends Staff {
    private String skills;

    void Read_Technical() throws Exception {
        super.Read_Staff();
        System.out.println("Enter skills");
        skills = br.readLine();
    }

    void Display_Technical() {
        super.Display_Staff();
        System.out.println(skills);
    }
}
class Contract extends Staff {
    private float period;

    void Read_Contract() throws Exception {
        super.Read_Staff();
        System.out.println("Enter Experience in years");
        period = Float.parseFloat(br.readLine());
    }

    void Display_Contract() {
        super.Display_Staff();
        System.out.println(period);
    }
}
class LAB2A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your choice");
        System.out.println("1. Teaching \n 2. Technical \n 3. Contract ");
        int ch = Integer.parseInt(br.readLine());

        System.out.println("Enter number of records");
        int no = Integer.parseInt(br.readLine());

        switch (ch) {
            case 1:
                Teaching[] t = new Teaching[no];
                for (int i = 0; i < t.length; i++) {
                    System.out.println("Enter " + (i + 1) + " details");
                    t[i] = new Teaching();
                    t[i].Read_Teaching();
                }
                System.out.println("Teaching Staff details are as follows:");
                System.out.println("StaffID" + "\t" + "Name" + "\t" + "Phone" + "\t\t" + "Salary" + "\t" +
                    "Domain" + "\t" + "Publications");
                for (int i = 0; i < t.length; i++) {
                    t[i].Display_Teaching();
                }
                break;
            case 2:
                Technical[] tech = new Technical[no];
                for (int i = 0; i < tech.length; i++) {
                    System.out.println("Enter " + (i + 1) + " details");
                    tech[i] = new Technical();
                    tech[i].Read_Technical();
                }
                System.out.println("Technical Staff details are as follows:");
                System.out.println("StaffID" + "\t" + "Name" + "\t" + "Phone" + "\t\t" + "Salary" + "\t" +
                    "Skills");
                for (int i = 0; i < tech.length; i++) {
                    tech[i].Display_Technical();
                }
                break;
            case 3:
                Contract[] c = new Contract[no];
                for (int i = 0; i < c.length; i++) {
                    System.out.println("Enter " + (i + 1) + " details");
                    c[i] = new Contract();
                    c[i].Read_Contract();
                }
                System.out.println("Technical Staff details are as follows:");
                System.out.println("StaffID" + "\t" + "Name" + "\t" + "Phone" + "\t\t" + "Salary" + "\t" + "Period");
                for (int i = 0; i < c.length; i++) {
                    c[i].Display_Contract();
                }
                break;
            default:
                System.out.println("Wrong Choice");
                break;
        }
    }
}