/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfsalgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Karoon Khatiwada
 */
public class RRAlgorithm {
    public static void main (String []args){
        Process [] P = readFile();
        
    }
    static Process[] readFile() {
        int counter = -1;
        Scanner readInput = null;
        try {
            readInput = new Scanner(new File("inputRoundRobin.txt"));
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
}

