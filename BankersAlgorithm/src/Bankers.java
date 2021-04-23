import java.util.Scanner;

public class Bankers {

    static int need[][];
    static int alloResources[][];
    static int max[][];
    static int avaiResources[][];
    static int numProcesses;
    static int numResources;

    public static void main(String[] args) {

        checkSafety();
    }

    private static void userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter no. of processes: ");

        numProcesses = scanner.nextInt(); //Accept value for no. of process
        System.out.print("Enter no. of resources: ");

        numResources = scanner.nextInt(); //Accept value for no. of resources



        need = new int[numProcesses][numResources];
        max = new int[numProcesses][numResources];
        alloResources = new int[numProcesses][numResources];
        avaiResources = new int[1][numResources];

        // Accept values for Allocation
        System.out.println("Enter allocation matrix -->");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Row " + (i + 1) + " (P" + i + "): ");
            for (int j = 0; j < numResources; j++) {
                alloResources[i][j] = scanner.nextInt();
            }
        }

        //Accept values for Max Matrix
        System.out.println("Enter max matrix -->");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Row " + (i + 1) + " (P" + i + "): ");
            for (int j = 0; j < numResources; j++) {
                max[i][j] = scanner.nextInt();
            }
        }

        //Accept values for available matrix
        System.out.println("Enter available matrix -->");
        for (int j = 0; j < numResources; j++)
            avaiResources[0][j] = scanner.nextInt();

        scanner.close();

        // Display all matrices
        System.out.println("\nAllocation Matrix:");
        printArray(alloResources);
        System.out.println("\nMax Matrix:");
        printArray(alloResources);
        System.out.println("\nNeed Matrix:");
        printArray(CalcNeed());
    }
    //Display output method
    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println(" ");
    }

    //
    private static int[][] CalcNeed() {
        for (int i = 0; i < numProcesses; i++)
            for (int j = 0; j < numResources; j++)
                // calculating need matrix
                need[i][j] = max[i][j] - alloResources[i][j];
        return need;
    }

    private static boolean check_allocatable(int i) {
        // checking if all resources for ith process can be allocated
        for (int j = 0; j < numResources; j++)
            if (avaiResources[0][j] < need[i][j])
                return false;
        return true;
    }

    public static void checkSafety() {
        userInput();
        CalcNeed();
        boolean done[] = new boolean[numProcesses];
        int j = 0;

        while (j < numProcesses) { // until all process allocated
            boolean allocated = false;
            for (int i = 0; i < numProcesses; i++)
                if (!done[i] && check_allocatable(i)) { // trying to allocate

                    for (int k = 0; k < numResources; k++)
                        avaiResources[0][k] = avaiResources[0][k]
                                - need[i][k] + max[i][k];
                    System.out.println("Allocated process : " + i);
                    allocated = done[i] = true;
                    j++;
                }
            if (!allocated) // no allocation
                break;
        }
        if (j == numProcesses) // all processes are allocated
            System.out.println("\nSAFE STATE!");
        else
            System.out.println("DEADLOCK!");
    }
}
