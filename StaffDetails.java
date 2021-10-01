import java.util.Scanner;

class Staff {
    public String StaffID;
    public String Name;
    public String Phone;
    public String Salary;
    
    Scanner input = new Scanner(System.in);
    
    void read() {
        System.out.println("Enter StaffID");
        StaffID = input.nextLine();
        System.out.println("Enter Name");
        Name = input.nextLine();
        System.out.println("Enter Phone");
        Phone = input.nextLine();
        System.out.println("Enter Salary");
        Salary = input.nextLine();
    }
    
    void display() {
        System.out.format("%-15s", "STAFFID: ");
        System.out.format("%-15s", StaffID);
        System.out.println();
        System.out.format("%-15s", "NAME: ");
        System.out.format("%-15s", Name);
        System.out.println();
        System.out.format("%-15s", "PHONE:");
        System.out.format("%-15s", Phone);
        System.out.println();
        System.out.format("%-15s", "SALARY:");
        System.out.format("%-15s", Salary);
        System.out.println();
    }
}

class TeachingStaff extends Staff {
	
    public String Domain; 
    public String Publication;
    
    void readTeachingStaffDetails() {
        super.read();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Domain");
        Domain = input.nextLine();
        System.out.println("Enter Publication");
        Publication = input.nextLine();
    }
    
    void display() {
        System.out.println();
        super.display();
        System.out.format("%-15s", "DOMAIN:");
        System.out.format("%-15s", Domain);
        System.out.println();
        System.out.format("%-15s", "PUBLICATION:");
        System.out.format("%-15s", Publication);
        System.out.println();
    }
}

class TechnicalStaff extends Staff {
    public String Skills;
    
    void readTechnicalStaffDetails() {
        super.read();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Skills");
        Skills = input.nextLine();
    }
    void display() {
        System.out.println();
        super.display();
        System.out.format("%-15s", "SKILLS:");
        System.out.format("%-15s", Skills);
        System.out.println();
    }
}

class ContractStaff extends Staff {
    String Period;
    void readContractStaffDetails() {
        super.read();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Period");
        Period = input.nextLine();
    }
    void display() {
        System.out.println();
        super.display();
        System.out.format("%-15s", "PERIOD:");
        System.out.format("%-15s", Period);
        System.out.println();
    }
}

class Staffdetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of staff details to be created");
        int n = input.nextInt();
        TeachingStaff teachingStaffs[] = new TeachingStaff[n];
        TechnicalStaff technicalStaffs[] = new TechnicalStaff[n];
        ContractStaff contractStaffs[] = new ContractStaff[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Teaching staff information");
            TeachingStaff teachStaff = new TeachingStaff();            		
            teachStaff.readTeachingStaffDetails();
            teachingStaffs[i] = teachStaff;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Technical staff information");
            technicalStaffs[i] = new TechnicalStaff();
            technicalStaffs[i].readTechnicalStaffDetails();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Contract staff information");
            contractStaffs[i] = new ContractStaff();
            contractStaffs[i].readContractStaffDetails();
        }
        System.out.println("Staff Details:");
        System.out.println();
        System.out.println("-----TEACHING STAFF DETAILS-----");
        for (int i = 0; i < n; i++) {
            teachingStaffs[i].display();
        }
        System.out.println();
        System.out.println("-----TECHNICAL STAFF DETAILS-----");
        for (int i = 0; i < n; i++) {
            technicalStaffs[i].display();
        }
        System.out.println();
        System.out.println("-----CONTRACT STAFF DETAILS-----");
        for (int i = 0; i < n; i++) {
            contractStaffs[i].display();
        }
    }
}
