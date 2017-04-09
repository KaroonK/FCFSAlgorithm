/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfsalgorithm;

/**
 *
 * @author Karoon Khatiwada
 */
public class Process {
    int processNum = 0, burstTime = 0, 
            arrivalTime = 0, turnaroundTime = 0, waitingTime = 0;
    Process(int processID, int arrival, int burst ){
        processNum = processID;
        burstTime = burst;
        arrivalTime = arrival;       
    }
    void setProcessNum(int num){ processNum = num;}
    void setBurstTime(int num) { burstTime = num;}
    void setArrivalTime(int num){ arrivalTime = num;}
    void setTurnAroundTime(int num){ turnaroundTime = num;}
    void setWaitingTime (int num) { waitingTime = num;} 
    int getProcessNum(){return processNum;}
    int getburstTime() {return burstTime;}
    int getArrivalTime(){return arrivalTime;}
    int getTurnAroundTime(){return turnaroundTime;}
    int getwaitingTime(){return waitingTime;}
    void print(){
        System.out.print(processNum + "\t\t" + arrivalTime+"\t\t"+burstTime+"\t\t"+turnaroundTime +"\t\t"+ waitingTime);
    }
}
