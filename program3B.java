import java.util.Random;

class SquareThread implements Runnable {
    int x;
    Random r3;
    int num3 = 0;
    SquareThread(int x) {
        this.x = x;
    }
    public void run() {
        r3 = new Random();
        num3 = r3.nextInt(100);
        System.out.println("Thread Name:Square Thread and Square of " + num3 + " is: " + num3 * num3);
    }
}

class CubeThread implements Runnable {
    int x;
    Random r2;
    int num2 = 0;
    CubeThread(int x) {
        this.x = x;
    }
    public void run() {
        r2 = new Random();
        num2 = r2.nextInt(100);
        System.out.println("Thread Name:Cube Thread and Cube of " + num2 + " is: " + num2 * num2 * num2);
    }
}
class RandomThread implements Runnable {
    String tname;
    Random r;
    Thread t1, t2;
    public void run() {
        int num = 0;
        r = new Random();
        try {
            while (true) {
                num = r.nextInt(100);
                System.out.println("Main Thread and Generated Number is " + num);
                t1 = new Thread(new SquareThread(num));
                t1.start();
                t2 = new Thread(new CubeThread(num));
                t2.start();
                Thread.sleep(1000);
                System.out.println("--------------------------------------");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

public class program3B {
    public static void main(String[] args) {
        RandomThread a = new RandomThread();
        Thread threadx = new Thread(a);
        threadx.start();
    }
}