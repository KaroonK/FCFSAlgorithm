/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfsalgorithm;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * OS 439 - Dr. Tang Assignment 2 Scheduling Algorithm Karoon Khatiwada
 */
public class FCFSAlgorithm {

    static Process[] TotalProcess;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Select 1 to read from input file \nSelect 2 to specify number of processes\nInput: ");
        int n = 0;
        while (true) {
            String input = read.next();
            try {
                n = Integer.parseInt(input);
                if (n != 1 && n != 2) {
                    System.out.print("Input has to be a 1 or a 2\nInput: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("This is not an Integer!\nInput: ");
            }
        }

        switch (n) {
            case 1:
                printProcesses(FCFS(readFile()));
                break;
            case 2:
                System.out.print("Please enter the number of Processes (Less than 20): ");
                while (true) {
                    String input = read.next();
                    try {
                        n = Integer.parseInt(input);
                        if (n<0 || n>20) {
                            System.out.print("Input has to be less than 20 greater than 0\nInput: ");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("This is not an Integer!\nInput: ");
                    }
                }
                printProcesses(FCFS(userInputProcess(n)));
                break;

        }
    }
//Read the input file
    static Process[] readFile() {
        int counter = -1;
        Scanner readInput = null;
        try {
            readInput = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        int numProcesses = readInput.nextInt();
        Process[] TotalProcess = new Process[numProcesses];
        while (readInput.hasNext()) {
            counter++;
            TotalProcess[counter] = new Process(counter + 1, readInput.nextInt(), readInput.nextInt());
        }
        readInput.close();
        return TotalProcess;
    }
//Arrival Time between 0 and 10 and Burst Times between 0 and 50 for simplicity in this case
    static Process[] userInputProcess(int length) {
        Random rand = new Random();
        TotalProcess = new Process[length];
        for(int x = 0; x<length; x++){
            TotalProcess[x] = new Process(x+1,rand.nextInt(10), rand.nextInt(50));
        }
        return TotalProcess;
    }
//FCFS Algorithm
    static Process[] FCFS(Process[] TotalProcess) {
        TotalProcess[0].setWaitingTime(0);
        for (int x = 1; x < TotalProcess.length; x++) {
            TotalProcess[x].setWaitingTime(TotalProcess[x - 1].getwaitingTime() + TotalProcess[x - 1].getburstTime());
            TotalProcess[x].setWaitingTime(TotalProcess[x].getwaitingTime() - TotalProcess[x].getArrivalTime());
        }
        for (int x = 0; x < TotalProcess.length; x++) {
            TotalProcess[x].setTurnAroundTime(TotalProcess[x].getwaitingTime() + TotalProcess[x].getburstTime());
        }
        return TotalProcess;
    }
//Print out the process
    static void printProcesses(Process[] TotalProcess) {
        System.out.println("Process ID\tArrival Time\tBurst Time\tTurnaround Time\tWaiting Time");
        for (int x = 0; x < TotalProcess.length; x++) {
            TotalProcess[x].print();
            System.out.println();
        }
    }

    static int getNum() {
        Scanner read = new Scanner(System.in);
        int n = -1;

        read.close();
        return 0;
    }
}
