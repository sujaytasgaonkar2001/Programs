import java.util.Scanner;
class StackDemo {
    int capacity = 3;
    int arr[] = new int[capacity];
    int top = -1;
    public void push(int pushedElement) {
        if (top < capacity - 1) {
            top++;
            arr[top] = pushedElement;
            System.out.println("Element " + pushedElement + " is pushed into Stack!");
            }
            else {
                System.out.println("Stack Overflow !");
            }
        }
        public void pop() {
            if (top >= 0) {
                top--;
                System.out.println("Pop operation is successfull !\n");
                System.out.println("Popped element is : " + arr[top + 1]);
            } else {
                System.out.println("Stack Underflow !");
            }
        }
        public void Display() {
            if (top >= 0) {
                System.out.println("Elements in stack :");
                //for (int i = 0; i <= top; i++) 
                for (int i = top; i >= 0; i--) {
                    System.out.print(arr[i]+"\t");
                }
                System.out.println();
            } else {
                System.out.println("Stack is empty");
            }
        }
    }
    public class stack {
        public static void main(String[] args) {
                StackDemo stackDemo = new StackDemo();
                Scanner in = new Scanner(System.in);
                while (true) {
                    System.out.println("Enter Your Choice");
                    System.out.println("1.PUSH \n2.POP \n3.DISPLAY \n4.EXIT ");
                        int Choice = in .nextInt();
                        switch (Choice) {
                            case 1:
                                System.out.println("Enter Number to be pushed:-"); 
                                    int Number = in .nextInt(); stackDemo.push(Number);
                                    break;
                                    case 2:
                                        stackDemo.pop();
                                        break;
                                    case 3:
                                        stackDemo.Display();
                                        break;
                                    case 4:
                                        System.exit(0);
                                    default:
                                        System.out.println("Invalid Choice");
                                }
                        }
                    }
                }