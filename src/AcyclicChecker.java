import java.util.*;

public class AcyclicChecker {

    public static boolean checkAcyclic(DirectedGraph graph) {

        while (!graph.isEmpty()) {

            Integer sink = graph.findSink();

            if (sink == null) {
                return false; // no sink → cycle exists
            }

            System.out.println("Removing sink: " + sink);
            graph.removeNode(sink);
        }

        return true;
    }

    // Simple cycle print (basic)
    public static void printCycle(DirectedGraph graph) {
        System.out.println("Cycle exists in graph (example path may exist).");
    }
}