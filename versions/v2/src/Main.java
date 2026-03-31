/*
 Name: Vikash Fernando
 Student ID: 20232055
 */

public class Main{
    public static void main(String[] args){


        //************************************
        // Change this file name to test graphs
        String fileName="input2.txt";
        //************************************


        DirectedGraph graph=GraphFileReader.readGraph(fileName);

        System.out.println("====================================");
        System.out.println("DIRECTED GRAPH ACYCLICITY CHECKER");
        System.out.println("Input file: " + fileName);
        System.out.println("====================================");
        System.out.println();

        System.out.println("Original graph:");
        graph.printGraph();
        System.out.println();

        boolean isAcyclic=AcyclicChecker.checkAcyclic(graph);

        System.out.println();
        System.out.println("Final answer:");
        if(isAcyclic){
            System.out.println("YES - The graph is acyclic.");
        }else{
            System.out.println("NO - The graph is not acyclic.");
            System.out.println();
            AcyclicChecker.printCycle(graph);
        }
    }
}