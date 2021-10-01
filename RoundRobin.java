import java.util.*;
public class RoundRobin {
    static void findWaitingTime(int processes[], int n,
                                int burstTime[], int waitingTime[], int quantum) {

        int remainingBurstTime[] = new int[n];
        for (int i = 0; i < n; i++)
            remainingBurstTime[i] = burstTime[i];

        int t = 0;

        while (true) {
            boolean done = true;

            for (int i = 0; i < n; i++) {

                if (remainingBurstTime[i] > 0) {
                    done = false;

                    if (remainingBurstTime[i] > quantum) {

                        t += quantum;

                        remainingBurstTime[i] -= quantum;
                    } else {

                        t = t + remainingBurstTime[i];

                        waitingTime[i] = t - burstTime[i];

                        remainingBurstTime[i] = 0;
                    }
                }
            }

            if (done == true)
                break;
        }
    }

    static void findTurnAroundTime(int processes[], int n,
                                   int burstTime[], int waitingTime[], int turnAroundTime[]) {
        for (int i = 0; i < n; i++)
            turnAroundTime[i] = burstTime[i] + waitingTime[i];
    }

    static void findavgTime(int processes[], int n, int burstTime[],
                            int quantum) {
        int waitingTime[] = new int[n], turnAroundTime[] = new int[n];
        int totalWaitingTime = 0, totalTurnAroundTime = 0;

        findWaitingTime(processes, n, burstTime, waitingTime, quantum);

        findTurnAroundTime(processes, n, burstTime, waitingTime, turnAroundTime);

        System.out.println("Processes " + " Burst time " +
                " Waiting time " + " Turn around time");

        for (int i = 0; i < n; i++) {
            totalWaitingTime = totalWaitingTime + waitingTime[i];
            totalTurnAroundTime = totalTurnAroundTime + turnAroundTime[i];
            System.out.println(" " + (i + 1) + "\t\t" + burstTime[i] + "\t " +
                    waitingTime[i] + "\t\t " + turnAroundTime[i]);
        }

        System.out.println("Average waiting time = " +
                (float) totalWaitingTime / (float) n);
        System.out.println("Average turn around time = " +
                (float) totalTurnAroundTime / (float) n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i;
        System.out.println("Enter the number of Processes:");
        int n = in .nextInt();
        int processes[] = new int[n];
        int burstTime[] = new int[n];
        System.out.println("Enter the Processes:");
        for (i = 0; i < n; i++) {
            processes[i] = in .nextInt();
        }
        //int processes[] = { 1, 2, 3};
        int l = processes.length;

        System.out.println("Enter the Burst Time:");
        for (i = 0; i < n; i++) {
            burstTime[i] = in .nextInt();
        }
        //int burstTime[] = {10, 5, 8};
        in .close();
        int quantum = 2;
        findavgTime(processes, l, burstTime, quantum);
    }
}