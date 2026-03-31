public class Main {
    public static void main(String[] args) {

        // Change file name here to test
        String fileName = "input2.txt";

        DirectedGraph graph = GraphFileReader.readGraph(fileName);

        System.out.println("Checking graph...");

        boolean isAcyclic = AcyclicChecker.checkAcyclic(graph);

        if (isAcyclic) {
            System.out.println("Graph is ACYCLIC (YES)");
        } else {
            System.out.println("Graph has a CYCLE (NO)");
            AcyclicChecker.printCycle(graph);
        }
    }
}