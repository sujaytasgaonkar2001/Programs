import java.util.Scanner;

class twoStacks {
    int capacity = 5;
    int arr[] = new int[capacity];
    int top1 = -1;
    int top2 = capacity;


    public void push1(int pushedElement) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = pushedElement;
            System.out.println("Element " + pushedElement + " is pushed into stack");
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public void pop1() {
        if (top1 >= 0) {
            top1--;
            System.out.println("Pop operation is successful!");
            System.out.println("Popped element is " + arr[top1 + 1]);
        } else {
            System.out.println("Stack Underflow");
        }
    }

    public void push2(int pushedElement) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = pushedElement;
            System.out.println("Element " + pushedElement + " is pushed into stack");
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public void pop2() {
        if (top2 < capacity) {
            top2++;
            System.out.println("Pop operatio is successful!");
            System.out.println("Popped element is " + arr[top2 - 1]);
        } else {
            System.out.println("Stack Underflow");
        }
    }
    public void Display1() {
        if (top1 >= 0) {
            System.out.println("Elements of stack are");
            for (int i = top1; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        } else {
            System.out.println("Stack is Empty");
        }

    }
    public void Display2() {
        if (top2 >= 0) {
            System.out.println("Elements of stack are");
            for (int i = top2; i < capacity; i++) {
                System.out.println(arr[i]);
            }
        } else {
            System.out.println("Stack is Empty");
        }

    }
}


public class program1b {
    public static void main(String[] args) {
        twoStacks tS = new twoStacks();
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice :");
            System.out.println("1.Push1\n2.Pop1\n3.Display1\n4.Push2\n5.Pop2\n6.Display2\n7.Exit");
            int choice = read.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number to be pushed :");
                    int num1 = read.nextInt();
                    tS.push1(num1);
                    break;
                case 2:
                    tS.pop1();
                    break;
                case 3:
                    tS.Display1();
                    break;
                case 4:
                    System.out.println("Enter the number to be pushed :");
                    int num2 = read.nextInt();
                    tS.push2(num2);
                    break;
                case 5:
                    tS.pop2();
                    break;
                case 6:
                    tS.Display2();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");

            }

        }
    }
}