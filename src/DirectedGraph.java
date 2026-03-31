import java.util.*;

public class DirectedGraph{
    private Map<Integer,List<Integer>>adjList;

    public DirectedGraph(){
        adjList=new HashMap<>();
    }

    public void addEdge(int from, int to){
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
    }

    public Map<Integer, List<Integer>> getGraph(){
        return adjList;
    }

    // Find sink
    public Integer findSink(){
        for (Integer node : adjList.keySet()){
            if (adjList.get(node).isEmpty()){
                return node;
            }
        }
        return null;
    }

    // node remover
    public void removeNode(Integer node){
        adjList.remove(node);

        for (List<Integer> edges : adjList.values()){
            edges.remove(node);
        }
    }

    public boolean isEmpty(){
        return adjList.isEmpty();
    }
}