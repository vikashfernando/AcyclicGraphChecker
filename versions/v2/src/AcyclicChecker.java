/*
 Name: Vikash Fernando
 Student ID: 20232055
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AcyclicChecker{

    public static boolean checkAcyclic(DirectedGraph originalGraph){

        // Make a copy so the original graph stays safe
        DirectedGraph workingGraph = originalGraph.copy();

        System.out.println("Starting sink elimination...");
        System.out.println();

        int step=1;

        while(!workingGraph.isEmpty()){
            Integer sink=workingGraph.findSink();

            if(sink == null){
                System.out.println("Step " + step + ": No sink found.");
                System.out.println("So the graph contains a cycle.");
                return false;
            }

            System.out.println("Step " + step + ": Sink found = " + sink);
            System.out.println("Removing sink " + sink);
            workingGraph.removeVertex(sink);

            System.out.println("Remaining vertices: " + workingGraph.size());
            System.out.println();

            step++;
        }

        System.out.println("The graph became empty after removing sinks.");
        System.out.println("So the graph is acyclic.");
        return true;
    }

    public static void printCycle(DirectedGraph graph) {
        List<Integer> cycle = findCycle(graph);

        if(cycle.isEmpty()){
            System.out.println("Cycle was not printed.");
            System.out.println("But the graph is cyclic because sink elimination failed.");
        }else{
            System.out.println("One cycle found:");
            for(int i = 0; i < cycle.size(); i++){
                System.out.print(cycle.get(i));
                if(i < cycle.size() - 1){
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public static List<Integer> findCycle(DirectedGraph graph){
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inStack = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();

        for(Integer vertex : graph.getVertices()){
            if(!visited.contains(vertex)){
                List<Integer> cycle = dfsFindCycle(vertex, graph, visited, inStack, parent);
                if(!cycle.isEmpty()){
                    return cycle;
                }
            }
        }

        return new ArrayList<>();
    }

    private static List<Integer> dfsFindCycle(
            Integer current,
            DirectedGraph graph,
            Set<Integer> visited,
            Set<Integer> inStack,
            Map<Integer, Integer> parent){

        visited.add(current);
        inStack.add(current);

        for(Integer neighbour : graph.getNeighbours(current)){

            if(!visited.contains(neighbour)){
                parent.put(neighbour, current);

                List<Integer> cycle = dfsFindCycle(neighbour, graph, visited, inStack, parent);
                if(!cycle.isEmpty()){
                    return cycle;
                }

            } else if(inStack.contains(neighbour)){
                return buildCycle(current, neighbour, parent);
            }
        }

        inStack.remove(current);
        return new ArrayList<>();
    }

    private static List<Integer> buildCycle(Integer current, Integer start, Map<Integer, Integer> parent){
        List<Integer> reversePath = new ArrayList<>();
        reversePath.add(start);

        Integer temp = current;
        while(temp != null && !temp.equals(start)){
            reversePath.add(temp);
            temp = parent.get(temp);
        }

        reversePath.add(start);

        List<Integer> cycle = new ArrayList<>();
        for(int i = reversePath.size() - 1; i >= 0; i--){
            cycle.add(reversePath.get(i));
        }

        return cycle;
    }
}