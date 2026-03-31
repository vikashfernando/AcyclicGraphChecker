/*
 Name: Vikash Fernando
 Student ID: 20232055
 */

public class Main{
    public static void main(String[] args){
        boolean isAcyclic;

        //**********************************
        // Change file name here to test
        String fileName = "input1.txt";
        //**********************************

        DirectedGraph graph=GraphFileReader.readGraph(fileName);
        System.out.println("Reading graph...");
        isAcyclic = AcyclicChecker.checkAcyclic(graph);

        if (isAcyclic) {
            System.out.println("Graph is ACYCLIC (YES)");
        } else {
            System.out.println("Graph has a CYCLE (NO)");
            AcyclicChecker.printCycle(graph);
        }
    }
}