/*
 Name: Vikash Fernando
 Student ID: 20232055
 */

import java.util.*;

public class AcyclicChecker{
    public static boolean checkAcyclic(DirectedGraph graph){
        while (!graph.isEmpty()){
            Integer sink=graph.findSink();

            if (sink==null){
                return false; // no sink > it means cycle exists
            }
            System.out.println("Removing sink: " + sink);
            graph.removeNode(sink);
        }
        return true;
    }
    // Simple cycle print
    public static void printCycle(DirectedGraph graph){
        System.out.println("Cycle exists in graph (example path/paths exists)");
    }
}